package com.numble.dogbackendserver.service;

import com.numble.dogbackendserver.model.Dog;
import com.numble.dogbackendserver.repository.DogRedisRepository;
import com.numble.dogbackendserver.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogUpdateService {
    private final DogRedisRepository dogRedisRepository;
    private final DogRepository dogRepository;

    @KafkaListener(topics = "vote")
    public void increaseVote(String mes) {
        log.info("MES + " + mes);
        Long dogId = Long.parseLong(mes);
        log.info("increase Vote" + dogId);
        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new RuntimeException("Dog not found"));
        dog.setVoteCount(dog.getVoteCount() + 1);
        log.info("increase Vote" + dog.getVoteCount());
        dogRepository.save(dog);
        dogRedisRepository.findById(dogId).ifPresent(
                dogRedis -> {
                    log.info(dogRedis.toString());


                    dogRedis.setVoteCount(dogRedis.getVoteCount() + 1);
                   log.info("increase Vote" + dogRedis.getVoteCount());
                    dogRedisRepository.save(dogRedis);
                }
        );
    }

    @KafkaListener(topics = "unvote")
    public void decreaseVote(String message) {
        log.info("MES + " + message);
        Long dogId = Long.parseLong(message);
        log.info("decrease Vote" + dogId);

        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new RuntimeException("Dog not found"));
        dog.setVoteCount(dog.getVoteCount() - 1);
        log.info("decrease Vote" + dog.getVoteCount());
        dogRepository.save(dog);

        dogRedisRepository.findById(dogId).ifPresent(
                dogRedis -> {
                    if (dogRedis.getVoteCount() == 0) {
                        dogRedisRepository.delete(dogRedis);
                        return;
                    }
                    dogRedis.setVoteCount(dogRedis.getVoteCount() - 1);
                    log.info("decrease Vote" + dogRedis.getVoteCount());
                    dogRedisRepository.save(dogRedis);
                }
        );
    }
}

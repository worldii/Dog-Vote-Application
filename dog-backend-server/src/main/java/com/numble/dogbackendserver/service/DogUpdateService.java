package com.numble.dogbackendserver.service;

import com.numble.dogbackendserver.model.Dog;
import com.numble.dogbackendserver.repository.DogRedisRepository;
import com.numble.dogbackendserver.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DogUpdateService {
    private final DogRedisRepository dogRedisRepository;
    private final DogRepository dogRepository;
    private final DogKafKaVoteCompleteService dogKafKaVoteCompleteService;
    @KafkaListener(topics = "vote")
    public void increaseVote(String mes) {
        log.info("MES + " + mes);

        Long dogId = Long.parseLong(mes);
        dogRedisRepository.findById(dogId).ifPresent(
                dogRedis -> {
                    log.info(dogRedis.toString());
                    dogRedis.setVoteCount(dogRedis.getVoteCount() + 1);
                    log.info("increase Vote" + dogRedis.getVoteCount());
                    dogRedisRepository.save(dogRedis);
                }
        );

        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new RuntimeException("Dog not found"));
        dogKafKaVoteCompleteService.sendVoteComplete(dog.getVoteCount() + 1);
        dog.setVoteCount(dog.getVoteCount() + 1);
        dogRepository.save(dog);
        log.info("KAFKA END");

    }

    @KafkaListener(topics = "unvote")
    public void decreaseVote(String message) {
        Long dogId = Long.parseLong(message);
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
        Dog dog = dogRepository.findById(dogId).orElseThrow(() -> new RuntimeException("Dog not found"));
        dogKafKaVoteCompleteService.sendVoteComplete(dog.getVoteCount()- 1);
        dog.setVoteCount(dog.getVoteCount() - 1);
        dogRepository.save(dog);
        log.info("KAFKA END");
    }
}

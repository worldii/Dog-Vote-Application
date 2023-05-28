package com.numble.dogbackendserver.service;

import com.numble.dogbackendserver.repository.DogRedisRepository;
import com.numble.dogbackendserver.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogUpdateService {
    private final DogRedisRepository dogRedisRepository;
    private final DogRepository dogRepository;

    public void increaseVote(Long dogId) {
        log.info("increase Vote" +  dogId);
        dogRepository.findById(dogId).ifPresent(
                dog -> {
                    dog.setVoteCount(dog.getVoteCount() + 1);
                    log.info("increase Vote" +  dog.getVoteCount());
                    dogRepository.save(dog);
                }
        );
        dogRedisRepository.findById(dogId).ifPresent(
                dogRedis -> {
                    dogRedis.setVoteCount(dogRedis.getVoteCount() + 1);
                    log.info("increase Vote" +  dogRedis.getVoteCount());
                    dogRedisRepository.save(dogRedis);
                }
        );
    }

    public void decreaseVote(Long dogId) {

        log.info("decrease Vote" +  dogId);
        dogRepository.findById(dogId).ifPresent(
                dog -> {
                    dog.setVoteCount(dog.getVoteCount() - 1);
                    log.info("decrease Vote" +  dog.getVoteCount());
                    dogRepository.save(dog);
                }
        );
        dogRedisRepository.findById(dogId).ifPresent(
                dogRedis -> {
                    dogRedis.setVoteCount(dogRedis.getVoteCount() - 1);
                    log.info("decrease Vote" +  dogRedis.getVoteCount());
                    dogRedisRepository.save(dogRedis);
                }
        );

    }
}

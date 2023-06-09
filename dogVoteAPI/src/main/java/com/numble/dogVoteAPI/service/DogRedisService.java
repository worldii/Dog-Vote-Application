package com.numble.dogVoteAPI.service;

import com.numble.dogVoteAPI.model.DogRedis;
import com.numble.dogVoteAPI.repository.DogRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogRedisService {

    private final DogRedisRepository dogRedisRepository;

    @Transactional
    public void saveDog(DogRedis dogRedis) {
        log.info("saveDogRedis");
        log.info(dogRedis.toString());
        dogRedisRepository.save(dogRedis);
    }

    @Transactional(readOnly = true)
    public DogRedis getDogRedis(Long id) {
        // 없으면 null 반환
        log.info("getDogRedis");
        log.info(dogRedisRepository.findById(id).toString());
        return dogRedisRepository.findById(id).orElse(null);
    }


}

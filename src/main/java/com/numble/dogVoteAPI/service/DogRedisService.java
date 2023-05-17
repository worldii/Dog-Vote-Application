package com.numble.dogVoteAPI.service;

import com.numble.dogVoteAPI.model.DogRedis;
import com.numble.dogVoteAPI.repository.DogRedisRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogRedisService {

    private final DogRedisRepository dogRedisRepository;

    @Transactional
    public void saveDog ( DogRedis dogRedis ) {
        dogRedisRepository.save(dogRedis);
    }


    @Transactional(readOnly = true)
    public DogRedis getDogRedis (Long dog_id ) {
       return dogRedisRepository.findById(dog_id).orElseThrow(() -> new RuntimeException("해당하는 강아지가 없습니다."));
    }

}

package com.numble.dogVoteAPI.repository;

import com.numble.dogVoteAPI.model.Dog;
import com.numble.dogVoteAPI.model.DogRedis;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DogRedisRepository extends CrudRepository<DogRedis, Long> {
    Page<Dog> findAll(Pageable pageable);
}

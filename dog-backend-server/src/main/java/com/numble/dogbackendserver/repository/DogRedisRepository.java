package com.numble.dogbackendserver.repository;


import com.numble.dogbackendserver.model.DogRedis;
import org.springframework.data.repository.CrudRepository;

public interface DogRedisRepository extends CrudRepository<DogRedis, Long>
{
}

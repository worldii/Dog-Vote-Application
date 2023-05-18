package com.numble.dogVoteAPI.repository;

import com.numble.dogVoteAPI.model.DogRedis;
import org.springframework.data.repository.CrudRepository;

public interface DogRedisRepository extends CrudRepository<DogRedis, Long>
{
}

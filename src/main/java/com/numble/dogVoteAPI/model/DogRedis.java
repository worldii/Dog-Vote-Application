package com.numble.dogVoteAPI.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;


@Getter
@RedisHash("dog")
public class DogRedis {
    @Id
    Long dog_id;

    String name;
    String imageUrl;
    Long voteCount;
    String description;
    String detail;
    @Builder
    public DogRedis(Long dog_id, String name, String imageUrl, Long voteCount, String description, String detail) {
        this.dog_id = dog_id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.voteCount = voteCount;
        this.description = description;
        this.detail = detail;
    }
}

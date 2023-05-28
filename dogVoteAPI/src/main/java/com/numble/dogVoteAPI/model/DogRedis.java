package com.numble.dogVoteAPI.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;


@Getter
@Setter
@RedisHash("dog")
public class DogRedis {
    @Id
    Long id;
    String name;
    String imageUrl;
    Long voteCount;
    String description;
    String detail;
    @Builder
    public DogRedis(Long id, String name, String imageUrl, Long voteCount, String description, String detail) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.voteCount = voteCount;
        this.description = description;
        this.detail = detail;
    }
}

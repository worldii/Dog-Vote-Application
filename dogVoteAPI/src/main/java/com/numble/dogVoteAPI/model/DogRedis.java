package com.numble.dogVoteAPI.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;


@Getter
@Setter
@ToString
@RedisHash("dog")
public class DogRedis {
    @Id
    Long id;
    String name;
    String imageUrl;
    long voteCount = 0;
    String description;
    String detail;

    @Builder
    public DogRedis(Long id, String name, String imageUrl, long voteCount, String description, String detail) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
        this.voteCount = voteCount;
        this.description = description;
        this.detail = detail;
    }
}

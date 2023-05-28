package com.numble.dogbackendserver.dto;

import com.numble.dogbackendserver.model.Dog;
import com.numble.dogbackendserver.model.DogRedis;

public class DogDetailResponseDto {
    private Long id;
    private String name;
    private String imageUrl;
    private Long voteCount;
    private String description;
    private String detail;

    public DogDetailResponseDto(Dog dog) {
        this.description = dog.getDescription();
        this.detail = dog.getDetail();
        this.id = dog.getId();
        this.imageUrl = dog.getImageUrl();
        this.name = dog.getName();
        this.voteCount = dog.getVoteCount();
    }

    public DogRedis toEntity() {
        return DogRedis.builder()
                .id(id)
                .name(name)
                .imageUrl(imageUrl)
                .voteCount(voteCount)
                .description(description)
                .detail(detail)
                .build();

    }
}

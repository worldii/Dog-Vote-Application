package com.numble.dogVoteAPI.dto;

import com.numble.dogVoteAPI.model.Dog;

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
}

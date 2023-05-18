package com.numble.dogVoteAPI.dto;

import com.numble.dogVoteAPI.model.Dog;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DogSimpleResponseDto {
    private Long id;
    private String name;
    private String imageUrl;
    private Long voteCount;
    private String description;

    public DogSimpleResponseDto(Dog dog) {
        this.description = dog.getDescription();
        this.id = dog.getId();
        this.imageUrl = dog.getImageUrl();
        this.name = dog.getName();
        this.voteCount = dog.getVoteCount();
    }
}

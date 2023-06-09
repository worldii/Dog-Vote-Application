package com.numble.dogbackendserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dogs")
public class Dog {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    String name;

    @Column(name="image_url")
    String imageUrl;

    @Column(name="vote_count")
    long voteCount;

    @Column(name="description")
    String description;

    @Column(name="detail")
    String detail;
    public void setVoteCount(Long count) {
        this.voteCount = count;
    }
}

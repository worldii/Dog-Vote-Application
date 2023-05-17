package com.numble.dogVoteAPI.controller;

import com.numble.dogVoteAPI.service.DogRedisService;
import com.numble.dogVoteAPI.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dogs")
public class DogApiController {
    private final DogRedisService dogRedisService;
    private final DogService dogService;


    @PostMapping("/vote")
    public void vote() {
        System.out.println("vote");
    }

    @PostMapping("/unvote")
    public void unvote() {

        System.out.println("unvote");
    }

    @GetMapping
    public void getDogs() {

        System.out.println("getDogs");
    }

    @GetMapping("/{id}")
    public void getDog() {
        System.out.println("getDog");
    }
}

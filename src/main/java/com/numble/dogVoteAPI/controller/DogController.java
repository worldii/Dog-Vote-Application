package com.numble.dogVoteAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dogs")
public class DogController {
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

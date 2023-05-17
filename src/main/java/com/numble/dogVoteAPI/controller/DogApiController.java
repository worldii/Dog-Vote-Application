package com.numble.dogVoteAPI.controller;

import com.numble.dogVoteAPI.dto.DogDetailResponseDto;
import com.numble.dogVoteAPI.service.DogRedisService;
import com.numble.dogVoteAPI.service.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dogs")
@Slf4j
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

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDog(@PathVariable Long id) {

        if (dogRedisService.getDogRedis(id) == null) {
            DogDetailResponseDto select = dogService.select(id);
            dogRedisService.saveDog(select.toEntity());
        }
        // else
        return ResponseEntity.ok(dogRedisService.getDogRedis(id));
    }
}

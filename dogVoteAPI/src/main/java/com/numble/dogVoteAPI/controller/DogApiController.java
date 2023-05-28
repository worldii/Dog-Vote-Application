package com.numble.dogVoteAPI.controller;

import com.numble.dogVoteAPI.dto.DogDetailResponseDto;
import com.numble.dogVoteAPI.dto.PageDto;
import com.numble.dogVoteAPI.service.DogKafkaService;
import com.numble.dogVoteAPI.service.DogRedisService;
import com.numble.dogVoteAPI.service.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dogs")
@Slf4j
public class DogApiController {
    private final DogRedisService dogRedisService;
    private final DogService dogService;
    private final DogKafkaService dogKafkaService;

    @PostMapping("/vote/{id}")
    public ResponseEntity<?> vote(@PathVariable Long id) {
        log.info("vote");
        dogKafkaService.sendVote(id);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        return ResponseEntity.ok(map);

    }

    @PostMapping("/unvote/{id}")
    public ResponseEntity<Map<String, Object>> unvote(@PathVariable Long id) {
        log.info("unvote");
        dogKafkaService.sendUnvote(id);
        Map<String, Object> map = new HashMap<>();
        map.put("message", "success");
        return ResponseEntity.ok(map);
    }

    @GetMapping
    public ResponseEntity<?> getDogs(@ModelAttribute PageDto pageDto) {
        log.info("pageDto: {}", pageDto);

        if (pageDto == null) {
            pageDto = new PageDto();
            pageDto.setPage(0);
            pageDto.setSize(10);
        }
        log.info("getDogs");
        log.info("pageDto: {}", pageDto);
        dogService.findAll(pageDto);
        return ResponseEntity.ok(dogService.findAll(pageDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDog(@PathVariable Long id) {
        if (dogRedisService.getDogRedis(id) == null) {
            log.info("getDogRedis is null");
            DogDetailResponseDto select = dogService.select(id);
            dogRedisService.saveDog(select.toEntity());
        }
        return ResponseEntity.ok(dogRedisService.getDogRedis(id));
    }

}

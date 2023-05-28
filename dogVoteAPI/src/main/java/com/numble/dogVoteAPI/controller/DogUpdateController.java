package com.numble.dogVoteAPI.controller;

import com.numble.dogVoteAPI.service.DogKafkaService;
import com.numble.dogVoteAPI.service.DogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/")
public class DogUpdateController {

    private final DogService dogService;
    private final DogKafkaService dogKafkaService;
}

package com.numble.dogbackendserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class DogKafKaVoteCompleteService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendVoteComplete(long dogCount) {
        log.info("sendVoteComplete ={}", dogCount);
        kafkaTemplate.send("voteComplete", Long.toString(dogCount));
    }
}

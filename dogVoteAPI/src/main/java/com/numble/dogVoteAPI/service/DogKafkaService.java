package com.numble.dogVoteAPI.service;

import com.numble.dogVoteAPI.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DogKafkaService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    public void sendVote(Long dogId) {
        log.info("sendVote", dogId);
        kafkaTemplate.send("vote", dogId.toString());
    }

    public void sendUnvote(Long dogId) {
        log.info("sendUnvote", dogId);
        kafkaTemplate.send("unvote", dogId.toString());
    }

    @KafkaListener(topics = "voteComplete")
    public void voteComplete(String dogCount) {
        log.info("voteComplete ={}", dogCount);
    }

}

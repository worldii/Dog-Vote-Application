package com.numble.dogVoteAPI.service;

import com.numble.dogVoteAPI.dto.DogDetailResponseDto;
import com.numble.dogVoteAPI.dto.DogSimpleResponseDto;
import com.numble.dogVoteAPI.dto.PageDto;
import com.numble.dogVoteAPI.model.Dog;
import com.numble.dogVoteAPI.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class DogService {
    private final DogRepository dogRepository;

    public Page<DogSimpleResponseDto> findAll(PageDto pageDto) {
        PageRequest pageRequest = PageRequest.of(pageDto.getPage(), pageDto.getSize());
        Page<Dog> all = dogRepository.findAll(pageRequest);
        log.info("Dog Service findAll");
        return all.map(DogSimpleResponseDto::new);
    }

    public DogDetailResponseDto select(Long id) {
        log.info("Dog Service select");
        Dog dog = dogRepository.findById(id).orElseThrow(() -> new RuntimeException("해당하는 강아지가 없습니다."));
        return new DogDetailResponseDto(dog);
    }



}

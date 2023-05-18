package com.numble.dogVoteAPI.service;

import com.numble.dogVoteAPI.dto.DogDetailResponseDto;
import com.numble.dogVoteAPI.dto.DogSimpleResponseDto;
import com.numble.dogVoteAPI.model.Dog;
import com.numble.dogVoteAPI.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DogService {

    private final DogRepository dogRepository;

    // findAll
    public List<DogSimpleResponseDto> findAll() {
        List<Dog> all = dogRepository.findAll();
        // all 을 DogSimpleResponseDto 로 변환
        log.info("Dog Service findAll");
        return all.stream().map(DogSimpleResponseDto::new).collect(Collectors.toList());
    }

    public DogDetailResponseDto select(Long id) {
        // Dog 을 DogDetailResponseDto 로 변환
        log.info("Dog Service select");
        Dog dog = dogRepository.findById(id).orElseThrow(()-> new RuntimeException("해당하는 강아지가 없습니다."));
        return new DogDetailResponseDto(dog);
    }


}

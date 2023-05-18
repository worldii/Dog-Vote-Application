package com.numble.dogVoteAPI.repository;

import com.numble.dogVoteAPI.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    Optional<Dog> findById(Long id);
}

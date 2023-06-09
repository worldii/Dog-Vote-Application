package com.numble.dogbackendserver.repository;


import com.numble.dogbackendserver.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    Optional<Dog> findById(Long id);
}

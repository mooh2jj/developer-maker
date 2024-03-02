package com.example.developermaker.repository;

import com.example.developermaker.entity.Developer;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


@Slf4j
@SpringBootTest
class DeveloperRepositoryTest {

    @Autowired
    private DeveloperRepository developerRepository;

    @Test
    void testPaging() {
        // Given
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id").descending());
        Page<Developer> result = developerRepository.findAll(pageable);
        // When
        log.info("result: {}", result);
        // Then
    }

}
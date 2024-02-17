package com.example.developermaker.controller;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.dto.response.DeveloperDetail;
import com.example.developermaker.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/developers")
@RequiredArgsConstructor
public class DeveloperController {

    private final DeveloperService developerService;

    @GetMapping
    public ResponseEntity<?> getDevelopers() {
        return new ResponseEntity<>(developerService.getDevelopers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDeveloper(
            @PathVariable Long id
    ) {
        log.info("id: {}", id);
        DeveloperDetail detail = developerService.getDeveloper(id);
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createDeveloper(
            @RequestBody DeveloperCreateRequest request
    ) {
        log.info("request: {}", request);
        developerService.create(request);
        return new ResponseEntity<>("create ok", HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDeveloper(
            @PathVariable Long id,
            @RequestBody DeveloperCreateRequest request
    ) {
        log.info("id: {}", id);
        log.info("request: {}", request);
        developerService.update(id, request);
        return new ResponseEntity<>("update ok", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateDeveloper(
            @PathVariable Long id
    ) {
        log.info("id: {}", id);
        developerService.delete(id);
        return new ResponseEntity<>("delete ok", HttpStatus.OK);
    }
}

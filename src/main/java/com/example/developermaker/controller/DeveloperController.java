package com.example.developermaker.controller;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
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

    @PostMapping
    public ResponseEntity<?> createDeveloper(
            @RequestBody DeveloperCreateRequest request
    ) {
        log.info("request: {}", request);
        developerService.create(request);
        return new ResponseEntity<>("create ok", HttpStatus.CREATED);
    }
}

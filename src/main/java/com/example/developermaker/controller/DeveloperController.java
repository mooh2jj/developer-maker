package com.example.developermaker.controller;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.dto.response.DeveloperDetail;
import com.example.developermaker.dto.response.DeveloperListDto;
import com.example.developermaker.service.DeveloperService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController // REST api를 처리하는 컨트롤러
@RequestMapping("/api/developers") // 요청 URL
@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성자로 만들어줌
public class DeveloperController {

    private final DeveloperService developerService;

    // 리스트 -> 페이징 -> 파라미터 : page-현재페이지넘버, size - 페이지1개당 데이터 갯수
    @GetMapping
    public ResponseEntity<?> getDevelopers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size

    ) {
        Page<DeveloperListDto> listDtos = developerService.getDevelopers(page, size);

        return new ResponseEntity<>(listDtos, HttpStatus.OK);
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

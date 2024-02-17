package com.example.developermaker.service;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.dto.response.DeveloperListDto;
import com.example.developermaker.entity.Developer;
import com.example.developermaker.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Transactional
    @Override
    public void create(DeveloperCreateRequest request) {
        log.info("create run...");
        developerRepository.save(Developer.of(request));
    }

    @Transactional(readOnly = true)
    @Override
    public List<DeveloperListDto> getDevelopers() {
        log.info("getDevelopers run...");

        return developerRepository.findAll().stream()
                .map(DeveloperListDto::of)
                .collect(Collectors.toList());
    }
}

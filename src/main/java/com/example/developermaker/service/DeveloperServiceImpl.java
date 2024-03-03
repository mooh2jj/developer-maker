package com.example.developermaker.service;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.dto.response.DeveloperDetail;
import com.example.developermaker.dto.response.DeveloperListDto;
import com.example.developermaker.entity.Developer;
import com.example.developermaker.repository.DeveloperRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public DeveloperDetail getDeveloper(Long id) {
        log.info("getDeveloper run... ");
        Developer developer = developerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        return DeveloperDetail.of(developer);
    }

//    @Transactional(readOnly = true)
//    @Override
//    public List<DeveloperListDto> getDevelopers() {
//        log.info("getDevelopers run...");
//
//        return developerRepository.findAll().stream()
//                .map(DeveloperListDto::of)
//                .collect(Collectors.toList());
//    }

    @Transactional(readOnly = true)
    @Override
    public Page<DeveloperListDto> getDevelopers(int page, int size, String name) {
        log.info("getDevelopers run...");

        Pageable pageable = PageRequest.of(page, size); // 내림차순 : 최신순
        return developerRepository.findList(pageable, name)
                .map(DeveloperListDto::of);
//        return developerRepository.findAll(pageable)
//                .map(DeveloperListDto::of);
    }

    @Transactional
    @Override
    public void update(Long id, DeveloperCreateRequest request) {
        log.info("update run");
        Developer developer = developerRepository.findById(id)
                .orElseThrow(RuntimeException::new);

        developer.update(request); // dirty checking

    }

    @Transactional
    @Override
    public void delete(Long id) {
        log.info("delete run...");
        Developer developer = developerRepository.findById(id)
                .orElseThrow(RuntimeException::new);
        developerRepository.delete(developer);
    }
}

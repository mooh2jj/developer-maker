package com.example.developermaker.service;

import com.example.developermaker.dto.response.DepartmentListDto;
import com.example.developermaker.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Transactional(readOnly = true)
    @Override
    public Page<DepartmentListDto> getDepartments(int page, int size, String name) {
        log.info("getDepartments run...");
        Pageable pageable = PageRequest.of(page, size);

        return departmentRepository.findList(pageable)
                .map(DepartmentListDto::of);
    }
}

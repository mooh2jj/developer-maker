package com.example.developermaker.service;

import com.example.developermaker.dto.response.DepartmentListDto;
import org.springframework.data.domain.Page;

public interface DepartmentService {
    Page<DepartmentListDto> getDepartments(int page, int size, String name);
}

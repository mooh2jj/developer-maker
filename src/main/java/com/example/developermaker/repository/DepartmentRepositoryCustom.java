package com.example.developermaker.repository;

import com.example.developermaker.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentRepositoryCustom {
    Page<Department> findList(Pageable pageable);
}

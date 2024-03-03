package com.example.developermaker.repository;

import com.example.developermaker.entity.Developer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DeveloperRepositoryCustom {
    Page<Developer> findList(Pageable pageable, String name);
}

package com.example.developermaker.service;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.dto.response.DeveloperDetail;
import com.example.developermaker.dto.response.DeveloperListDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DeveloperService {
    void create(DeveloperCreateRequest request);
    DeveloperDetail getDeveloper(Long id);

    Page<DeveloperListDto> getDevelopers(int page, int size);

    void update(Long id, DeveloperCreateRequest request);

    void delete(Long id);

}

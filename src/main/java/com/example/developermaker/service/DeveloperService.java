package com.example.developermaker.service;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.dto.response.DeveloperListDto;

import java.util.List;

public interface DeveloperService {
    void create(DeveloperCreateRequest request);

    List<DeveloperListDto> getDevelopers();
}

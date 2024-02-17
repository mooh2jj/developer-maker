package com.example.developermaker.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeveloperCategory {

    BACKEND("백앤드"),
    FRONTEND("프론트앤드"),
    DEVOPS("데브옵스"),
    ;

    private final String description;

}

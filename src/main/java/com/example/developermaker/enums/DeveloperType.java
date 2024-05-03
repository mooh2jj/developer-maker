package com.example.developermaker.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DeveloperType {

    NEWCOMER("신입"),      // experienceYear 1~ 2년
    JUNIOR("주니어"),      // experienceYear 3년 이상
    SENIOR("시니어"),      // experienceYear 7년 이상
    ;

    private final String description;

    // 경력년수에 따른 개발자 타입 지정
    public static DeveloperType of(Integer experienceYear) {
        if (experienceYear <= 2) {
            return NEWCOMER;
        } else if (experienceYear <= 6) {
            return JUNIOR;
        } else {
            return SENIOR;
        }
    }

}

package com.example.developermaker.dto.response;

import com.example.developermaker.entity.Developer;
import com.example.developermaker.enums.DeveloperCategory;
import com.example.developermaker.enums.DeveloperType;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Builder
@ToString
public class DeveloperListDto {

    private String name;

//    private DepartmentListDto department;  // 순환 참조 방지로 주석처리

    private DeveloperCategory category;

    private DeveloperType type;

    private Integer experienceYear;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;

    public static DeveloperListDto of(Developer developer) {
        return DeveloperListDto.builder()
                .name(developer.getName())
//                .department(DepartmentListDto.of(developer.getDepartment()))
                .category(developer.getCategory())
                .type(developer.getType())
                .experienceYear(developer.getExperienceYear())
                .createdAt(developer.getCreatedAt())
                .modifiedAt(developer.getModifiedAt())
                .build();
    }
}

package com.example.developermaker.dto.response;

import com.example.developermaker.entity.Department;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@Builder
@ToString
public class DepartmentListDto {

    private String name;
    private String location;
    private List<DeveloperListDto> developers;

    public static DepartmentListDto of(Department department) {
        return DepartmentListDto.builder()
                .name(department.getName())
                .location(department.getLocation())
                .developers(department.getDevelopers().stream().map(DeveloperListDto::of).toList())
                .build();
    }

}

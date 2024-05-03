package com.example.developermaker.dto.request;

import com.example.developermaker.enums.DeveloperCategory;
import com.example.developermaker.enums.DeveloperType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeveloperCreateRequest {

    private String name;

    private DeveloperCategory category;

//    private DeveloperType type;

    private Integer experienceYear;

}

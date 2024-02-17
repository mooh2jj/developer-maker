package com.example.developermaker.entity;

import com.example.developermaker.dto.request.DeveloperCreateRequest;
import com.example.developermaker.enums.DeveloperCategory;
import com.example.developermaker.enums.DeveloperType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "developer")
public class Developer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private DeveloperCategory category;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private DeveloperType type;

    @Column(name = "experience_year")
    private Integer experienceYear;

    // 빌더 팩토리 패턴
    @Builder
    public Developer(String name, DeveloperCategory category, DeveloperType type, Integer experienceYear) {
        this.name = name;
        this.category = category;
        this.type = type;
        this.experienceYear = experienceYear;
    }

    public static Developer of(DeveloperCreateRequest request) {
        return Developer.builder()
                .name(request.getName())
                .category(request.getCategory())
                .type(request.getType())
                .experienceYear(request.getExperienceYear())
                .build();
    }

}

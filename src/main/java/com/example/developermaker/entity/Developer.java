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

    @ManyToOne(fetch = FetchType.LAZY)
    private Department department;

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
    public Developer(String name, Department department, DeveloperCategory category, DeveloperType type, Integer experienceYear) {
        this.name = name;
        this.department = department;
        this.category = category;
        this.type = type;
        this.experienceYear = experienceYear;
    }

    public static Developer of(DeveloperCreateRequest request, Department department) {
        return Developer.builder()
                .name(request.getName())
                .department(department)
                .category(request.getCategory())
                .type(request.getType())
                .experienceYear(request.getExperienceYear())
                .build();
    }

    public void update(DeveloperCreateRequest request) {
        this.name = request.getName();
        this.category = request.getCategory();
        this.type = request.getType();
        this.experienceYear = request.getExperienceYear();
    }
}

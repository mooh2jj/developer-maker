package com.example.developermaker.repository;

import com.example.developermaker.entity.Department;
import com.example.developermaker.entity.QDepartment;
import com.example.developermaker.entity.QDeveloper;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.example.developermaker.entity.QDepartment.*;
import static com.example.developermaker.entity.QDeveloper.*;

@RequiredArgsConstructor
public class DepartmentRepositoryCustomImpl implements DepartmentRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<Department> findList(Pageable pageable) {

        QDepartment department = QDepartment.department;
        QDeveloper developer = QDeveloper.developer;

        // 페이징 -> content list + pageable + totalCount

        List<Department> departmentList = jpaQueryFactory
                .selectFrom(department)
//                .leftJoin(department.developers, developer).fetchJoin()
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .fetch();

        Long totalCount = jpaQueryFactory
                .select(department.count())
                .from(department)
                .fetchOne();

        return PageableExecutionUtils.getPage(departmentList, pageable, () -> totalCount);
    }
}

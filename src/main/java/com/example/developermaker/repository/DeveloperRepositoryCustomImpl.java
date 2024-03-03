package com.example.developermaker.repository;

import com.example.developermaker.entity.Developer;
import com.example.developermaker.entity.QDepartment;
import com.example.developermaker.entity.QDeveloper;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.example.developermaker.entity.QDepartment.*;
import static com.example.developermaker.entity.QDeveloper.*;

@Slf4j
@RequiredArgsConstructor
public class DeveloperRepositoryCustomImpl implements DeveloperRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;


    @Override
    public Page<Developer> findList(Pageable pageable, String name) {

        QDeveloper developer = QDeveloper.developer;
        QDepartment department = QDepartment.department;

        List<Developer> list = jpaQueryFactory
                .selectFrom(developer)
                .leftJoin(developer.department, department).fetchJoin()
                .where(
                        containsName(name)  // like %d%
//                                .or(developer.experienceYear.gt(3)) // grater than
//                                .or(developer.experienceYear.lt(30)) // less than

                )   // name=d -> d를 포함하는 이름을 조회 mysql like %d%
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(developer.id.desc())
                .fetch();

        Long totalCount = jpaQueryFactory
                .select(developer.count())
                .from(developer)
                .where(
                        containsName(name)
//                                .or(developer.experienceYear.gt(3)) // grater than
//                                .or(developer.experienceYear.lt(30)) // less than

                )   // name=d -> d를 포함하는 이름을 조회 mysql like %d%
                .fetchOne();

//        return new PageImpl<>(list, pageable, totalCount);
        return PageableExecutionUtils.getPage(list, pageable, () -> totalCount); // count query 최적화

    }

    private BooleanExpression containsName(String name) {
        if (!StringUtils.hasText(name)) {
            return null;
        }
        return developer.name.contains(name);
    }
}

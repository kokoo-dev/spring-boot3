package com.kokoo.springboot3.jpa;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import static com.kokoo.springboot3.jpa.QJpaSample.jpaSample;

@Repository
@RequiredArgsConstructor
public class JpaSampleRepositoryImpl {

    private final JPAQueryFactory jpaQueryFactory;

    public long countByName(String name) {
        return jpaQueryFactory.select(jpaSample.id)
                .from(jpaSample)
                .where(equalsName(name))
                .fetch()
                .size();
    }

    private BooleanExpression equalsName(String name) {
        if (ObjectUtils.isEmpty(name)) {
            return jpaSample.name.isNull();
        }

        return jpaSample.name.eq(name);
    }
}

package com.practice.springboot.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.practice.springboot.entity.Course;
import com.practice.springboot.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {
	
	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public Course find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
				
		if(exist) {
			Predicate prdicate2 = qCourse.id.eq(23);
			predicateBuilder.and(prdicate2);
		}else {
			Predicate prdicate3 = qCourse.name.endsWith("OP");
			predicateBuilder.or(prdicate3);
		}
		
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
	}
	
}

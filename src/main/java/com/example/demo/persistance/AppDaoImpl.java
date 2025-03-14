package com.example.demo.persistance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao{
	
	EntityManager entityManager;
	
	@Autowired
	public AppDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
	}

	@Override
	public Instructor findInstructorById(int id) {
		return entityManager.find(Instructor.class,id);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int id) {
		Instructor tempInstructor=entityManager.find(Instructor.class, id);
		entityManager.remove(tempInstructor);
	}

	@Override
	public InstructorDetail findInstructorDetailById(int id) {
		return entityManager.find(InstructorDetail.class, id);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int id) {
		InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class, id);
		//remove the associated object ref
		//break bi-directional lnik
		tempInstructorDetail.getInstructor().setInstructorDetail(null);
		entityManager.remove(tempInstructorDetail);
	}

}

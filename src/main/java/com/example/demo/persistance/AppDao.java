package com.example.demo.persistance;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;

public interface AppDao {
	void deleteInstructorDetailById(int id);
	InstructorDetail findInstructorDetailById(int id);
	void deleteInstructorById(int id);
	Instructor findInstructorById(int id);
	void save(Instructor theInstructor);
	
}

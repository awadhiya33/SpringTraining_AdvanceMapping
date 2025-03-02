package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetail;
import com.example.demo.persistance.AppDao;

@SpringBootApplication
public class SpringTrainingAdvanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTrainingAdvanceApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner comandLineRunner(AppDao appDao) {
		return runner->{
//			CreateInstructor(appDao);
//			findInstructor(appDao);
//			deleteInstructor(appDao);
//			findInstructorDetail(appDao);
			deleteInstructorDetail(appDao);
		};
	}
	
	private void deleteInstructorDetail(AppDao appDao) {
		int id=3;
		System.out.println("deleting InstructorDetail id: "+id);
		appDao.findInstructorDetailById(id);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDao appDao) {
		int id=1;
		System.out.println("Findling InstructorDetail by id : "+id);
		InstructorDetail tempInstructorDetail=appDao.findInstructorDetailById(id);
		System.out.println("tempInstructorDetail : "+tempInstructorDetail);
		System.out.println("the associated instructor : "+tempInstructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDao appDao) {
		int id=2;
		System.out.println("Deleting instructor bi id : "+id);
		appDao.deleteInstructorById(id);
		System.out.println("Done");
	}

	private void findInstructor(AppDao appDao) {
		int id=2;
		System.out.println("Finding Instructor By Id :"+id);
		Instructor tempInstructor=appDao.findInstructorById(id);
		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("the associate instructor details only : "+tempInstructor.getInstructorDetail());;
	}

	private void CreateInstructor(AppDao appDao) {
		Instructor tempInstructor=new Instructor("abhi","singh","abhi.harry33@gmail.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("https://abhi/youtube","cricket");
//		Instructor tempInstructor=new Instructor("amit","verma","amit.verma33@gmail.com");
//		InstructorDetail tempInstructorDetail=new InstructorDetail("https://zmit/youtube","guitar");
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		System.out.println("saving instructor"+tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("Done");
	}

}

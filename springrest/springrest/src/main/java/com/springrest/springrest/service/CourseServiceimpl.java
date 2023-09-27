package com.springrest.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;


@Service
public class CourseServiceimpl implements CourseService {

	@Autowired
	private CourseDao courseDao;
	
	List<Course> list;
	
	public CourseServiceimpl() {
		list = new ArrayList<>();
		list.add(new Course(145 , "Java Course" , "This course contains java basics"));
		list.add(new Course(146 , "Spring boot" , " Covers basics Spring boot concepts"));
	}
	
	@Override
	public List<Course> getCourses(){
		
		return courseDao.findAll();
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Course getCourse(long courseId) {
//		Course c = null;
//		
//		for(Course course : list) {
//			if(course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}
		 
		return courseDao.getOne(courseId);
		
	}

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		//list.add(course);
		courseDao.save(course);
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
//		list.forEach(e-> {
//			if(e.getId() == course.getId()) {
//				e.setTitle(course.getTitle());
//				e.setDescription(course.getDescription());
//			}
//		});
		
		//if the details will match with the existing entity then it will no do anything else it will add the course with new details
		courseDao.save(course);
		return course;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteCourse(long parseLong) {
		// TODO Auto-generated method stub
		//list=this.list.stream().filter(e->e.getId() != parseLong).collect(Collectors.toList());
		Course enity = courseDao.getOne(parseLong);
		courseDao.delete(enity);
	}
}

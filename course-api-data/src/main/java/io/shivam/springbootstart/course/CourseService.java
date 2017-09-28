package io.shivam.springbootstart.course;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Spring creates only a single instance of this service class and registers it. '@service' is used to do that.
 * 
 * @author shivam
 *
 */
@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getAllCourses(String id) {
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id)
					   .forEach(courses::add);
		return courses;
	}
			
	public Course getCourse(String id) {
		return courseRepository.findOne(id);
	}
	
	public void addCourse(Course course) {
		courseRepository.save(course);	
	}
	
	public void updateCourse(Course course) {
		courseRepository.save(course); //save method can perform both update and insert. If the course with id is already present in the database, then it will update the old course else insert a new row.
	}

	public void deleteCourse(String id) {
		courseRepository.delete(id);	
	}
}


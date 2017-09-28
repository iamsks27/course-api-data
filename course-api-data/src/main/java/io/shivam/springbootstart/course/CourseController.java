package io.shivam.springbootstart.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.shivam.springbootstart.topic.Topic;

@RestController
public class CourseController {

	/**
	 * '@autowired' annotation is to inject the instance of CourseService. Spring will look for course service class and assign its instance to courseService variable. As CourseService is marked as '@service', so there will be only one instance of it.
	 */
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable String courseId) {
		return courseService.getCourse(courseId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}

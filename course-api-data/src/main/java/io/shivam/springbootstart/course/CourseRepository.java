package io.shivam.springbootstart.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring data JPA has provided an generic interface 'CrudRepository<Entity, Id{data_type}>' which helps us to perfrom basic crud operations. So, we don't need to care about crud operations here. The field which we have marked as primary id(String id in our case) needs to implements serializable.
 * 
 * As we have defined to use embedded database (apache derby) in pom.xml, so we don't have to configure database configurations. Spring automatically use that embedded database to perform database related activities.
 * @author shivam
 *
 */
public interface CourseRepository extends CrudRepository<Course, String>{

	public List<Course> findByName(String name); //Only by declaring a method like this, spring data JPA knows how to get data based on property name. findBy{Property_Name_of_the_entity_class}
	public List<Course> findByDescription(String desc); //get courses whose description is equal to desc. Camel case is important.
	
	public List<Course> findByTopicId(String id); //Used this function to get topic info using topicId
}

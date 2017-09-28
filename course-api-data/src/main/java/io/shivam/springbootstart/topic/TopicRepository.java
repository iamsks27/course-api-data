package io.shivam.springbootstart.topic;

import org.springframework.data.repository.CrudRepository;

/**
 * Spring data JPA has provided an generic interface 'CrudRepository<Entity, Id{data_type}>' which helps us to perfrom basic crud operations. So, we don't need to care about crud operations here. The field which we have marked as primary id(String id in our case) needs to implements serializable.
 * 
 * As we have defined to use embedded database (apache derby) in pom.xml, so we don't have to configure database configurations. Spring automatically use that embedded database to perform database related activities.
 * @author shivam
 *
 */
public interface TopicRepository extends CrudRepository<Topic, String>{

}

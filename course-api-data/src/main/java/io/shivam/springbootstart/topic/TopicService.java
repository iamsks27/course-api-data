package io.shivam.springbootstart.topic;

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
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
					   .forEach(topics::add);
		return topics;
	}
			
	public Topic getTopic(String id) {
		return topicRepository.findOne(id);
	}
	
	public void addTopic(Topic topic) {
		topicRepository.save(topic);	
	}
	
	public void updateTopic(String id, Topic topic) {
		topicRepository.save(topic); //save method can perform both update and insert. If the topic with id is already present in the database, then it will update the old topic else insert a new row.
	}

	public void deleteTopic(String id) {
		topicRepository.delete(id);	
	}
}


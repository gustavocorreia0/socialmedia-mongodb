package com.project.socialmediamongodb.repositories;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.socialmediamongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

	//List<Post> findByTitleContainingIgnoreCase(String title);
	
}

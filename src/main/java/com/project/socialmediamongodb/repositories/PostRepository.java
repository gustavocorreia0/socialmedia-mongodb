package com.project.socialmediamongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.socialmediamongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{

}

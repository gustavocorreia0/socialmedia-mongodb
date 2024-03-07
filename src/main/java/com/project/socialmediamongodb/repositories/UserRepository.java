package com.project.socialmediamongodb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.socialmediamongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}

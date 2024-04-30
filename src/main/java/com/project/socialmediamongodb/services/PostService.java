package com.project.socialmediamongodb.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.socialmediamongodb.domain.Post;
import com.project.socialmediamongodb.repositories.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;

	public List<Post> findAll(){
		return postRepository.findAll();
	}
	
	public Post findById(String id) {
		return postRepository.findById(id).get();
	}

	public List<Post> findByTitle(String title){
		return postRepository.findByTitleContainingIgnoreCase(title);
	}
	public List<Post> fullsearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24*60*60*1000);
		return postRepository.fullsearch(text, minDate, maxDate);
	}
	
} 

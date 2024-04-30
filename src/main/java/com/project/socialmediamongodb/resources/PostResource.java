package com.project.socialmediamongodb.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.socialmediamongodb.domain.Post;
import com.project.socialmediamongodb.resources.util.URL;
import com.project.socialmediamongodb.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;

	@GetMapping
	public ResponseEntity<List<Post>> findAll(){
		return ResponseEntity.ok().body(postService.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		return ResponseEntity.ok().body(postService.findById(id));
		
	}
	
	@GetMapping(value="/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text") String text){
		return ResponseEntity.ok().body(postService.findByTitle(URL.decodeParameter(text)));
	}
	

	@GetMapping(value="/fullsearch")
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="text") String text,
			@RequestParam(value="minDate") String minDate,
			@RequestParam(value="maxDate") String maxDate
			){
		
		text = URL.decodeParameter(text);
		Date minimumDate = URL.convertDate(minDate, new Date(0L));
		Date maximumDate = URL.convertDate(minDate, new Date());
		
		return ResponseEntity.ok().body(postService.fullsearch(text, minimumDate, maximumDate));
	}
	
}

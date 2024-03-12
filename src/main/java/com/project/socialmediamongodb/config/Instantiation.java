package com.project.socialmediamongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.project.socialmediamongodb.domain.Post;
import com.project.socialmediamongodb.domain.User;
import com.project.socialmediamongodb.dto.AuthorDTO;
import com.project.socialmediamongodb.repositories.PostRepository;
import com.project.socialmediamongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		date.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User u1 = new User(null, "Gustavo Correia", "gustavoCorreiaa0@gmail.com");
		User u2 = new User(null, "Larissa Piva", "pivaalarissa@gmail.com");
		User u3 = new User(null, "Apollo Calleri", "apolloCalleri@gmail.com");
		User u4 = new User(null, "Salem Galoppo", "galoppoSalem@gmail.com");
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		Post p1 = new Post(null, date.parse("13/03/2024"), "Avanço na Aula", "Hoje eu aprendi muitas coisas!", new AuthorDTO(u1));
		Post p2 = new Post(null, date.parse("11/03/2024"), "Janta com marido", "Hoje fiz uma janta especial ao meu marido!", new AuthorDTO(u2));
		Post p3 = new Post(null, date.parse("12/03/2024"), "Quebrei um Vaso", "Consegui quebrar o vaso da mamãe...", new AuthorDTO(u4));
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3));
	
	}

}

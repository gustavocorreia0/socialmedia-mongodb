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
import com.project.socialmediamongodb.dto.CommentDTO;
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
		Post p2 = new Post(null, date.parse("13/03/2024"), "Meus gatos! <3", "Meus gatos se chamam Apollo e Salem!", new AuthorDTO(u1));
		Post p3 = new Post(null, date.parse("11/03/2024"), "Janta com marido", "Hoje fiz uma janta especial ao meu marido!", new AuthorDTO(u2));
		Post p4 = new Post(null, date.parse("12/03/2024"), "Quebrei um Vaso", "Consegui quebrar o vaso da mamãe...", new AuthorDTO(u4));
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
	
		u1.getPosts().addAll(Arrays.asList(p1, p2));
		u2.getPosts().addAll(Arrays.asList(p3));
		u4.getPosts().addAll(Arrays.asList(p4));
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
		
		CommentDTO c1 = new CommentDTO("O que você aprendeu?", date.parse("15/03/2024"), new AuthorDTO(u2));
		CommentDTO c2 = new CommentDTO("Tem que contar pra galera", date.parse("14/03/2024"), new AuthorDTO(u3));
		CommentDTO c3 = new CommentDTO("Aprendeu a usar DTO?", date.parse("15/03/2024"), new AuthorDTO(u4));
		CommentDTO c4 = new CommentDTO("o que você cozinhou???", date.parse("15/03/2024"), new AuthorDTO(u1));
		CommentDTO c5 = new CommentDTO("Queria um frango também", date.parse("15/03/2024"), new AuthorDTO(u4));
		CommentDTO c6 = new CommentDTO("Você é um animal", date.parse("15/03/2024"), new AuthorDTO(u3));
		
		p1.getComments().addAll(Arrays.asList(c1, c2, c3));
		p3.getComments().addAll(Arrays.asList(c4, c5));
		p4.getComments().addAll(Arrays.asList(c6));
		
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
	}

}

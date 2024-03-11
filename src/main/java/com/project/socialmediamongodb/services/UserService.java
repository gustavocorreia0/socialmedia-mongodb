package com.project.socialmediamongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.socialmediamongodb.domain.User;
import com.project.socialmediamongodb.dto.UserDTO;
import com.project.socialmediamongodb.repositories.UserRepository;
import com.project.socialmediamongodb.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User newUser) {
		return userRepository.insert(newUser);
	}
	
	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}
	
	public User update(User newUser) {
		User oldUser = userRepository.findById(newUser.getId()).get();
		User user = updateData(oldUser, newUser);
		return userRepository.save(user);
	}
	
	public User fromDTO(UserDTO userDataTransfer) {
		return new User(userDataTransfer.getId(), userDataTransfer.getName(), userDataTransfer.getEmail());
	}
	
	private User updateData(User user, User newUser) {
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		return user;
	}
	
}

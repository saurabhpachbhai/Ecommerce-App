package com.userapp.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.userapp.entity.UserData;
import com.userapp.repository.UserRepository;
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserData saveUser(UserData userData) {
		return userRepository.save(userData);
	}

	public List<UserData> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

}

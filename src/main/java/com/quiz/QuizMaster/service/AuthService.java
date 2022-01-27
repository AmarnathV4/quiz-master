package com.quiz.QuizMaster.service;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.QuizMaster.dto.RegisterRequest;
import com.quiz.QuizMaster.model.Users;
import com.quiz.QuizMaster.model.VerificationToken;
import com.quiz.QuizMaster.repository.UserRepository;
import com.quiz.QuizMaster.repository.VerificationTokenRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	@Autowired
	private VerificationTokenRepository verificationTokenRepository;
	
	@Transactional
	public String registerUser(RegisterRequest registerRequest) {
		
		Users user = userRepository.findByEmail(registerRequest.getEmail()).orElse(null);
		
		if (user != null) {
			return "Mail id is already in use!! Please try with another";
		}
		
		else {
			Users users = new Users();
			users.setUsername(registerRequest.getUsername());
			users.setPassword(registerRequest.getPassword());
			users.setEmail(registerRequest.getEmail());
			users.setCreated(Instant.now());
			users.setEnabled(false);
			String token = generateVerificationToken(users);
			System.out.println(token);
			userRepository.save(users);
			
			return "User Account has been created. Pending with verification";
			
		}
		
	}
	
	public String generateVerificationToken(Users user) {
		
		String token = UUID.randomUUID().toString();
		VerificationToken verificationToken = new VerificationToken();
		verificationToken.setEmail(user.getEmail());
		verificationToken.setToken(token);
 		verificationTokenRepository.save(verificationToken);
		return token;
		
	}

}

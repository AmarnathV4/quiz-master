package com.quiz.QuizMaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.QuizMaster.dto.LoginRequest;
import com.quiz.QuizMaster.dto.RegisterRequest;
import com.quiz.QuizMaster.service.AuthService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
    @PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody RegisterRequest registerRequest) {
    	return new ResponseEntity<String>(authService.registerUser(registerRequest), HttpStatus.CREATED);
		
	}
    
    @PostMapping("/login")
    public void login(@RequestBody LoginRequest loginRequest) {
    	
    }
    
    @GetMapping("/accountVerification/{token}")
    public void verifyAccount() {
    	
    }
    
    @PostMapping("/logout")
    public void logout() {
    	
    }
    
    
	
	

}

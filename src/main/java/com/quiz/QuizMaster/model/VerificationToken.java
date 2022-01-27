package com.quiz.QuizMaster.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class VerificationToken {
	
	@Id
	private String token;
	@Email 
	@NotBlank(message = "Email id is required")
	private String email;
	
	public VerificationToken(String token, @Email @NotBlank(message = "Email id is required") String email) {
		super();
		this.token = token;
		this.email = email;
	}

	public VerificationToken() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "VerificationToken [token=" + token + ", email=" + email + "]";
	}
	
	
	

}

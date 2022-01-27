package com.quiz.QuizMaster.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.QuizMaster.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
	
	public Optional<Users> findByEmail(String email);

}

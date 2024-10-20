package com.myproject.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.quizapp.entity.Question;
import com.myproject.quizapp.entity.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

	
}

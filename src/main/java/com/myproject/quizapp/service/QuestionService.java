package com.myproject.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myproject.quizapp.dao.QuestionDao;
import com.myproject.quizapp.entity.Question;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			
		return  new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		}
		
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsBydifficulty(String difficultylevel) {
		try {
		return new ResponseEntity<>(questionDao.findByDifficultylevel(difficultylevel), HttpStatus.OK);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST); 
	}

	public ResponseEntity<String> addQuestions(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Success", HttpStatus.CREATED);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Success", HttpStatus.BAD_REQUEST);
		
	}

}

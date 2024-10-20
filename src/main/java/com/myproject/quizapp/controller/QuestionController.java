package com.myproject.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.quizapp.entity.Question;
import com.myproject.quizapp.service.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/getallquestions")
	public ResponseEntity<List<Question>> getQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("/category/{cat}")
	public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable("cat") String category) {
		return questionService.getQuestionsByCategory(category);
	}
	
	@GetMapping("/difficulty/{diff}")
	public ResponseEntity<List<Question>> getQuestionsBydifficulty(@PathVariable("diff") String difficultylevel) {
		return questionService.getQuestionsBydifficulty(difficultylevel);
	}
	
	@PostMapping("/addquestions")
	public ResponseEntity<String> addQuestions(@RequestBody Question question) {	
		return questionService.addQuestions(question);
		 
	}

}

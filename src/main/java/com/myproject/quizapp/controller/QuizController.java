package com.myproject.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myproject.quizapp.entity.Question;
import com.myproject.quizapp.entity.QuestionWrapper;
import com.myproject.quizapp.entity.Response;
import com.myproject.quizapp.service.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("/createQuiz")
	public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numQ, @RequestParam String title) {
		return quizService.createQuiz(category, numQ, title);
	}
	
	@GetMapping("/getquestion/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
		return quizService.getQuizQuestions(id); 
		
	}
	
	@GetMapping("/submit/{id}")
	public ResponseEntity<Integer> submitAnswers(@PathVariable int id, @RequestBody List<Response> responses){
		return quizService.calculateResult(id, responses); 
		
	}
	
}




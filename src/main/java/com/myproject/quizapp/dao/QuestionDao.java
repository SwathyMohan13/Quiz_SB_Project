package com.myproject.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.quizapp.entity.Question;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer>{
	
	List<Question> findByCategory(String category);
	
	List<Question> findByDifficultylevel(String difficultylevel);

	@Query(value = "SELECT * FROM Question q WHERE q.category = ?1 ORDER BY RAND() LIMIT ?2", nativeQuery = true)
	List<Question> findQuizQuestionRandomByCategory(String category, int numQ);




}

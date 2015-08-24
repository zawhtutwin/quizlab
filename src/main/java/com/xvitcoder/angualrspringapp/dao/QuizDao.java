package com.xvitcoder.angualrspringapp.dao;

import java.util.List;

import com.xvitcoder.angualrspringapp.beans.Answer;
import com.xvitcoder.angualrspringapp.beans.Question;

public interface QuizDao {
	List<Integer> getAllQuestionId();
	List<Question> getQuestionAndAnswers(Integer questionId);
	List<Question> getAllQuestions();
	void addQuestion(Question newQuestion);
	void addAnswer(Answer newAnswer);
}

package com.xvitcoder.angualrspringapp.service;

import java.util.List;

import com.xvitcoder.angualrspringapp.beans.Question;

public interface QuizService {
	List<Integer> getAllQuestionId();
	List<Question> getQuestionAndAnswers(Integer questionId);
}

package com.xvitcoder.angualrspringapp.dao;

import java.util.List;

import com.xvitcoder.angualrspringapp.beans.Question;

public interface QuizDao {
	List<Integer> getAllQuestionId();
	List<Question> getQuestionAndAnswers(Integer questionId);
}

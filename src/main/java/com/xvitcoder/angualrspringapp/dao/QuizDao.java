package com.xvitcoder.angualrspringapp.dao;

import java.util.List;

import com.xvitcoder.angualrspringapp.beans.Answer;
import com.xvitcoder.angualrspringapp.beans.Question;
import com.xvitcoder.angualrspringapp.beans.QuestionPackage;

public interface QuizDao {
	List<Integer> getAllQuestionId();
	List<Question> getQuestionAndAnswers(Integer questionId);
	List<Question> getQuestionAndAnswersBySeq(Integer seq);
	List<Question> getAllQuestions();
	void addQuestion(Question newQuestion);
	void addAnswer(Answer newAnswer);
	void removeQuestion(Question question);
	void removeAnswer(Answer answer);
	QuestionPackage getQuestionPackageByName(String packageName);
}

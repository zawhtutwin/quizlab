package com.xvitcoder.angualrspringapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xvitcoder.angualrspringapp.beans.Answer;
import com.xvitcoder.angualrspringapp.beans.Question;
import com.xvitcoder.angualrspringapp.beans.QuestionPackage;
import com.xvitcoder.angualrspringapp.dao.QuizDao;
@Service("quizService")
public class QuizServiceImpl implements QuizService {

	@Autowired
	QuizDao quizDao;
	
	@Override
	public List<Integer> getAllQuestionId() {
		return quizDao.getAllQuestionId();
	}

	@Override
	public List<Question> getQuestionAndAnswers(Integer questionId) {
		return quizDao.getQuestionAndAnswers(questionId);
	}

	@Override
	public void addQuestion(Question newQuestion) {
		quizDao.addQuestion(newQuestion);
	}

	@Override
	public List<Question> getAllQuestions() {
		return quizDao.getAllQuestions();
	}

	@Override
	public void addAnswer(Answer newAnswer) {
		quizDao.addAnswer(newAnswer);
		
	}

	@Override
	public void removeQuestion(Question question) {
		quizDao.removeQuestion(question);
		
	}
	
	@Override
	public void removeAnswer(Answer answer) {
		quizDao.removeAnswer(answer);
	}

	@Override
	public List<Question> getQuestionAndAnswersBySeq(Integer seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QuestionPackage getQuestionPackageByName(String packageName) {
		return quizDao.getQuestionPackageByName(packageName);
	}

	@Override
	public List<QuestionPackage> getAllPackages() {
		return quizDao.getAllPackages();
	}

	@Override
	public QuestionPackage getQuestionPackage(Integer packageId) {
		return quizDao.getQuestionPackage(packageId);
	}
}

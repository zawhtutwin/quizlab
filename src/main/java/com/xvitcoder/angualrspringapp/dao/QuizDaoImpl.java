package com.xvitcoder.angualrspringapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xvitcoder.angualrspringapp.beans.Answer;
import com.xvitcoder.angualrspringapp.beans.Question;

@Repository("quizDao")
@Transactional(value = "transactionManager",propagation = Propagation.REQUIRES_NEW)
public class QuizDaoImpl implements QuizDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Integer> getAllQuestionId() {
		return entityManager.createQuery("select d.questionId from Question as d",Integer.class).getResultList();
	}
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Question> getQuestionAndAnswers(Integer questionId) {
		Query q= entityManager.createQuery("select d from Question as d where d.questionId=:questionId",Question.class);
		q.setParameter("questionId",questionId);
		return q.getResultList();
	}
	
	@Override
	public List<Question> getQuestionAndAnswersBySeq(Integer seq) {
		Query q= entityManager.createQuery("select d from Question as d where d.seq=:seq",Question.class);
		q.setParameter("seq",seq);
		return q.getResultList();
	}
	

	@Override
	public void removeQuestion(Question question){
		Question toDelete = entityManager.find(Question.class,question.getQuestionId());
		entityManager.remove(toDelete);
	}
	
	@Override
	public void addQuestion(Question newQuestion) {
		Integer seq = (Integer)entityManager.createQuery("select max(q.questionId) from Question q").getSingleResult();
		seq++;
		newQuestion.setSeq(seq);
		entityManager.persist(newQuestion);
	}
	
	@Override
	public void addAnswer(Answer newAnswer) {
		entityManager.persist(newAnswer);
	}	
	

	@Override
	public List<Question> getAllQuestions() {
		return entityManager.createQuery("select d from Question as d",Question.class).getResultList();
	}

	@Override
	public void removeAnswer(Answer answer) {
		Answer toDelete = entityManager.find(Answer.class,answer.getAnswerId());
		entityManager.remove(toDelete);
	}	
	
	
}

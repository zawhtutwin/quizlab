package com.xvitcoder.angualrspringapp.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="question")
public class Question {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="question_id")
	Integer questionId;
	
	@Column(name="question_text")
	String questionText;

	@Column(name="next_question_id")
	String nextQuestionId;
	
	@Column(name="seq")
	Integer seq;
	
	@OneToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL,orphanRemoval=true)
	@JoinColumn(name="question_id")
	List<Answer> answers = new ArrayList<Answer>();
	
	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getNextQuestionId() {
		return nextQuestionId;
	}

	public void setNextQuestionId(String nextQuestionId) {
		this.nextQuestionId = nextQuestionId;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	
	
}

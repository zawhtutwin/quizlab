package com.xvitcoder.angualrspringapp.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answer")
public class Answer {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="answer_id")
	int answerId;
	
	@Column(name="answer_text")
	String answerText;
	
	@Column(name="question_id")
	int questionId;
	
	@Column(name="correct_flg")
	String correctFlg;

	public int getAnswerId() {
		return answerId;
	}

	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getCorrectFlg() {
		return correctFlg;
	}

	public void setCorrectFlg(String correctFlg) {
		this.correctFlg = correctFlg;
	}



	
	
}

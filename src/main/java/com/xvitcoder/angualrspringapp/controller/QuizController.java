package com.xvitcoder.angualrspringapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xvitcoder.angualrspringapp.beans.Answer;
import com.xvitcoder.angualrspringapp.beans.Question;
import com.xvitcoder.angualrspringapp.beans.QuestionPackage;
import com.xvitcoder.angualrspringapp.service.QuizService;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@RequestMapping("getAllQuestionId.json")
    public @ResponseBody List<Integer> getAllQuestionId() {
        return quizService.getAllQuestionId();
    }
	
    @RequestMapping(value = "/getQuestionAndAnswers/{questionId}", method = RequestMethod.GET)
    public @ResponseBody List<Question> getQuestionAndAnswers(@PathVariable("questionId")Integer questionId) {
        return quizService.getQuestionAndAnswers(questionId);
    }

    @RequestMapping(value = "/getQuestionsByPackage/{packageName}/{font}", method = RequestMethod.GET)
    public @ResponseBody List<Question> getQuestionsByPackage(@PathVariable("packageName")String packageName,@PathVariable("font")String font) {
    	
    	QuestionPackage p = quizService.getQuestionPackageByName(packageName);
    	if("unicode".equals(font)){
	    	for(Question q:p.getQuestion()){
	    			Utils.getUnicodeQuestion(q);
	    			for(Answer a:q.getAnswers()){
	    				Utils.getUnicodeAnswer(a);
	    			}
	    	}
    	}
    	return p.getQuestion();
    }
    
    
    @RequestMapping("/getAllQuestions.json")
    public @ResponseBody List<Question> getAllQuestions() {
        return quizService.getAllQuestions();
    }
    
    @RequestMapping("/layout")
    public String getQuizPartialPage() {
        return "quiz/layout";
    }
}

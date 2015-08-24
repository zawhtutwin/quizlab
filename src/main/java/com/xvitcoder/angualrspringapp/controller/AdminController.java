package com.xvitcoder.angualrspringapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xvitcoder.angualrspringapp.beans.Answer;
import com.xvitcoder.angualrspringapp.beans.Question;
import com.xvitcoder.angualrspringapp.service.QuizService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	QuizService quizService;
	
	@RequestMapping
	String showAdminPage(HttpServletRequest request,ModelMap model){
		if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
				return "redirect:/login";
		}
		model.addAttribute("questionList",quizService.getAllQuestions());
		return "admin";
	}
	
	List<Question> questionList = new ArrayList<Question>();
	
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	   public String addQuestion(Question question,ModelMap model,HttpServletRequest request) {
		 if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
				return "redirect:/login";
		}
		  quizService.addQuestion(question);
		  model.addAttribute("questionList",quizService.getAllQuestions());
		  return "admin";
	 }	
	
	@RequestMapping(value = "/addAnswer", method = RequestMethod.POST)
	   public String addQuestion(Answer answer,ModelMap model,HttpServletRequest request) {
		 if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
				return "redirect:/login";
		}
		  quizService.addAnswer(answer);
		  model.addAttribute("questionList",quizService.getAllQuestions());
		  return viewAnswers(model, request, answer.getQuestionId());
	 }		
	
	
	   @RequestMapping(value = "/answer/view/{quesionId}", method = RequestMethod.GET)
	   public String viewAnswers(ModelMap model,HttpServletRequest request,@PathVariable("quesionId") Integer questionId) {
		 if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
				return "redirect:/login";
		 }
		 List<Question> questionList =  quizService.getQuestionAndAnswers(questionId);
		 model.addAttribute("question",questionList.get(0));
		 Answer ans = new Answer();
		 ans.setQuestionId(questionList.get(0).getQuestionId());
		 model.addAttribute("answer",ans);
		 return "answers_view";
	 }	
	 
	 @ModelAttribute("question")
	 public Question createModel() {
	     return new Question();
	 }

	 @ModelAttribute("answer")
	 public Answer createAnswerModel() {
	     return new Answer();
	 }	 
	 
	 
}

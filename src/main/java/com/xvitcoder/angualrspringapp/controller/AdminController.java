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
import com.xvitcoder.angualrspringapp.beans.QuestionPackage;
import com.xvitcoder.angualrspringapp.service.QuizService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	QuizService quizService;
	
	@RequestMapping
	String getAllPackages(HttpServletRequest request,ModelMap model){
		if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
			return "redirect:/login";
		}
		
		request.getSession().setAttribute(Constants.FONT,"Zawgyi");
		model.addAttribute("questionPackageList",quizService.getAllPackages());
		return "package_list";
	}
	
	@RequestMapping(value = "/getAllQuesionByPackage/{packageId}/{font}", method = RequestMethod.GET)
	String getAllQuesionByPackage(HttpServletRequest request,@PathVariable("packageId")Integer packageId,
			@PathVariable("font") String font,ModelMap model){
		
		request.getSession().setAttribute(Constants.FONT, font);
		
		if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
				return "redirect:/login";
		}
		Question question = new Question();
		question.setPackageId(packageId);
		//model.addAttribute("questionList",quizService.getAllQuestions());
		QuestionPackage p = quizService.getQuestionPackage(packageId);
		
		if("Unicode".equals(font)){
	    	for(Question q:p.getQuestion()){
	    			Utils.getUnicodeQuestion(q);
	    			for(Answer a:q.getAnswers()){
	    				Utils.getUnicodeAnswer(a);
	    			}
	    	}
	    	model.addAttribute("questionLabel", "မေးခွန်းထည့်ရန်");
	    	model.addAttribute("addAnswerLabel","အဖြေထည့်ရန်");
	    	model.addAttribute("deleteAnswerLabel", "ဖျက်မည်");
    	}
		else {
			model.addAttribute("questionLabel", "ေမးခြန္းထည့္ရန္");
			model.addAttribute("addAnswerLabel","အေျဖထည့္ရန္");
			model.addAttribute("deleteAnswerLabel", "ဖ်က္မည္");
		}
		
		
		model.addAttribute("question",question);
		model.addAttribute("questionList",p.getQuestion());
		//model.addAttribute("questionList",quizService.getQuestionPackage(packageId).getQuestion());
		return "question_list";
	}
	
	List<Question> questionList = new ArrayList<Question>();
	
	@RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
	   public String addQuestion(Question question,ModelMap model,HttpServletRequest request) {
		  if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
					return "redirect:/login";
		  }
		  String font = request.getSession().getAttribute(Constants.FONT).toString();
		  quizService.addQuestion(question);
		  return getAllQuesionByPackage(request,question.getPackageId(),font, model);
	 }	
	
	@RequestMapping(value = "/removeQuestion/{quesionId}/{packageId}", method = RequestMethod.GET)
		   public String removeQuestion(@PathVariable("quesionId") Integer questionId,@PathVariable("packageId")Integer packageId,ModelMap model,HttpServletRequest request) {
			 if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
					return "redirect:/login";
			}
			 String font = request.getSession().getAttribute(Constants.FONT).toString(); 
		  Question filter = new Question();
		  filter.setQuestionId(questionId);
		  quizService.removeQuestion(filter);
		  return getAllQuesionByPackage(request, packageId,font, model);
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
	
	@RequestMapping(value = "/removeAnswer/{questionId}/{answerId}", method = RequestMethod.GET)
	   public String removeAnswer(@PathVariable("questionId") Integer questionId,@PathVariable("answerId") Integer answerId,ModelMap model,HttpServletRequest request) {
		 if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
				return "redirect:/login";
		}
		 Answer filter = new Answer();
		 filter.setAnswerId(answerId);
		 quizService.removeAnswer(filter);
		 return viewAnswers(model, request, questionId);
	}		
	
	
	   @RequestMapping(value = "/answer/view/{quesionId}", method = RequestMethod.GET)
	   public String viewAnswers(ModelMap model,HttpServletRequest request,@PathVariable("quesionId") Integer questionId) {
		 if(request.getSession().getAttribute(Constants.LOGIN_USER)==null){
				return "redirect:/login";
		 }
		 String font = request.getSession().getAttribute(Constants.FONT).toString();
		 List<Question> questionList =  quizService.getQuestionAndAnswers(questionId);
		 
		 if("Unicode".equals(font)){
			 for(Question q : questionList){
				 Utils.getUnicodeQuestion(q);
				 for(Answer a:q.getAnswers()){
	 				Utils.getUnicodeAnswer(a);
	 			}
			 }
			 model.addAttribute("answerLabel", "အဖြေ");
			 model.addAttribute("deleteAnswerLabel", "ဖျက်မည်");
		 }
		 else{
			 model.addAttribute("answerLabel", "အေျဖ");
			 model.addAttribute("deleteAnswerLabel", "ဖ်က္မည္");
		 }
		 
		 model.addAttribute("selectedFont", font);
		 model.addAttribute("question",questionList.get(0));
		 Answer ans = new Answer();
		 ans.setQuestionId(questionList.get(0).getQuestionId());
		 ans.setCorrectFlg("F");
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



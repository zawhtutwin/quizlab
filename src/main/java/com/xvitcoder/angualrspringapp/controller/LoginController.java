package com.xvitcoder.angualrspringapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xvitcoder.angualrspringapp.beans.Member;
import com.xvitcoder.angualrspringapp.service.MemberService;

@Controller
@RequestMapping("/login")
public class LoginController {
	  
	@Autowired
	MemberService memberService;
	
	@RequestMapping
	  public String getLoginPage() {
	        return "login/layout";
	 }
	
	 @RequestMapping("/send")
	  public String login(HttpServletRequest request) {
	        String userName = request.getParameter("userName");
	        String password = request.getParameter("password");
	        Member filter = new Member();
	        filter.setMemberName(userName);
	        filter.setMemberPassword(password);
	        Member validUser = memberService.getMemberByUserNameAndPassword(filter);
		 	if(validUser!=null){
		 		request.getSession().setAttribute(Constants.LOGIN_USER,validUser);
		 		return "redirect:/admin";
		 	}
		 	return "login/layout";
	 }
	
}

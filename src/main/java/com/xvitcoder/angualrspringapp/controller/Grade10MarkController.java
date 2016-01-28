package com.xvitcoder.angualrspringapp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/grade10")
public class Grade10MarkController {
    
	@RequestMapping(value = "/getResult/{rollNo}", method = RequestMethod.GET)
    public @ResponseBody List<Mark> getQuestionAndAnswers(@PathVariable("rollNo")String rollNo) {
        Map<String,List> marksMap = new HashMap<String, List>(); 
        
        List<Mark> marks1 = new ArrayList<Mark>();
		marks1.add(new Mark("Myanmar",70));
		marks1.add(new Mark("English",75));
		marks1.add(new Mark("Maths",90));
		
        List<Mark> marks2 = new ArrayList<Mark>();
		marks2.add(new Mark("Myanmar",50));
		marks2.add(new Mark("English",60));
		marks2.add(new Mark("Maths",70));		
		
		marksMap.put("စရ၁၁၀",marks1);
		marksMap.put("စရ၁၀၀",marks2);
		List<Mark> outputMark  = marksMap.get(rollNo);
		return outputMark; 
    }
}
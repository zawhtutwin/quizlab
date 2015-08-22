package com.xvitcoder.angualrspringapp.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xvitcoder.angualrspringapp.beans.DesignWork;
import com.xvitcoder.angualrspringapp.beans.Member;
import com.xvitcoder.angualrspringapp.beans.RailwayStation;
import com.xvitcoder.angualrspringapp.beans.RepTime;
import com.xvitcoder.angualrspringapp.beans.TaskPerformance;
import com.xvitcoder.angualrspringapp.service.ReportService;

@Controller
@RequestMapping("/reports")
public class ReportController {

	@Autowired
	ReportService reportService;
	
     @RequestMapping("/layout")
    public String getReportPage() {
        return "reports/layout";
    }
 	
     /**
 	 * Get day time list starting from 9:00 to 22:00
 	 */
     
     @RequestMapping("/timelist.json")
     public @ResponseBody  List<RepTime> getTimeList() {
 		List<RepTime> timeList = new ArrayList<RepTime>();
 		Calendar cal = Calendar.getInstance();       
 		cal.set(Calendar.AM_PM, Calendar.AM);
 		cal.set(Calendar.HOUR, 9);
 		cal.set(Calendar.MINUTE, 00);

 		String workTime = cal.get(Calendar.HOUR_OF_DAY) + ":" + formatMinute(cal.get(Calendar.MINUTE)) + "";
 		timeList.add(new RepTime(workTime));
 		//Add 30 minutes up to 21:30
 		for (int i = 1; i < 27; i++) {
 			cal.add(Calendar.MINUTE, 30);
 			workTime = cal.get(Calendar.HOUR_OF_DAY) + ":" + formatMinute(cal.get(Calendar.MINUTE)) + "";
 			timeList.add(i, new RepTime(workTime));
 		}

 		return timeList;
 	}
 	
 	/**
 	 * Get the night time list starting from 22:00 to 8:30 
 	 */
     @RequestMapping("/midnight_timelist.json")
     public @ResponseBody List<RepTime> getMidNightTimeList() {
 		List<RepTime> timeList = new ArrayList<RepTime>();
 		Calendar cal = Calendar.getInstance();
 		cal.set(Calendar.AM_PM, Calendar.AM);
 		cal.set(Calendar.HOUR, 22);
 		cal.set(Calendar.MINUTE, 00);

 		String workTime = cal.get(Calendar.HOUR_OF_DAY) + ":" + formatMinute(cal.get(Calendar.MINUTE)) + "";
 		timeList.add(new RepTime(workTime));
 		
 		for (int i = 1; i < 23; i++) {
 			cal.add(Calendar.MINUTE, 30);//Add 30 minutes up to 8:30
 			workTime = cal.get(Calendar.HOUR_OF_DAY) + ":" + formatMinute(cal.get(Calendar.MINUTE)) + "";
 			timeList.add(i, new RepTime(workTime));
 		}
 		return timeList;
 	}   
 	
     @RequestMapping(value = "/add", method = RequestMethod.POST)
     public @ResponseBody void addTaskPerformances(@RequestBody TaskPerformance[] taskList) {
         List<TaskPerformance> tpList = new ArrayList<TaskPerformance>();
    	 for(TaskPerformance tp:taskList){
        	 if(tp.getWorkNo()!=null && (!"".equals(tp.getWork()))){
        		 tpList.add(tp);
        	 }
         }
    	 try{
    		 reportService.saveTaskPerformances(tpList);
         }catch(Exception e){
        	 e.printStackTrace();
         }
    }
     
     @RequestMapping("/design_work_list.json")
     public @ResponseBody List<DesignWork> getDesignWorkList() {
    	 return  reportService.getAllDesignWorks();
 	}
     
     @RequestMapping("/member_list.json")
     public @ResponseBody List<Member> getAllMembers() {
    	 return reportService.getAllMembers();
 	} 
     
     
     
     
	/**
	 * Format minutes append 00 if there is 0
	 */
	String formatMinute(int min) {
		return (min == 0) ? "00" : min + "";
	}

	String formatHour(String time) {
		String hour = time.split(":")[0];
		if (hour.length() == 1) {
			time = "0" + time;
		}
		return time;
	} 	
     
}
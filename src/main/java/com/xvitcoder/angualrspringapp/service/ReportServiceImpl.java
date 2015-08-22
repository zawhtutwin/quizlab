package com.xvitcoder.angualrspringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xvitcoder.angualrspringapp.beans.DesignWork;
import com.xvitcoder.angualrspringapp.beans.Member;
import com.xvitcoder.angualrspringapp.beans.TaskPerformance;
import com.xvitcoder.angualrspringapp.dao.ReportDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: xvitcoder
 * Date: 12/20/12
 * Time: 11:14 PM
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	ReportDao reportDao;
	
	@Override
	public List<DesignWork> getAllDesignWorks() {
		return reportDao.getAllDesignWorks();
	}

	@Override
	public List<Member> getAllMembers() {
		return reportDao.getAllMembers();
	}

	@Override
	public void saveTaskPerformances(List<TaskPerformance> taskPerformanceList) {
		reportDao.saveTaskPerformances(taskPerformanceList);
		
	}

}

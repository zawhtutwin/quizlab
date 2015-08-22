package com.xvitcoder.angualrspringapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xvitcoder.angualrspringapp.beans.DesignWork;
import com.xvitcoder.angualrspringapp.beans.Member;
import com.xvitcoder.angualrspringapp.beans.TaskPerformance;


@Repository("reportDao")
@Transactional(value = "transactionManager",propagation = Propagation.REQUIRES_NEW)
public class ReportDaoImpl implements ReportDao {
	
	@PersistenceContext
	private EntityManager entityManager;
	

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
	public List<DesignWork> getAllDesignWorks() {
		return entityManager.createQuery("select d from DesignWork as d",DesignWork.class).getResultList();
	}


	@Override
	public List<Member> getAllMembers() {
		return entityManager.createQuery("select m from Member as m",Member.class).getResultList();
	}

	
	@Transactional
	public void saveTaskPerformances(List<TaskPerformance> taskPerformanceList) {
		for(TaskPerformance tp:taskPerformanceList){
			deleteTaskPerformace(tp.getTime(),tp.getRegDate(),tp.getMemberId());
			System.out.println(tp.getWorkNo()+"','"+tp.getWork()+"','"+tp.getTime()+"','"+tp.getRegDate()+"','"+tp.getMemberId());
			entityManager.persist(tp);
			entityManager.flush();
		}
	}
	
	public void deleteTaskPerformace(String time,String regDate,String memberId){
		Query query = entityManager.createQuery("select tp from TaskPerformance tp where time=:time and regDate=:regDate and memberId=:memberId");
		query.setParameter("time",time);
		query.setParameter("regDate",regDate);
		query.setParameter("memberId",memberId);
		List<TaskPerformance> toDeleteList = query.getResultList();
		if(toDeleteList.size()>0){
			entityManager.remove(toDeleteList.get(0));
		}
	}
}

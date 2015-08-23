package com.xvitcoder.angualrspringapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.xvitcoder.angualrspringapp.beans.Member;

@Repository("memberDao")
@Transactional(value = "transactionManager",propagation = Propagation.REQUIRES_NEW)
public class MemberDaoImpl implements MemberDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public Member getMemberByUserNameAndPassword(Member filter) {
		Query q = entityManager.createQuery("select m from Member m where m.memberName=:memberName and m.memberPassword=:memberPassword",Member.class);
		q.setParameter("memberName",filter.getMemberName());
		q.setParameter("memberPassword",filter.getMemberPassword());
		Member m = null;
		try{
			m = (Member)q.getSingleResult();
		}catch(NoResultException ex){
			
		}
		return m;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}

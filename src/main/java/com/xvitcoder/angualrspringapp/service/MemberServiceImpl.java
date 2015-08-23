package com.xvitcoder.angualrspringapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xvitcoder.angualrspringapp.beans.Member;
import com.xvitcoder.angualrspringapp.dao.MemberDao;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;
	
	@Override
	public Member getMemberByUserNameAndPassword(Member filter) {
		return memberDao.getMemberByUserNameAndPassword(filter);
	}
}

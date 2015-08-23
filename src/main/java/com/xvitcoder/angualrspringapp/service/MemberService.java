package com.xvitcoder.angualrspringapp.service;

import com.xvitcoder.angualrspringapp.beans.Member;

public interface MemberService {
	 Member getMemberByUserNameAndPassword(Member filter);
}

package com.xvitcoder.angualrspringapp.dao;

import com.xvitcoder.angualrspringapp.beans.Member;

public interface MemberDao {
	Member getMemberByUserNameAndPassword(Member filter);
}

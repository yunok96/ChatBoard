package com.spring.board2.service;

import com.spring.board2.model.MemberVO;

public interface MemberService {
	public MemberVO selectMember(String email) throws Exception;
	public int insertMember(MemberVO memberVO) throws Exception;
}

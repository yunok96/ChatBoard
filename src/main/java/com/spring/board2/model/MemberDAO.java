package com.spring.board2.model;

public interface MemberDAO {
	public MemberVO selectMember(String email) throws Exception;
	public int insertMember(MemberVO memberVO) throws Exception;
}

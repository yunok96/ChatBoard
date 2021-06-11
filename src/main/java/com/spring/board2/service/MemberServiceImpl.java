package com.spring.board2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board2.model.MemberDAO;
import com.spring.board2.model.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public MemberVO selectMember(String email) throws Exception {
		return dao.selectMember(email);
	}
	
	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		return dao.insertMember(memberVO);
	}
}

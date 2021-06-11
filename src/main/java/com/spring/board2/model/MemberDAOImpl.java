package com.spring.board2.model;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public MemberVO selectMember(String email) throws Exception {
		return sqlSession.selectOne("memberMapper.selectMember", email);
	}
	
	@Override
	public int insertMember(MemberVO memberVO) throws Exception {
		return sqlSession.insert("memberMapper.insertMember", memberVO);
	}
}

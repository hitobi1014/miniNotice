package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {
	
	UserDaoI userDao;
	@Before
	public void setUp() {
		userDao = new UserDao();
	}
	
	// 회원 로그인시 회원정보와 비밀번호가 일치하는지
	@Test
	public void getUserTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		String userid = "a001";
		String pass = "a1234";
		/***When***/
		UserVo uvo = userDao.getUser(sqlSession, userid);
		/***Then***/
		assertEquals(pass, uvo.getUser_pass());
	}

}

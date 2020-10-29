package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.user.model.UserVo;

public class UserServiceTest {
	UserServiceI userService;
	@Before
	public void setUp() {
		userService = new UserService();
	}
	
	// 회원 로그인시 사용되는 서비스
	@Test
	public void getUserTest() {
		/***Given***/
		String userid="a001";
		String pass = "a1234";
		/***When***/
		UserVo uvo = userService.getUser(userid);
		/***Then***/
		assertEquals(pass, uvo.getUser_pass());
	}

}

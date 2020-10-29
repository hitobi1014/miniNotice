package kr.or.ddit.user.service;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoI;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceI {

	private UserDaoI userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	
	@Override
	public UserVo getUser(String userid) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		UserVo userVo = userDao.getUser(sqlSession, userid); 
		sqlSession.close();
		return userVo;
	}

}

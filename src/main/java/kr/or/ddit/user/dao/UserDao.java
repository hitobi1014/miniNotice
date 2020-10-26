package kr.or.ddit.user.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.user.model.UserVo;

public class UserDao implements UserDaoI {

	private SqlSession sqlSession;
	
	public UserDao() {
		sqlSession = MybatisUtil.getSqlSession();
	}
	
	@Override
	public UserVo getUser(String userid) {
		UserVo userVo = sqlSession.selectOne("user.getUser", userid);
		sqlSession.close();
		return userVo;
	}

}

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
	public UserVo getUser(SqlSession sqlSession, String userid) {
		return sqlSession.selectOne("user.getUser", userid);
	}

}

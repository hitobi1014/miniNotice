package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.notice.model.NoticeFileVo;
import kr.or.ddit.notice.model.NoticeGubunVo;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.notice.model.ReplyVo;

public class NoticeDao implements NoticeDaoI {
//	private SqlSession sqlSession;
//	
//	public NoticeDao() {
//		sqlSession = MybatisUtil.getSqlSession();
//	}
	
	@Override
	public int insertNoticeGubun(NoticeGubunVo ngvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertNotice(NoticeVo nvo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = sqlSession.insert("notice.insertNotice", nvo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int insertFile(NoticeFileVo nfvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<NoticeGubunVo> getAllNoticeGubun() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<NoticeGubunVo> gubunVo =  sqlSession.selectList("notice.getAllNoticeGubun");
		sqlSession.close();
		return gubunVo;
	}

	@Override
	public List<NoticeVo> getAllNotice(String ntgu_code) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<NoticeVo> noticeList = sqlSession.selectList("notice.getAllNotice", ntgu_code);
		sqlSession.close();
		return noticeList;
	}

	@Override
	public List<NoticeVo> searchNotice(Map<String, Object> searchInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateNotice(NoticeVo nvo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(Map<String, Object> info) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = sqlSession.update("notice.deleteNotice", info);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public NoticeGubunVo getNoticeGubun(String ntgu_code) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		NoticeGubunVo ngvo = sqlSession.selectOne("notice.getNoticeGubun", ntgu_code);
		sqlSession.close();
		return ngvo;
	}

	@Override
	public NoticeVo getNotice(int nt_num) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		NoticeVo nvo = sqlSession.selectOne("notice.getNotice", nt_num);
		sqlSession.close();
		return nvo;
	}

	@Override
	public List<ReplyVo> getAllReply(int nt_num) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<ReplyVo> replyList = sqlSession.selectList("notice.getAllReply", nt_num);
		sqlSession.close();
		return replyList;
	}

}

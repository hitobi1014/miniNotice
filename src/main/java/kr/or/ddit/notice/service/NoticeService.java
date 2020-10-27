package kr.or.ddit.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.PageVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.notice.dao.NoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoI;
import kr.or.ddit.notice.model.NoticeFileVo;
import kr.or.ddit.notice.model.NoticeGubunVo;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.notice.model.ReplyVo;

public class NoticeService implements NoticeServiceI {
	private NoticeDaoI noticeDao;

	public NoticeService() {
		noticeDao = new NoticeDao();
	}

	@Override
	public int insertNoticeGubun(NoticeGubunVo ngvo) {
		return 0;
	}

	@Override
	public int insertNotice(NoticeVo nvo) {
		return noticeDao.insertNotice(nvo);
	}

	@Override
	public int insertFile(NoticeFileVo nfvo) {
		return noticeDao.insertFile(nfvo);
	}

	@Override
	public List<NoticeGubunVo> getAllNoticeGubun() {
		return noticeDao.getAllNoticeGubun();
	}

	@Override
	public Map<String, Object> getAllNotice(String ntgu_code) {
		NoticeGubunVo ngvo = noticeDao.getNoticeGubun(ntgu_code);
		List<NoticeVo> noticeList = noticeDao.getAllNotice(ntgu_code);
		Map<String, Object> map = new HashMap<>();
		map.put("ngvo", ngvo);
		map.put("noticeList", noticeList);
		return map;
	}

	@Override
	public List<NoticeVo> searchNotice(Map<String, Object> searchInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateNotice(NoticeVo nvo) {
		return noticeDao.updateNotice(nvo);
	}

	@Override
	public int deleteNotice(Map<String, Object> info) {
		return noticeDao.deleteNotice(info);
	}

	@Override
	public Map<String, Object> getNotice(int nt_num) {
		Map<String, Object> map = new HashMap<>();
		NoticeVo nvo = noticeDao.getNotice(nt_num);
		List<ReplyVo> replyVo = noticeDao.getAllReply(nt_num);
		map.put("nvo", nvo);
		map.put("replyList", replyVo);
		return map;
	}

	@Override
	public int insertReply(ReplyVo rvo) {
		return noticeDao.insertReply(rvo);
	}

	@Override
	public int deleteReply(ReplyVo rvo) {
		return noticeDao.deleteReply(rvo);
	}

	@Override
	public int updateReply(ReplyVo rvo) {
		return noticeDao.updateReply(rvo);
	}

//	@Override
//	public int noticeTotalCnt(String ntgu_code) {
//		// 15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
//		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
//		int totalCount = noticeDao.noticeTotalCnt(ntgu_code);
//		int pages = (int)Math.ceil((double)totalCount/7);
////		map.put("pages", pages);
//		
////		sqlSession.close();
//		return pages;
//	}

	@Override
	public Map<String, Object> getAllNoticePage(Map<String, Object> map) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		Map<String, Object> info = new HashMap<String,Object>();
		info.put("noticeList", noticeDao.getAllNoticePage(sqlSession, map));
		
		// 15건, 페이지 사이즈를 7로 가정했을때 3개의 페이지가 나와야한다
		// 15/7 = 2.14... 올림을 하여 3개의 페이지가 필요
		String ntgu_code = (String) map.get("ntgu_code");
		int totalCount = noticeDao.noticeTotalCnt(ntgu_code);
		int pages = (int)Math.ceil((double)totalCount/10);
		info.put("pages", pages);
		
		sqlSession.close();
		return info;
	}

	@Override
	public List<NoticeFileVo> getAllFile(int nt_num) {
		return noticeDao.getAllFile(nt_num);
	}

	@Override
	public NoticeFileVo getFile(int filenum) {
		return noticeDao.getFile(filenum);
	}

}

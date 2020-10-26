package kr.or.ddit.notice.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
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

}

package kr.or.ddit.notice.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.model.NoticeFileVo;
import kr.or.ddit.notice.model.NoticeGubunVo;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.notice.model.ReplyVo;

/**
* NoticeDaoI.java
*
* @author 404-01
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* cmj	 최초 생성
*
* </pre>
 */
public interface NoticeDaoI {
//	○ 게시판 관리화면 (게시판 신규 추가, 비활성화)
//	○ 게시판의 게시글 리스트 화면(페이징 기능)
//	○ 게시판의 게시글 상세화면
//	○ 게시판의 게시글 입력화면
//	○ 게시판의 게시글 수정화면
	
	/**
	 * 게시판구분 생성(관리자만 생성가능)
	 * @param 게시판 구분의 정보를 담은 vo객체 
	 * @return 게시판구분 생성에 성공시 1이상의 값 반환 실패하면 0 
	 */
	int insertNoticeGubun(NoticeGubunVo ngvo);
	
	/**
	 * 게시글 작성(회원들 누구나 자유롭게 작성가능)
	 * @param 게시글 정보를 담은 vo 객체 
	 * @return 게시글 작성에 성공시 1이상의 값 반환 실패하면 0 
	 */
	int insertNotice(NoticeVo nvo);
	
	/**
	 * 게시글 파일첨부, 게시글 작성시 파일 첨부
	 * @param 파일정보를 담은 vo객체 
	 * @return 파일첨부 성공시 1 이상의 값 반환 실패시 0 
	 */
	int insertFile(NoticeFileVo nfvo);
	
	/**
	 * 게시판 가져오기 (ex.자유게시판 질의게시판 )
	 * @return 게시판구분 vo 객체를 담은 List
	 */
	List<NoticeGubunVo> getAllNoticeGubun();
	
	/**
	 * 특정 게시판구분 vo객체 가져오기
	 */
	NoticeGubunVo getNoticeGubun(String ntgu_code);
	
	/**
	 * 게시글 전체조회
	 * @return 전체 게시글에 대한 정보를 List객체로 반환 
	 * @param noticeGubun Code를 인자값으로 받음
	 */
	List<NoticeVo> getAllNotice(String ntgu_code);
	
	/**
	 * 게시글 상세보기
	 * @param 게시글번호
	 * @return 게시글번호에 해당하는 글 상세보기
	 */
	NoticeVo getNotice(int nt_num);
	
	/**
	 * 게시글 검색조회
	 * @param 작성자, 글번호, 내용, 제목 등의 내용을 포함한 map객체
	 * @return 파라미터 정보에 해당하는 게시글을 List 객체로 반환 
	 */
	List<NoticeVo> searchNotice(Map<String, Object> searchInfo);
	//
	
	/**
	 * 게시글 수정
	 * @param 게시글 정보를 수정할 내용을 담은 vo객체
	 * @return 게시글 수정을 성공하면 1이상 실패하면 0반환
	 */
	int updateNotice(NoticeVo nvo);
	
	/**
	 * 게시글 삭제 , 본인만 삭제할수있음
	 * @param 삭제할 글 번호와 본인 아이디를 담은 map객체
	 * @return 삭제 성공시 1이상의 값 실패하면 0
	 */
	int deleteNotice(Map<String, Object> info);
	
	/**
	 * 댓글가져오기
	 * @param 게시글번호
	 * @return 게시글에 해당하는 댓글을 담은 vo, List객체
	 */
	List<ReplyVo> getAllReply(int nt_num);
	
}

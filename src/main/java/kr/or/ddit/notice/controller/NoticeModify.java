package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.notice.model.NoticeGubunVo;
import kr.or.ddit.notice.model.NoticeVo;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceI;

/**
 * Servlet implementation class NoticeModify
 */
@WebServlet("/noticeModify")
public class NoticeModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeServiceI noticeService;
	private static final Logger logger = LoggerFactory.getLogger(NoticeModify.class);
	
	public NoticeModify() {
		noticeService = new NoticeService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String user_id = request.getParameter("userid");
		int nt_num = Integer.parseInt(request.getParameter("ntnum")); //게시글 번호 가져오기
		
		Map<String, Object> getNotice = noticeService.getNotice(nt_num); //게시글 정보 가져오기
		NoticeVo nvo =  (NoticeVo) getNotice.get("nvo"); // Map객체에서 noticeVo객체만 가져오기
		
		String ntgu_code = nvo.getNtgu_code(); //게시판 분류코드 얻기
		Map<String, Object> getNtgu = noticeService.getAllNotice(ntgu_code); //게시판 분류코드를 통해 noticeGubunVo를 담은 map객체 생성
		NoticeGubunVo ngvo = (NoticeGubunVo) getNtgu.get("ngvo"); //
//		logger.debug("게시글 정보 : {}",nvo);
//		logger.debug("게시판분류 정보 : {}", ngvo);
		
		request.setAttribute("nvo", nvo);
		request.setAttribute("ngvo", ngvo);
		
		
		request.getRequestDispatcher("/notice/noticeModify.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 필요데이터
//		NTGU_CODE 	USER_ID 	NT_DT 	NT_CONT 	NT_TITLE 	NT_PANUM
//		구분코드 		아이디 	  	날짜		내용			제목			부모게시글번호
		String ntgu_code = request.getParameter("noticeGubun");
		String nt_title =request.getParameter("title");
		String nt_cont = request.getParameter("editordata");
		String np= request.getParameter("nt_panum");
		int nt_num = Integer.parseInt(request.getParameter("nt_num"));
		
//		logger.debug("코드 : {}, 제목 : {}, 내용 :{}, 글번호 : {}",ntgu_code, nt_title, nt_cont, nt_num);
		
		NoticeVo nvo = new NoticeVo();
		
		if(np !=null) {
			int nt_panum = Integer.parseInt(np);
			nvo.setNt_panum(nt_panum);
			logger.debug("부모게시글번호 : {}",nt_panum);
		}
		
		nvo.setNtgu_code(ntgu_code);
		nvo.setNt_title(nt_title);
		nvo.setNt_cont(nt_cont);
		nvo.setNt_num(nt_num);
		int updateCnt = noticeService.updateNotice(nvo);
		if(updateCnt>0) {
			logger.debug("등록성공");
		}else {
			logger.debug("등록실패");
		}
		
		response.sendRedirect("/notice?ntgu_code="+ntgu_code);
	}

}

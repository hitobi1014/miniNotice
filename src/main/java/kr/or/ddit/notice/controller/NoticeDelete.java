package kr.or.ddit.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceI;

/**
 * Servlet implementation class NoticeDelete
 */
@WebServlet("/noticeDelete")
public class NoticeDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(NoticeDelete.class);
	private NoticeServiceI noticeService;
	public NoticeDelete() {
		noticeService = new NoticeService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("ngvo값 : {}",request.getParameter("ntgu"));
		String ntgu_code = request.getParameter("ntgu");
		//삭제하기위해 map형식으로 값 넘겨줘야함 xml참고
		
//		request.getRequestDispatcher("/notice?ntgu_code="+ntgu_code).forward(request, response);
		response.sendRedirect("/notice?ntgu_code="+ntgu_code);
	}

}

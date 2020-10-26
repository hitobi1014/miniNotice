package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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
 * Servlet implementation class FreeNotice
 */
@WebServlet("/notice")
public class Notice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NoticeServiceI noticeService;
	private static final Logger logger = LoggerFactory.getLogger(Notice.class);
	
	public void init() throws ServletException {
		noticeService = new NoticeService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ntgu_code = request.getParameter("ntgu_code");
		logger.debug("ntgu_code : {}", ntgu_code);
		Map<String, Object> map = new HashMap<>();
		map = noticeService.getAllNotice(ntgu_code);
		NoticeGubunVo ngvo = (NoticeGubunVo)map.get("ngvo");
		List<NoticeVo> noticeList = (List<NoticeVo>) map.get("noticeList");
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("ngvo", ngvo);
		logger.debug("noticeList : {}", noticeList);
		logger.debug("ngvo : {}", ngvo);
		
		request.getRequestDispatcher("/notice/notice.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

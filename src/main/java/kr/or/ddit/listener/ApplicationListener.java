package kr.or.ddit.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import kr.or.ddit.notice.model.NoticeGubunVo;
import kr.or.ddit.notice.service.NoticeService;
import kr.or.ddit.notice.service.NoticeServiceI;

public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		String cp = sc.getContextPath();
		sc.setAttribute("cp", cp);
		
		NoticeServiceI noticeService = new NoticeService();
		List<NoticeGubunVo> noticeGubun = noticeService.getAllNoticeGubun();
		sc.setAttribute("noticeGubun", noticeGubun);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}

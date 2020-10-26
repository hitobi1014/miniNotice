<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<ul class="nav nav-sidebar">
	<c:forEach items="${noticeGubun}" var="noticeGubun">
		<c:if test="${S_MEMBER.user_id != null }">
			<li class="active"><a href="${cp}/notice?ntgu_code=${noticeGubun.ntgu_code}">${noticeGubun.ntgu_name}<span class="sr-only">(current)</span></a></li>
		</c:if>
		
		<c:if test="${S_MEMBER.user_id == null }">
			<li class="active"><a href="${cp}/login">${noticeGubun.ntgu_name}<span class="sr-only">(current)</span></a></li>
		</c:if>
<!-- 		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li> -->
<%-- 		<li class="active"><a href="${pageContext.request.contextPath}/memberList">사용자</a></li> --%>
<%-- 		<li class="active"><a href="<%=request.getContextPath()%>/getAllJobs">jobs</a></li> --%>
	</c:forEach>
	
</ul>
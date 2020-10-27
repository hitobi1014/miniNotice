<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>Jsp</title>
<%@ include file="/layout/commonLib.jsp" %>
<script>
</script>
</head>
<body>
<%@ include file="/layout/header.jsp" %>
<%@ include file="/common/common.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">
					<h2 class="sub-header">${ngvo.ntgu_name}</h2>
					<div class="table-responsive">
						<table class="table table-striped">
							<tr>
								<th>글번호</th>
								<th>제목</th>
								<th>아이디</th>
								<th>작성일</th>
							</tr>
							<tbody id="noticeList">
								<c:forEach items="${noticeList}" var="notice">
									<tr data-userid="${notice.user_id }">
										<td>${notice.nt_num }</td>
										<c:choose>
											<c:when test="${notice.ntcont_stat == 0}">
												<td>[삭제된 게시글 입니다]</td>
											</c:when>
											<c:otherwise>
												<td><a href="${cp}/noticeDetail?nt_num=${notice.nt_num}">${notice.nt_title }</a></td>
											</c:otherwise>
										</c:choose>
										<td>${notice.user_id }</td>
										<td><fmt:formatDate value="${notice.nt_dt }" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
					<a class="btn btn-default pull-right" href="${cp}/noticeWrite">게시글작성</a>
					page : ${page}
					<div class="text-center">
						<ul class="pagination">
							<c:forEach var="i" begin="1" end="${pages}">
								<c:choose>
									<c:when test="${i == page }">
										<li class="active"><span>${i}</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${cp}/notice?page=${i}&ntgu_code=${ngvo.ntgu_code}">${i}</a></li>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

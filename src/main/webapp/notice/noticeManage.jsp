<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
$(document).ready(function(){
	
})
</script>
<style>
#tb, th{
	text-align: center;
}
</style>
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
					<h2 class="sub-header">게시판관리</h2>
					<form action="${cp}/noticeGubunInsert" method="post">
						<input type="text" id="ntgu_code" name="ntgu_code" placeholder="게시판코드"/>
						<input type="text" id="ntgu_name" name="ntgu_name" placeholder="게시판이름"/>
						<button type="submit">게시판 생성</button>
					</form>
					<div class="table-responsive">
						<table id="tb" class="table table-striped">
							<tr>
								<th>게시판코드</th>
								<th>게시판명</th>
								<th>사용여부</th>
								<th>버튼</th>
							</tr>
							<tbody id="noticeGubunList">
							<c:forEach items="${noticeGubun}" var="nogu">
								<form action="${cp}/noticeGubunModify" method="post">
									<tr>
									<input type="hidden" value="${nogu.ntgu_code}" name="ntgu_code"/>
										<td>${nogu.ntgu_code}</td>
										<td>${nogu.ntgu_name}</td>
										<td>
											<select name="noticeUse">
												<c:if test="${nogu.ntgu_stat==1 }">
													<option value="1" selected="selected">사용중</option>
													<option value="0">미사용</option>
												</c:if>
												<c:if test="${nogu.ntgu_stat==0 }">
													<option value="1">사용중</option>
													<option value="0" selected="selected">미사용</option>
												</c:if>
											</select>
										</td>
										<td>
											<button type="submit">변경</button>
										</td>
									</tr>
								</form>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

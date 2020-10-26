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
<style>
.date{
	color:#b2b2b2;
	font-size:0.9em;
}
.reply{
	font-weight: bold;
	font-size:1.4em;
}
.userid{
	font-weight:bold;
	font-size:1.2em;
}
.replyText{
 	border: 2px solid #b2b2b2; 
 	border-radius: 5px; 
 	padding: 8px;
 	overflow: auto;
}
#modBtn{
	float: left;
	margin-right: 5px;
}
</style>
<%@ include file="/layout/commonLib.jsp" %>
<%@ include file="/common/common.jsp" %>
<script>
$(document).ready(function(){
	
	$('textarea').on('keyup', function() {
		textareaHeight();
	});
	
	function textareaHeight() {
	  	var textEle = $('textarea');
	  	textEle[0].style.height = 'auto';
	 	var textEleHeight = textEle.prop('scrollHeight');
	  	textEle.css('height', textEleHeight);
	};
	
})
</script>
</head>
<body>
<%@ include file="/layout/header.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-3 col-md-2 sidebar">
			<%@ include file="/layout/left.jsp" %>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
				<div class="col-sm-8 blog-main">
					<div class="sub-header">
						<h2>${nvo.nt_title}</h2>
						<div>
							<span class="userid">${nvo.user_id} </span><br>
							<p style="float:right">${ngvo.ntgu_name}</p>
							<p style="float: left;" class="date"><fmt:formatDate value="${nvo.nt_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></p>
						</div><br>
					</div>
					<br>
					<div class="table-responsive">
						<p style="font-size:1.2em">
							${nvo.nt_cont}
						</p>
					</div>
					<hr>
				
					<p class="reply">댓글</p>
					<c:forEach items="${replyList}" var="reply">
						<div>
							<span class="userid">${reply.user_id}</span><br>
							<span>${reply.rep_cont}</span><br>
							<span class="date"><fmt:formatDate value="${reply.rep_dt}" pattern="yyyy-MM-dd HH:mm:ss"/></span> &nbsp;
							<span><a href="#">답글쓰기</a></span>
							<hr>
						</div>
					</c:forEach>
					
					<!-- 댓글쓰기 -->
					<div class="replyText">
						<p class="userid"><c:if test="${S_MEMBER.user_id != null }">${S_MEMBER.user_id}</c:if></p>
						<textarea style="border:0px;height:50px;width:900px;" ></textarea><br>
						<p style="float:right"><button type="button">등록</button></p>
					</div>
					
					<div>
						<c:if test="${S_MEMBER.user_id == nvo.user_id}">
							<p id="modBtn" >
								<a class="btn btn-default pull-right" href="${cp }/memberRegist">수정</a>
								<a class="btn btn-default pull-right" href="${cp }/noticeDelete?ntgu=${nvo.ntgu_code}">삭제</a>
							</p>
						</c:if>
					</div>
					
					<!-- 나중에 할 댓글 페이징처리==> 안해도될듯-->
					<div class="text-center">
						<ul class="pagination">
							<c:forEach var="i" begin="1" end="${pages }">
								<c:choose>
									<c:when test="${i == page }">
										<li class="active"><span>${i }</span></li>
									</c:when>
									<c:otherwise>
										<li><a href="${pageContext.request.contextPath }/memberList?page=${i }">${i }</a></li>
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

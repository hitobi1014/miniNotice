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
<title>글작성 페이지</title>
<style>
#selectNotice{
	height: 30px;
	width: 700px;
	margin-top: 10px;
}
#title{
	height: 30px;
	width: 900px;
	margin-top: 10px;
}
#subBtn{
	height: 30px;
	width: 70px;
	margin-bottom: 10px;
}
</style>
<%@ include file="/layout/commonLib.jsp" %>
<%@ include file="/common/common.jsp" %>
<script src="${cp}/js/summernote/summernote-lite.js"></script>
<script src="${cp}/js/summernote/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="${cp}/css/summernote/summernote-lite.css"></head>
<script>
$(document).ready(function(){
	
	$('#summernote').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 1000자까지 쓸 수 있습니다'	//placeholder 설정
        
	});

	$('#subBtn').on('click',function(){
		$('#frm').submit();
	})
})
</script>

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
						<h2>글쓰기</h2>
					</div>
					<div>
						<form method="post" action="${cp}/noticeModify" id="frm">
							<input type="hidden" value="${S_MEMBER.user_id}" name="user_id" id="user_id" />
							<input type="hidden" value="${nvo.nt_num}" name="nt_num" />
							<div>
								<select id="selectNotice" name="noticeGubun">
<!-- 									<option selected="selected">게시판을 선택해주세요</option> -->
									<c:forEach items="${noticeGubun}" var="noticeGubun">
										<c:choose>
											<c:when test="${ngvo.ntgu_code == noticeGubun.ntgu_code}">
												<option value="${noticeGubun.ntgu_code}" selected="selected">${noticeGubun.ntgu_name}</option> 
											</c:when>
											<c:otherwise>
												<option value="${noticeGubun.ntgu_code}">${noticeGubun.ntgu_name}</option> 
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
							</div>
							<div>
								<input type="text" id="title" placeholder="제목을 입력해주세요" name="title" value="${nvo.nt_title }"/>
							  	<button id="subBtn" type="submit">등록</button>
							</div>
						  	<textarea id="summernote" name="editordata">${nvo.nt_cont}</textarea>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>

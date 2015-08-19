<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	pageContext.setAttribute("newLineChar", "\n");
%>

<!DOCTYPE html>
<html>

<script type = "text/javascript" src = "/assets/js/jquery/jquery-1.9.0.js"></script>
<script>

 $(function(){
	$(".click").click(function( event ){
		event.preventDefault();
		var click_id = $(this).attr('id');
		 if($(".display"+click_id).is(":visible")==false){
			 $(".display"+click_id).show();
		 }else{
			 $(".display"+click_id).hide();	 
		 }
	})
})
</script>

<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>


	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp">
			</c:import>
		</div>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${vo.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">${fn:replace(vo.message, newLineChar, "<br>")}
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="/board/list">글목록</a>
					<c:if test="${authUser.no==vo.user_no }">
						<a href="/board/modifyform?no=${vo.no}">글수정</a>
						<a href="/board/delete?no=${vo.no}">삭제</a>
					</c:if>
				</div>
				
				<c:if test="${not empty authUser.name}">
				<form method="post" action="/board/reply">
					<input type="hidden" name="order_no" value="0">
					<input type="hidden" name="depth" value="0">
					<input type="hidden" name="no" value="${vo.no}"/>
					<table class="tbl-ex">
						<tr>
							<th colspan="4">댓글쓰기</th>
						</tr>
						<tr>
							<td class="label">이름</td>
							<td><input type="hidden" name="name"
								value="${authUser.name}">${authUser.name}</td>
						</tr>
						<tr>
							<td class="label">내용</td>
							<td>
								<div class="replyview">
									<textarea id="reply" name="replymessage"></textarea>
									<input type="submit" value="댓글달기">
								</div>
							</td>
						</tr>
					</table>
				</form>
				</c:if>	
							
				<table class="tbl-ex">
					<tr>
						<th colspan="5">댓글보기</th>
					</tr>
					<c:forEach var="rp" items="${reply}">
						<tr>
							<td style="padding-left:${rp.depth*20}px">${rp.name}</td>
							<td>
								<div class="replyview"><a href="#" class="click" id="${rp.no}">${rp.message}</a></div>
							</td>
							<td>${rp.reply_date}</td>
							<td><c:if test="${authUser.no==rp.user_no}">
									<a id="del"
										href="/board/replydelete?no=${vo.no}&group_no=${rp.group_no}&order_no=${rp.order_no}"
										class="del">삭제</a>
								</c:if></td>
							</tr>
							<form method="post" action="/board/rereply">
							<input type="hidden" name="order_no" value="${rp.order_no}">
							<input type="hidden" name="depth" value="${rp.depth}">
							<input type="hidden" name="name" value="${authUser.name}">
							<input type="hidden" name="no" value="${vo.no}">
							<input type="hidden" name="group_no" value="${rp.group_no}">
							<tr class="display${rp.no}" style="display:none">
								<td></td>
								<td colspan="3"><textarea id="replytextarea" name="replymessage"></textarea></td>
								<td><input type="submit" value="댓글달기"></td>
							</tr>
							</form>
					</c:forEach>
				</table>

			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="pageName" value="board" />
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp">
			</c:import>
		</div>
	</div>
</body>
</html>
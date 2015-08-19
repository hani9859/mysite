<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
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
			<div id="board">
				<form id="search_form" action="/board/search" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" id="search" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
							<td>번호</td>
							<td id="title">제목</td>
							<td id="name">글쓴이</td>
							<td id="hit">조회수</td>
							<td id="date">작성일</td>
					</tr>
						
						<c:forEach var="vo" items="${list}" >
							<tr>
								<td>${vo.index_no}</td>
								<td><a href="/board/view?no=${vo.no}">${vo.title}</a></td>
								<td>${vo.name}</td>
								<td id="hit">${vo.hit}</td>
								<td>${vo.reg_date}</td>
							</tr>
						</c:forEach>
				</table>
				<div align="center">
					<c:if test="${page >1}">
					<a href="?kwd=${kwd}&page=${page-1}">[이전]</a>
					</c:if>
					<c:forEach var = "i" begin="1" end="${total}">
						<a href="?kwd=${kwd}&page=${i}">${i}</a>
					</c:forEach>
					<c:if test="${page<total}">
					<a href="?kwd=${kwd}&page=${page+1}">[다음]</a>
					</c:if>
					
					</div>
				<div class="bottom">
					<c:if test="${not empty authUser}">
					<a href="/board/addform" id="new-book">글쓰기</a>
					</c:if>
				</div>
								
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="pageName" value="board"/>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp">
			</c:import>
		</div>
	</div>
</body>
</html>
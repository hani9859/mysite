<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		</div>
		<div id="content">
			<div id="user">
				<form id="modify-form" name="modifyForm" method="post" action="modify">
					<label class="block-label" for="name">이름</label>
					<label>${authUser.name}</label>

					<label class="block-label" for="email">이메일</label>
					<label>${authUser.email}</label>					
					<label class="block-label">패스워드</label>
					<input name="password1" type="password" value="">
					<label class="block-label">패스워드 확인</label>
					<input name="password2" type="password" value="">
					<%-- <fieldset>
						<legend>성별</legend>
						<label>남</label> 
						<c:choose>
							<c:when test="${authUser.gender=='male' }">
								<input type="radio" name="gender" value="male" checked="checked">
							</c:when>
							<c:otherwise>
								<input type="radio" name="gender" value="male">
							</c:otherwise>
						</c:choose>
						
						<label>여</label>
						<c:choose>
						<c:when test="${authUser.gender=='female' }">
								<input type="radio" name="gender" value="female" checked="checked">
							</c:when>
							<c:otherwise>
								<input type="radio" name="gender" value="female">
							</c:otherwise>
						</c:choose>
					</fieldset> --%>
					
					
					
					<input type="submit" value="수정하기">
					
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="pageName" value="user"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url = "/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
	</div>
</body>
</html>
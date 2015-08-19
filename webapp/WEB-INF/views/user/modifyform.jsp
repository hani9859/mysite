<%@ page contentType="text/html;charset=UTF-8" %>
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
				<form id="modify" name="modify" method="post" action="domodify">
					<label class="block-label" for="email">이메일</label>
					<label>${authUser.email}</label>
					
					<label class="block-label" >패스워드</label>
					<input name="password" type="password" value="">
					<input type="submit" value="확인">
					
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
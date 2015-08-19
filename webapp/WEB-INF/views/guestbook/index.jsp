<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%pageContext.setAttribute("newLineChar", "\n");%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
<script>
function checkform() {
	
	if( document.getElementById("password").value == "" ) {
		alert( "error");
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		</div>
		<div id="wrapper">
			<div id="content">
			<div id ="guestbook">
				<form action="/guestbook/add" method="post" onsubmit="return checkform();">
	<table border=1 width=500>
		<tr>
			<td>이름</td><td><input id="name" type="text" name="name"></td>
			<td>비밀번호</td><td><input id="password" type="password" name="password"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="message" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE="확인 "></td>
		</tr>
	</table>
	</form>
	<br>
	<c:forEach var="vo" items="${list}" varStatus="status">
	<table width=510 border=1>
		<tr class="no">
			<td>${status.index}</td>
			<td>${vo.name}</td>
			<td>${vo.regDate }</td>
			<td><a href="/guestbook/deleteform?no=${vo.no}">삭제</a></td>
		</tr>
		<tr class="no">
			<td colspan=4>${fn:replace(vo.message, newLineChar, "<br>")}</td>
		</tr>
	</table>
	</c:forEach>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
			<c:param name="pageName" value="main"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
		</div>
	</div>
	</div>
</body>
</html>
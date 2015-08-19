<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/assets/css/guestbook.css" rel="stylesheet" type="text/css">

</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		</div>
		<div id="guestbook">
			<div id="content">
					<form method="post" action="delete">
						<input type='hidden' name="no" value="${param.no}">
						<table class="delete-form">
							<tr>
								<td>비밀번호</td>
								<td><input type="password" name="password"></td>
								<td><input type="submit" value="확인"></td>
								<td><a href="/guestbook">메인으로 돌아가기</a></td>
							</tr>
						</table>
					</form>
				</div>
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
</body>
</html>
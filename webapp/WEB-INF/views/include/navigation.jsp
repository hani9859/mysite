<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
			<ul>
			<c:choose>
				<c:when test="${param.pageName =='main' }">
					<c:if test="${not empty authUser.name}">
					<li class='selected'><a href="/">${authUser.name}</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board/list">게시판</a></li>
					</c:if>
					<c:if test="${empty authUser.name}">
					<li class='selected'><a href="/">환영합니다</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board/list">게시판</a></li>
					</c:if>
				</c:when>
				<c:when test="${param.pageName=='guestbook' }">
					<c:if test="${not empty authUser.name}">
					<li><a href="/">${authUser.name }</a></li>
					<li class="selected"><a href="/guestbook">방명록</a></li>
					<li><a href="/board/list">게시판</a></li>
					</c:if>
					<c:if test="${empty authUser.name }">
					<li><a href="/">환영합니다</a></li>
					<li class="selected"><a href="/guestbook">방명록</a></li>
					<li><a href="/board/list">게시판</a></li>
					</c:if>
				</c:when>
				<c:when test="${param.pageName=='user' }">
					<c:if test="${not empty authUser.name}">
					<li><a href="/">${authUser.name }</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board/list">게시판</a></li>
					</c:if>
					<c:if test="${empty authUser.name}">
					<li><a href="/">환영합니다</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board/list">게시판</a></li>
					</c:if>
				</c:when>
				<c:when test="${param.pageName =='board' }">
					<c:if test="${not empty authUser.name}">
					<li><a href="/">${authUser.name}</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li class="selected"><a href="/board/list">게시판</a></li>
					</c:if>
					<c:if test="${empty authUser.name }">
					<li><a href="/">환영합니다</a></li>
					<li><a href="/guestbook">방명록</a></li>
					<li><a href="/board/list">게시판</a></li>
					</c:if>
				</c:when>
			</c:choose>
			<p><a href="http://www.op.gg/"><img id="opgg" src="/assets/images/opgg.png"></a></p>
			<p><a href="http://fow.kr/"><img id="fow" src="/assets/images/fow.png"></a></p>
			</ul>
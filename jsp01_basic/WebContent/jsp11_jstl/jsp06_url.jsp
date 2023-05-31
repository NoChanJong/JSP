<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 
	url관련태그는 url생성기능과 redirect처리기능을 제공한다.
 -->
 <!-- https://www.google.com/search?q=%EC%86%90%ED%9D%A5%EB%AF%BC-->
 <c:url var="search" value="https://www.google.com/search">
 	<c:param name="w" value="news"/>
 	<c:param name="q" value="손흥민"/>
 </c:url>
 
 <ul>
 	<li><a href="${ search }">구글에서 손흥민 검색하기</a></li>
 	<li><c:url value="jsp02_if.jsp"/></li>
 	<li><c:url value="./jsp02_if.jsp"/></li>
 </ul>
 
 <c:redirect url="http://www.naver.com"/>
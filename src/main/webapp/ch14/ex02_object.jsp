<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("name", "페이지 스코프");
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL</title>
	<style>
		td {padding: 3px;}
	</style>
</head>
<body style="margin: 40px; margin-bottom: 100px;">
	<h1>내장객체</h1>
	<hr>
	<table border="1">
		<tr><th>표현식</th><th>결과</th></tr>
		<tr><td>\${ page scope - 하나의 JSP 페이지에서만 사용할 수 있는 영역 (pageContext 기본 객체)}</td></tr>
		<tr><td>\${request scope - 하나의 요청[request]에서만 사용할 수 있는 영역 (request 기본 객체)}</td></tr>
		<tr><td>\${session scope - 하나의 웹 브라우저에서 사용할 수 있는 영역 (session 기본 객체)}</td></tr>
		<tr><td>\${application scope - 웹 어플리케이션(웹사이트) 영역 (application 기본 객체)}</td></tr>
		<tr><td>\${getAttributenames() - 모든 속성 목록 얻어오기 (pageContext 제공x)}</td></tr>
		<tr><td>\${param.id}</td><td>${param.id}</td></tr>
		<tr><td>\${empty param.addr ? "경기도 수원시 영화동" : param.addr}</td><td>${empty param.addr ? "경기도 수원시 영화동" : param.addr}</td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>\${applicationScope.aName}</td><td>${applicationScope.aName}</td></tr>
		<tr><td>\${sessionScope.sName}</td><td>${sessionScope.sName}</td></tr>
		<tr><td>\${requestScope.rName}</td><td>${requestScope.rName}</td></tr>
		<tr><td>\${pageScope.name}</td><td>${pageScope.name}</td></tr>
		<tr><td></td><td></td></tr>
		<tr><td>\${aName}</td><td>${aName}</td></tr>
		<tr><td>\${sName}</td><td>${sName}</td></tr>
		<tr><td>\${rName}</td><td>${rName}</td></tr>
		<tr><td>\${name}</td><td>${name}</td></tr>
		<tr><td>\${header.host}</td><td>${header.host}</td></tr>
		<tr><td>\${header.cookie}</td><td>${header.cookie}</td></tr>
		<tr><td>\${header["User-Agent"]}</td><td>${header["User-Agent"]}</td></tr>
		<tr><td>\${cookie.JSESSIONID.name}</td><td>${cookie.JSESSIONID.name}</td></tr>
		<tr><td>\${cookie.JSESSIONID.value}</td><td>${cookie.JSESSIONID.value}</td></tr>
	</table>
</body>
</html>
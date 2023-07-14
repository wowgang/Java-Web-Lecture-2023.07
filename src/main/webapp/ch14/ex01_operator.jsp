<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>EL 표현언어</title>
	<style>
		td {padding: 3px;}
	</style>
</head>
<body style="margin: 40px; margin-bottom: 100px;">
	<h1>EL 연산자</h1>
	<hr>
	<table border="1">
		<tr><th>계산식</th><th>결과</th></tr>
		<tr><td>\${100}</td><td>${100}</td></tr>
		<tr><td>\${"안녕하세요"}</td><td>${"안녕하세요"}</td></tr>
		<tr><td>\${10 +1}</td><td>${10 +1}</td></tr> 
		<tr><td>\${"10" +1}</td><td>${"10" +1}</td></tr> <%-- "10이 숫자 10으로 변환 --%>
		<%-- <tr><td>\${"안녕"+11}</td><td>${"안녕"+11}</td></tr>
		<tr><td>\${"hello" + "world"}</td><td>${"hello" + "world"}</td></tr> --%>
		<tr><td>\${"안녕"+11}</td><td>\{문자열과 숫자는 더할 수 없다}</td></tr>
		<tr><td>\${"hello" + "world"}</td><td>\{문자열끼리 더할 수 없다}</td></tr>
		<tr><td>\${20-10}</td><td>${20-10}</td></tr>
		<tr><td>\${20 * 10}</td><td>${20 * 10}</td></tr>
		<tr><td>\${100 / 9}</td><td>${20 / 10}</td></tr>
		<tr><td>\${100 % 9}</td><td>${100 % 9}</td></tr>
		<tr><td>\${100 mod 9}</td><td>${100 mod 9}</td></tr>
		<tr><td>\${10 == 10}</td><td>${10==10}</td></tr>
		<tr><td>\${20 != 10}</td><td>${20 != 10}</td></tr>
	</table>
</body>
</html>
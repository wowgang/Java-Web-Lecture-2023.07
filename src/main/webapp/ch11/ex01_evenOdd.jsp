<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	int num = (int) Math.ceil(Math.random()*10); //1에서 부터서 10까지의 정수
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>홀수 짝수</title>
</head>
<body>
	<h1>홀수 짝수</h1>
	<hr>
	int num = (int) Math.ceil(Math.random()*10);<br>
	꺽세 퍼센트에 =  을 붙이면 변수 값이 들어감.<br>
	조건문,반복문 사용시{ } 중괄호 열고 닫는거 해줘야함.
	<h3>난수를 통해서 얻은 숫자: <%= num %></h3>
	 <% if (num % 2 == 0) { %>
		 <h3>짝수입니다.</h3>
	 <% } else { %>
	 	<h3>홀수입니다.</h3>
	  <% } %>
	  <hr>
	  <% for (int i=0; i<num; i++) { %>
	  	<p> 안녕하세요? </p>
	  <% } %>	
</body>
</html>
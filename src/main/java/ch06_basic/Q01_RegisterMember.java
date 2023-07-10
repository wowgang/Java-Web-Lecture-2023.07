package ch06_basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Q01_RegisterMember
 */
@WebServlet("/ch06/register")
public class Q01_RegisterMember extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Form 화면 띄어주는 코드
		String uid_ = request.getParameter("uid");
		String pwd_ = request.getParameter("pwd");
		String uname_ = request.getParameter("uname");
		String email_ = request.getParameter("email");
		
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>Register Member</title>"
				+ "</head>"
				+ "<body style=\"margin: 40px\">"
				+ "	<h1>회원 등록</h1>"
				+ "	<hr>"
				+ "	<form action=\"/jw/ch06/register\" method=\"post\">"
				+ "		uid: <input type=\"text\" name=\"uid\"><br>"
				+ "		pwd: <input type=\"password\" name=\"pwd\"><br>"
				+ "		uname: <input type=\"text\" name=\"uname\"><br>"
				+ "		email: <input type=\"email\" name=\"email\"><br>"
				+ "		<input type=\"submit\" value=\"확인\">"
				+ "	</form>"
				+ "</body>"
				+ "</html>";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
				
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력 결과를 받아서 화면에 보여주는 코드
		System.out.println("doPost() method called.");
		request.setCharacterEncoding("utf-8"); // 한글 처리 필수
		
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String uname = request.getParameter("uname");
		String email = request.getParameter("email");
		

		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>Register Member</title>"
				+ "</head>"
				+ "<body style=\"margin: 40px\">"
				+ "	<h1>회원 등록</h1>"
				+ "	<hr>"
				
				+ " <ul>"
				+ "		<li>uid: " + uid + "</li>"
				+ "		<li>pwd: " + pwd + "</li>"
				+ "		<li>uname: " + uname + "</li>"
				+ "		<li>email: " + email + "</li>"
				+ " </ul>";
		html += "</body>"
				+ "</html>";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

}

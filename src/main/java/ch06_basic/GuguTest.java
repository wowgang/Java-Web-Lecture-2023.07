package ch06_basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  http://localhost:8090/jw/ch06/gugu.html
 */
@WebServlet("/ch06/guguTest")
public class GuguTest extends HttpServlet {
	public void init() 
	{
		System.out.println("init 메서드 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		int dan = Integer.parseInt(request.getParameter("dan"));
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>구구단 출력</title>"
				+ "</head>"
				+ "	<body style=\"margin: 40px\">"
				+ "	<h1>구구단</h1>"
				+ "	<hr>"
				+ "<table border=1 width=800 align=center>"
				+ "<tr align=center bgcolor='#FFFF66'>"
				+ "<td colspan=2>" + dan + " 단 출력 </td>"
				+ "</tr>";
				for (int i = 1; i <10; i++) {
					html += "<tr align=center>";
					html += "<td width=400>";
					html += dan + " * " +i;
					html += "</td>";
					html += "<td width=400>";
					html += i*dan;
					html += "</td>";
					html += "</tr>";
				}
				html += "</table>"
						+ "</body>"
						+ "</html>";
				out.print(html);
	}

	public void destroy()
	{
		System.out.println("destroy 메서드 호출");
	}
}

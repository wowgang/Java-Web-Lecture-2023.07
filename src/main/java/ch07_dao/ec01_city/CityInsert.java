package ch07_dao.ec01_city;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityInsert
 */
//@WebServlet("/ch07/city/insert")
public class CityInsert extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String html = "<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>City Update</title>"
				+ "	<style>"
				+ "		td {text-align: center; padding: 2px;}"
				+ "	</style>"
				+ "</head>"
				+ "<body style=\"margin: 40px\">"
				+ "	<h1>도시 추가</h1>"
				+ "	<hr>"
				+ "	<form action=\"/jw/ch07/city/insert\" method=\"post\">"
				+ "		<table>"
				+ "			<tr>"
				+ "				<td>Name</td><td><input type=\"text\" name=\"name\"></td>"
				+ "			</tr>"
				+ "			<tr>"
				+ "				<td>CountryCode</td><td><input type=\"text\" name=\"code\"></td>"
				+ "			</tr>"
				+ "			<tr>"
				+ "				<td>District</td><td><input type=\"text\" name=\"district\"></td>"
				+ "			</tr>"
				+ "			<tr>"
				+ "				<td>Population</td><td><input type=\"text\" name=\"population\"></td>"
				+ "			</tr>"
				+ "			<tr><td colspan=\"2\"><input type=\"submit\" value=\"추가\"></td></tr>"
				+ "		</table>"
				+ "		"
				+ "	</form>"
				+ "</body>"
				+ "</html>";
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(html);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");	// 한글이 들어올수도 있으니
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String district = request.getParameter("district");
		int population = Integer.parseInt(request.getParameter("population"));
		// City Dao에서 update갈때
		City city = new City(name, code, district, population);
		
		CityDao cDao = new CityDao();
		cDao.insertCity(city);
		
		response.sendRedirect("/jw/ch07/city/list");
		
	}

}

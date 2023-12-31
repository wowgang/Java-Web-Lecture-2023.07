package ch07_dao.ec01_city;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityUpdate
 */
//@WebServlet("/ch07/city/update")
public class CityUpdate extends HttpServlet {
	CityDao cDao = new CityDao();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_ = request.getParameter("id");
		int id = Integer.parseInt(id_);
		City city = cDao.getCity(id);
		
		String html ="<!DOCTYPE html>"
				+ "<html>"
				+ "<head>"
				+ "	<meta charset=\"UTF-8\">"
				+ "	<title>City Update</title>"
				+ "	<style>"
				+ "		td {text-align: center; padding: 2px;}"
				+ "	</style>"
				+ "</head>"
				+ "<body style=\"margin: 40px\">"
				+ "	<h1>도시 수정</h1>"
				+ "	<hr>"
				+ "	<form action=\"/jw/ch07/city/update\" method=\"post\">"
				+ "		<input type=\"hidden\" name=\"id\" value=\"" + city.getId() + "\">"
				+ "		<table>"
				+ "			<tr>"
				+ "				<td>Name</td><td><input type=\"text\" name=\"name\" value=\"" + city.getName() + "\"></td>"
				+ "			</tr>"
				+ "			<tr>"
				+ "				<td>CountryCode</td><td><input type=\"text\" name=\"code\" value=\"" + city.getCountryCode() + "\"></td>"
				+ "			</tr>"
				+ "			<tr>"
				+ "				<td>District</td><td><input type=\"text\" name=\"district\" value=\"" +city.getDistrict() + "\"></td>"
				+ "			</tr>"
				+ "			<tr>"
				+ "				<td>Population</td><td><input type=\"text\" name=\"population\" value=\"" + city.getPopulation() + "\"></td>"
				+ "			</tr>"
				+ "			<tr><td colspan=\"2\"><input type=\"submit\" value=\"수정\"></td></tr>"
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
		int id = Integer.parseInt(request.getParameter("id")); // form 에서 넘어오는 것은 다 String이기 때문에 타입변환 필요
		String name = request.getParameter("name");
		String code = request.getParameter("code");
		String district = request.getParameter("district");
		int population = Integer.parseInt(request.getParameter("population"));
		// City Dao에서 update갈때
		City city = new City(id, name, code, district, population);
		
		cDao.updateCity(city);
		
		response.sendRedirect("/jw/ch07/city/list");
		
		
//		doGet(request, response);
	}

}

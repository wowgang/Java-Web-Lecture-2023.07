package ch07_dao.ec01_city;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CityController
 * controller에 ist,insert,update,delete가 다 있는것임
 * GET,POST 나눠서 구분해서 입력해주고
 * 중복생성자 같은거는 위로 올려주기
 */
@WebServlet({ "/ch07/city/list", "/ch07/city/insert", "/ch07/city/update", "/ch07/city/delete" })
public class CityController extends HttpServlet {
	CityDao cDao = new CityDao();
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		String[] cmd_ = requestUri.split("/");
		String cmd = cmd_[cmd_.length -1]; // 맨마지막인 list,insert,update,delete만 가져올수있음
		
		int id = 0;
		String html = null;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		switch(cmd) {
		case "list": 
			List<City> list = cDao.getCityList("KOR", 10, 0);
			
			String data = "";// tab 두개정도 들어가야하나 무시하고 만듦
			
			for (City c: list) {
				data += "<tr>";
				data += "	<td>" + c.getId() + "</td>";
				data += "	<td>" + c.getName() + "</td>";
				data += "	<td>" + c.getCountryCode() + "</td>";
				data += "	<td>" + c.getDistrict() + "</td>";
				data += "	<td>" + c.getPopulation() + "</td>";
				data += "	<td>" +
							"<a href=\"/jw/ch07/city/update?id=" + c.getId() + "\">수정</a> " +
							"<a href=\"/jw/ch07/city/delete?id=" + c.getId() + "\">삭제</a>" +
							"</td>";
				data += "</tr>";
			}
			
			html = "<!DOCTYPE html>"
					+ "<html>"
					+ "<head>"
					+ "	<meta charset=\"UTF-8\">"
					+ "	<title>City List</title>"
					+ "	<style>"
					+ "		td, th {padding: 2px}"
					+ "	</style>"
					+ "</head>"
					+ "<body style=\"margin: 40px\">"
					+ "	<h1>도시 리스트</h1>"
					+ "	<hr>"
					+ "	<table border=\"1\">"
					+ "		<tr>"
					+ "			<th>ID</th><th>Name</th><th>CountryCode</th><th>District</th><th>Population</th><th>Action</th>"
					+ "		</tr>";
			html += data;
			html += "	</table>"
					+ "<button onclick=\"location.href='/jw/ch07/city/insert'\">추가</button>"
					+ "</body>"
					+ "</html>";
			out.print(html);
			break;
		case "insert":
			html = "<!DOCTYPE html>"
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
			out.print(html);
			break;
		case "update":
			id = Integer.parseInt(request.getParameter("id"));
			City city = cDao.getCity(id);
			
			html ="<!DOCTYPE html>"
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
			out.print(html);
			break;
		case "delete":
			id = Integer.parseInt(request.getParameter("id"));
			cDao.deleteCity(id);
			
			response.sendRedirect("/jw/ch07/city/list");
			
		}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestUri = request.getRequestURI();
		String[] cmd_ = requestUri.split("/");
		String cmd = cmd_[cmd_.length -1]; // 맨마지막인 list,insert,update,delete만 가져올수있음
		
		request.setCharacterEncoding("utf-8");	// 한글이 들어올수도 있으니
		String name = null, code = null, district = null;
		int population = 0;
		City city = null;
		
		switch (cmd) {
		case "insert":
			name = request.getParameter("name");
			code = request.getParameter("code");
			district = request.getParameter("district");
			population = Integer.parseInt(request.getParameter("population"));
			// City Dao에서 update갈때
			city = new City(name, code, district, population);
			
			cDao.insertCity(city);
			
			response.sendRedirect("/jw/ch07/city/list");
			break;
		case "update":
			int id = Integer.parseInt(request.getParameter("id")); // form 에서 넘어오는 것은 다 String이기 때문에 타입변환 필요
			name = request.getParameter("name");
			code = request.getParameter("code");
			district = request.getParameter("district");
			population = Integer.parseInt(request.getParameter("population"));
			// City Dao에서 update갈때
			city = new City(id, name, code, district, population);
			
			cDao.updateCity(city);
			
			response.sendRedirect("/jw/ch07/city/list");
			break;
			
		}
	}

}

package ch07_dao.ec01_city;
// Servlet만들기
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CitySearch
 */
@WebServlet("/ch07/city/search")
public class CitySearch extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CityDao cDao = new CityDao();
		City city = cDao.getCity(2331);// 2331 id 값
		
		PrintWriter out = response.getWriter();
		out.append("Served at: ").append(request.getContextPath());
		out.println(city);
		
	}


}

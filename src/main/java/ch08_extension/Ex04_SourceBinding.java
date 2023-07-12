package ch08_extension;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex04_SourceBinding
 */
@WebServlet("/ch08/src4")
public class Ex04_SourceBinding extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/jw/ch08/src4 doGet()");
		String[] fruits = "사과,배,감,귤".split(",");
		// Request scope
		// http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용
		request.setAttribute("requestAddr", "경기도 수원시 장안구 영화 리퀘스트");
		request.setAttribute("requestFruits", fruits);
		// Session scope
		// 웹 브라우저 별로 변수가 관리되는 경우 사용
		HttpSession session = request.getSession();
		session.setAttribute("sessionAddr", "경기도 수원시 장안구 영화 세션");
		session.setAttribute("sessionFruits", fruits);
		// Application scope
		// 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용
		ServletContext ctx = getServletContext();
		ctx.setAttribute("applicationAddr", "경기도 수원시 장안구 영화 어플리케이션");
		ctx.setAttribute("applicationFruits",fruits);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ch08/dst4");
		rd.forward(request, response);
	}

}

package ch09_cookie_session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ex03_Setsession
 */
@WebServlet("/ch09/setSession")
public class Ex03_Setsession extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String id = session.getId();
		int interval = session.getMaxInactiveInterval(); // session의 유효기간
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>isNew: " + session.isNew() + "</h1>");	// 최초로 생성된 세션인지 파악 isNew()
		out.print("<h1>id(JSESSIONID): " + id + "</h1>");
		out.print("<h1>maxInactiveInterval: " + interval + "</h1>");	// 1800 = 30min
		
//		session.invalidate();	// 세션을 강제로 삭제 = > isNew: true 가 됨(새탭으로 들어가도 true임)
		
		
	}

}

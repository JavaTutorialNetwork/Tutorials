package net.javatutorial.tutorials;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletInfo extends HttpServlet {

	private static final long serialVersionUID = -2383814320847175129L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		PrintWriter pr = response.getWriter();
		
		pr.println("=== Paths ===\n");
		pr.println("Request URL : " + request.getRequestURL());
		pr.println("Request URI : " + request.getRequestURI());
		pr.println("Servlet path : " + request.getServletPath());
		
		pr.println("\n=== Headers ===\n");
		Enumeration<String> e = request.getHeaderNames();
		while(e.hasMoreElements()){
			String param = (String) e.nextElement();
			pr.println(param + " : " + request.getHeader(param));
		}
		
		pr.println("\n=== Parameters ===\n");
		Map<String, String[]> paramsMap = request.getParameterMap();
		for (String key : paramsMap.keySet()) {
			pr.println(key + " : " + request.getParameter(key));
		}
		
		pr.println("\n=== Session ===\n");
		// returns 0:0:0:0:0:0:0:1 if executed from localhost
		pr.println("Client IP address : " + request.getRemoteAddr());
		pr.println("Session ID : " + request.getRequestedSessionId());
		// Cookie objects the client sent with this request
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				pr.print(cookie.getName() + ";");
			}
		}
	}

}

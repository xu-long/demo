package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie c=new Cookie("url","www.baidu.com");
		Cookie[] cookies = request.getCookies();
		List<String> cookieStr=new ArrayList<String>();
		for(Cookie cookie:cookies)
		{
			String str=cookie.getName()+":"+cookie.getValue();
			cookieStr.add(str);
			System.out.println(str);
		}
		response.addCookie(c);
		request.setAttribute("cookieStr", cookieStr);
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}
}	

package interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sun.media.jfxmedia.logging.Logger;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("after-----------");
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle-----------");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		boolean bool=true;
		HandlerMethod  hm=(HandlerMethod) obj;
		Method method = hm.getMethod();
		String name = method.getName();
		System.out.println(request.getRealPath("/"));
		System.out.println(request.getPathInfo());
		System.out.println(request.getContextPath());
		System.out.println(request.getRequestURL());
		System.out.println(request.getServletPath());
		
		System.out.println(name+"------");
		if(name.equals("insert")){
			Object loginUser = request.getSession().getAttribute("LoginUser");
			if(loginUser==null)
			{
				bool=false;
				request.getSession().setAttribute("requestPath1",name);
				response.sendRedirect("login.jsp");
			}
		}
		return bool;
	}

}

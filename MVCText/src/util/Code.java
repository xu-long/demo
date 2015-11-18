package util;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Code implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("-========================================");
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		String method = req.getMethod();
		if("get".equalsIgnoreCase(method))
		{
			Map<String, String[]> params = req.getParameterMap();
			Set<String> keys = params.keySet();
			for(String key:keys)
			{
				String[] values = params.get(key);
				for(int i=0;i<values.length;i++){
					values[i]=new String(values[i].getBytes("iso-8859-1"),"utf-8");
				}
			}
			
		}else{
			req.setCharacterEncoding("utf-8");
		}
		resp.setContentType("text/html;charset=utf-8");
		chain.doFilter(req, resp);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

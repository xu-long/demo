package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import entity.User;

@Controller

public class UserController {
	private static List<User> users;
	static{
		users=new ArrayList<User>();
		User user=new User();
		user.setPassword("admin");
		user.setUserName("admin");
		user.setTopImage("44.jpg");
		users.add(user);
		
	}
	private Logger logger=Logger.getLogger(getClass());
	
	@RequestMapping("/login")
	public String login(User user,ModelMap map,HttpServletRequest request,HttpServletResponse response) throws IOException{
		logger.debug(user);
		boolean bool=false;
		for(User u:users)
		{
			if(u.getPassword().equals(user.getPassword())&&
					u.getUserName().equals(user.getUserName()))
			{
				bool=true;
				map.put("user",u);
				request.getSession().setAttribute("LoginUser", u);
				Object path =request.getSession().getAttribute("requestPath1");
				if(path!=null)
				{
					response.sendRedirect(path.toString());		
				}
				break;
			}
		}
		System.out.println(bool);
		if(bool)
			return "/view.jsp";
		else
			return "/login.jsp";
	}
	
	@RequestMapping("/add")
	public String add(User user,HttpServletRequest request) throws IllegalStateException, IOException{

		CommonsMultipartResolver multipart=new CommonsMultipartResolver(
				request.getSession().getServletContext());
		
		if(multipart.isMultipart(request))
		{
			MultipartHttpServletRequest multipartReq = multipart.resolveMultipart(request);
			Iterator<String> fileNames = multipartReq.getFileNames();
			MultipartFile file = multipartReq.getFile("topImage");
			String fileName = file.getOriginalFilename();
			String userName = multipartReq.getParameter("userName");
			String password = multipartReq.getParameter("password");
			User us=new User();
			us.setPassword(password);
			us.setUserName(userName);
			us.setTopImage(fileName);
			users.add(us);
			File newFile=new File(request.getSession().getServletContext().getRealPath("/")+"image/"+fileName);
			file.transferTo(newFile);
		}
		return "/login.jsp";
	}
	
	@RequestMapping("/insert")
	public String insert(){
		return "/insert.jsp";
	}
	
}

package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.Student;

@Controller
public class TestController {
	@RequestMapping("/test")
	public String test(Student stu,HttpServletRequest request,HttpServletResponse response){
		System.out.println(stu.toString());
		return "/test.jsp";
	}
}

package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import entity.Student;
import service.StudentService;

public class StudentController{
	private StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	

	public ModelAndView save(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		Integer age=Integer.parseInt(request.getParameter("age"));
		studentService.save(new Student(name, sex, age));
		return query(request,response);
	}
	
	public ModelAndView query(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
		List<Student> list = studentService.query();
		return new ModelAndView("/list.jsp","list",list);
	}
	
}

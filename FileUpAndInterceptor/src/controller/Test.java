package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import dao.TestDao;

@Controller
public class Test {
	@Autowired
	private TestDao testDao;
	
	@RequestMapping("/test")
	public void main() {
		testDao.test();
	}
}

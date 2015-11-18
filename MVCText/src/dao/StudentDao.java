package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import entity.Student;

public class StudentDao {
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public void save(Student stu){
		template.update("insert into student values(null,?,?,?)",new Object[]{stu.getSname(),stu.getSsex(),stu.getSage()});
	}

	public List<Student> query() {
		List<Student> list =new ArrayList<Student>();
		List<Map<String, Object>> students = template.queryForList("select * from student");
		for(Map map:students){
			Student stu=new Student();		
			stu.setSid(Integer.parseInt(map.get("sid").toString()));
			stu.setSname(map.get("sname").toString());
			stu.setSsex(map.get("ssex").toString());
			stu.setSage(Integer.parseInt(map.get("sage").toString()));
			System.out.println(stu.toString());
			list.add(stu);
			
			
		}
		return list;
	}
}

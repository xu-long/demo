package service;

import java.util.List;

import dao.StudentDao;
import entity.Student;

public class StudentService {
	private  StudentDao studentDao;

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	public void save(Student stu){
		studentDao.save(stu);
	}

	public  List<Student> query() {
		return studentDao.query();
	}
	
}

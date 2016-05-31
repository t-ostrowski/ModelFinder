package org.acteacademie.modelfinder.controllers;

import java.util.Collection;
import javax.annotation.Resource;

import org.acteacademie.modelfinder.domain.StringResponse;
import org.acteacademie.modelfinder.domain.Student;
import org.acteacademie.modelfinder.services.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@Resource
	StudentService studentService;
	
	@CrossOrigin
	@RequestMapping("/studentList")
	public Collection<Student> getAll(){
		return this.studentService.getAllStudent();
	}
	
	@CrossOrigin
	@RequestMapping("/StudentById/{id}")
	public Student getOne(@PathVariable("id") Long id){
		return this.studentService.getOneStudent(id);
	}
	
	@CrossOrigin
	@RequestMapping("/ValidateStudent/{id}")
	public StringResponse validateStudent(@PathVariable("id") Long id){
		Student student = this.studentService.getOneStudent(id);
		student.setIsValidated(true);
		this.studentService.saveStudent(student);
		return new StringResponse("success");
	}
	
	@CrossOrigin
	@RequestMapping(value="/SaveStudent", method=RequestMethod.POST, produces = "application/json")
	public StringResponse saveStudent(@RequestBody Student student){
		this.studentService.saveStudent(student);
		return new StringResponse("success");
	}
	
	@CrossOrigin
	@RequestMapping("/DeleteStudent/{id}")
	public StringResponse deleteStudent(@PathVariable("id") Long id){
		this.studentService.deleteStudent(id);
		return new StringResponse("success");
	}
}
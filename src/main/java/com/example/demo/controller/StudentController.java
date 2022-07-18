package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.Student;
import com.example.demo.service.IstudentService;

@Controller
public class StudentController {

	@Autowired
	private IstudentService studentService;

	@GetMapping("/test")
	public String test() {
		return "index";
	}

	@GetMapping("/getAll")
	public String getAll(Model model) {
		model.addAttribute("listStudent", studentService.listAll());

		return "listStudent";
	}

	@GetMapping("/form/student")
	public String formStudent(Model model) {
		model.addAttribute("student", new Student());
		return "studentForm";
	}

	@PostMapping("/save/student")
	public RedirectView addStudent(@RequestParam(value = "id", required = false) int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("age") int age,
			@RequestParam("lophoc") String lophoc) {
		Student student;
		if(0 != id) {
			student = studentService.getById(id);
		}else {
			student = new Student();
		}
		student.setFirstname(firstname);
		student.setAge(age);
		student.setLastname(lastname);
		student.setLophoc(lophoc);

		studentService.addStudent(student);

		return new RedirectView("/getAll", true);

	}

	@GetMapping("deleted/student")
	public RedirectView deleteById(@RequestParam("id") int id) {

		studentService.deleteStudentById(id);
		return new RedirectView("/getAll", true);
	}

	@GetMapping("/update/student")
	public String updateStudentById(@RequestParam("id") int id, Model model) {
		Student student = studentService.getById(id);
		model.addAttribute("student", student);
		return "studentForm";
	}

}

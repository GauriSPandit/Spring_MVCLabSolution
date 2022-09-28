package com.greatlearning.studentregistration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.studentregistration.entity.Student;
import com.greatlearning.studentregistration.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	// mapping for "/list"

	@RequestMapping("/list")
	public String listStudents(Model theModel) {

		// get Students from db
		List<Student> theStudents = studentService.findAll();

		// add to the spring model
		theModel.addAttribute("Students", theStudents);

		return "list-Students";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Student theStudent = new Student();

		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int theId, Model theModel) {

		// find the student using the Id 
		Student theStudent = studentService.findById(theId);

		// adding student to model for populating the form for update
		theModel.addAttribute("Student", theStudent);

		return "Student-form";
	}

	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		System.out.println(id);
		Student theStudent;
		if (id != 0) {//carrying out the update finding by id and saving the updated data
			theStudent = studentService.findById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		} else
			theStudent = new Student(name, department, country);//else create a new student
		// save the student to database
		studentService.save(theStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/students/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		// delete the student with the help of data 
		studentService.deleteById(theId);

		// redirect to /students/list
		return "redirect:/students/list";

	}

	@RequestMapping("/search")
	public String search(@RequestParam("search") String search, Model theModel) {

		// search term is used to find if it is matching with any field

		if (search.trim().isEmpty()) {
			return "redirect:/students/list";//If no search term than populate the complete list
		} else {
			// else, call the search method 
			List<Student> theStudents = studentService.searchBy(search);

			// add to the spring model
			theModel.addAttribute("Students", theStudents);

			// pupulate the table
			return "list-Students";
		}

	}
}

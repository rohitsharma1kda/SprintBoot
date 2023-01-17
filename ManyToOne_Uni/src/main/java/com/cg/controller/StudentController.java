package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entities.Student;
import com.cg.exception.NoStudentException;
import com.cg.services.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService sService;

	@PostMapping("/student")
	public ResponseEntity<Student> createStudent(@RequestBody Student s) {
		return new ResponseEntity<>(sService.addStudent(s), HttpStatus.CREATED);
	}

	@GetMapping("/studentlist")
	public ResponseEntity<List<Student>> getAllStudent() {
		return ResponseEntity.ok(sService.findAllStudent());
	}

	@GetMapping("/studentbyid/{id}")
	public ResponseEntity<Student> getById(@PathVariable("id") int id) throws NoStudentException {
		return ResponseEntity.ok(sService.findById(id));
	}

	@GetMapping("/studentbyname/{name}")
	public ResponseEntity<List<Student>> getByName(@PathVariable String name) {
		return ResponseEntity.ok(sService.findStudentByName(name));
	}

	@PutMapping("/student/{id}")
	public ResponseEntity<Student> modifyStudent(@PathVariable("id") int id, @RequestBody Student s)
			throws NoStudentException {
		return ResponseEntity.accepted().body(sService.modifyStudent(id, s));
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) throws NoStudentException {
		return new ResponseEntity<>(sService.deleteStudent(id) ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED);
	}
}

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

import com.cg.entities.Course;
import com.cg.exception.NoCourseException;
import com.cg.services.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService cService;

	@PostMapping("/course")
	public ResponseEntity<Course> createCourse(@RequestBody Course c) {
		return new ResponseEntity<>(cService.addCourse(c), HttpStatus.CREATED);
	}

	@GetMapping("/courselist")
	public ResponseEntity<List<Course>> getAllCourse() {
		return ResponseEntity.ok(cService.findAllCourse());
	}

	@GetMapping("/coursebyid{id}")
	public ResponseEntity<Course> getById(@PathVariable("id") int id) throws NoCourseException {
		return ResponseEntity.ok(cService.findById(id));
	}

	@GetMapping("/coursebyname/{name}")
	public ResponseEntity<List<Course>> getByName(@PathVariable String cName) {
		return ResponseEntity.ok(cService.findCourseByName(cName));
	}

	@PutMapping("course/{id}")
	public ResponseEntity<Course> modifyStudent(@PathVariable("id") int id, @RequestBody Course c)
			throws NoCourseException {
		return ResponseEntity.accepted().body(cService.modifyCourse(id, c));
	}

	@DeleteMapping("course/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable("id") int id) throws NoCourseException {
		return new ResponseEntity<>(cService.deleteCourse(id) ? HttpStatus.ACCEPTED : HttpStatus.NOT_MODIFIED);
	}
}

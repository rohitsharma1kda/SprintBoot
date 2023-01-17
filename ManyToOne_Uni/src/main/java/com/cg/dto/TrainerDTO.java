package com.cg.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class TrainerDTO {

	/*
	 * @Size annotation is used to restrict the filed length to a specified value.
	 * It has attributes such as max and min which are used to set the maximum and
	 * minimum values respectively. The message attribute in this annotation is used
	 * to display a default message on validation failure.
	 */
	private int tId;
	@NotBlank
	@Size(max = 10, min = 4, message = "min 5 is required")
	private String firstName;

	@NotBlank
	@Size(max = 10, min = 4, message = "min 5 is required")
	private String lastName;

	@NotBlank
	@Email(message = "blank/ invalid email format")
	private String email;

	@Past
	private LocalDate joiningDate;

	@NotBlank
	@Size(max = 10, min = 4, message = "min 5 is required")
	private String compName;

	@NotBlank
	@Size(max = 10, min = 4, message = "min 5 is required")
	private String subject;

	public TrainerDTO(int tId, String firstName, String lastName, String email, String compName, String subject,
			LocalDate joiningDate) {
		super();
		this.tId = tId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.compName = compName;
		this.subject = subject;
		this.joiningDate = joiningDate;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public TrainerDTO() {
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}

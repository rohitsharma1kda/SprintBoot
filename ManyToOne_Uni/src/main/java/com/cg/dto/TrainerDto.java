package com.cg.dto;

import java.time.LocalDate;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TrainerDto {

	private int tId;

	@NotNull
	@Min(value = 3, message = "First Name should have atleast 3 characters")
	private String fName;

	@NotNull
	private String lName;

	private String subject;
	private LocalDate date;
}

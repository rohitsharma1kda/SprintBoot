package com.cg.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "new_tratbl")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
//	create table new_tratbl(tid int primary key,fname varchar2(10) not null)
	private String firstName;
	private String lastName;
	private String subject;
	private LocalDate date;

}

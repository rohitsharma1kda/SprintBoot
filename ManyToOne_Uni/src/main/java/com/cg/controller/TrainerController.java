package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.dto.TrainerDTO;
import com.cg.entities.Trainer;
import com.cg.services.TrainerService;

@RestController
public class TrainerController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TrainerService tService;

	@PostMapping("/trainer")
	public ResponseEntity<TrainerDTO> createTrainer(@Valid @RequestBody TrainerDTO trainerDto) {

		// convert TrainerDTO to Trainer entity
		Trainer tobj = modelMapper.map(trainerDto, Trainer.class);
		Trainer tobjdb = tService.addTrainer(tobj);

		// convert entity to DTO
		TrainerDTO trainerResponse = modelMapper.map(tobjdb, TrainerDTO.class);

		return new ResponseEntity<>(trainerResponse, HttpStatus.CREATED);
	}

	@GetMapping("/trainerlist")
	public ResponseEntity<List<TrainerDTO>> getAllTrainers() {
		List<TrainerDTO> trainers = modelMapper.map(tService.findAllTrainers(), new TypeToken<List<TrainerDTO>>() {
		}.getType());
		return ResponseEntity.ok(trainers);
	}
}
package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.dao.TrainerRepository;
import com.cg.entities.Trainer;

@Service
public class TrainerServiceImpl implements TrainerService {

	@Autowired
	private TrainerRepository tRepo;

	@Override
	@Transactional
	public Trainer addTrainer(Trainer trainer) {
		return tRepo.save(trainer);
	}

	@Override
	public List<Trainer> findAllTrainers() {
		return tRepo.findAll();
	}

}

package com.cg.services;

import java.util.List;
import com.cg.entities.Trainer;

public interface TrainerService {

	public Trainer addTrainer(Trainer trainer);

	List<Trainer> findAllTrainers();
}

package com.capg.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.Exception.KeyViolationException;
import com.capg.Exception.ResourceNotFoundException;
import com.capg.Model.Trainer;
import com.capg.Model.Users;
import com.capg.Repository.ITrainerRepo;

@Service
public class TrainerService {

	@Autowired
	ITrainerRepo trainerRepo;

	public Object registerTrainer(Trainer trainerObj) {
		// System.out.print(1);
		trainerObj = generateUserId(trainerObj);
		try {
			//Get by email and throw exception on duplicate
			return trainerRepo.save(trainerObj);
		}
		catch(Exception e) {
			return new KeyViolationException ("RECORD EXISTED...");
		}
	}
	
	//get by id add

	public Trainer generateUserId(Trainer trainer) {
		Users user = trainer.getUser();
		user.setUserID("TNR-" + trainer.getTechnology().substring(0, 3) + "-" + (trainerRepo.count() + 1));
		trainer.setUser(user);
		return trainer;
	}

	public Optional<Trainer> getTrainerByName(String name) {
//		System.out.print(trainerRepo.findByName(name));
		return Optional.of(trainerRepo.findByName(name));
	}

	public Optional<Trainer>  getTrainerById(String id) {
		try {
			return Optional.of(trainerRepo.findByTrainerId(id));
		}
		catch(Exception e) {
			throw new ResourceNotFoundException("NO SUCH ID");
		}
	}

}

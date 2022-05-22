package com.capg.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.capg.Model.Trainer;

@Repository
public interface ITrainerRepo extends JpaRepository<Trainer,Integer> {

	Trainer findByName(String name);

	Trainer findByTrainerId(String id);
	 
}



package com.capg.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.Model.Trainer;
import com.capg.Service.TrainerService;

@RestController
@RequestMapping("Trainer")
public class TrainerRestController {

	@Autowired
	TrainerService trainerService;

	@PostMapping("/register")
	public ResponseEntity<String> registerTrainer(@Validated @RequestBody Trainer trainer) {
		Object trainerResponse = trainerService.registerTrainer(trainer);
		return new ResponseEntity<String>(trainerResponse.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/getTrainerObj/{name}")
	public ResponseEntity<Trainer> getTrainerObj(@PathVariable("name") String name) {
		java.util.Optional<Trainer> trainer = trainerService.getTrainerByName(name);
		return new ResponseEntity<Trainer> (trainer.get(), HttpStatus.OK);
	}
	
	@GetMapping("/getTrainerById/{id}")
	public ResponseEntity<Trainer> getTrainerById(@PathVariable("id") String id){
		java.util.Optional<Trainer> trainer = trainerService.getTrainerById(id);
		return new ResponseEntity<Trainer> (trainer.get(), HttpStatus.OK);
	}
}

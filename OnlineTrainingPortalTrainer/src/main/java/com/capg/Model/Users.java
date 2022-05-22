package com.capg.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public @Data class Users {

	@Id
	private String userID;
	
	@Column(unique=true)
	@Pattern(regexp="^[a-zA-Z0-9]{3,}$",message="length must be 3 & No spl Char")  
	private String userName;
	
	@Pattern(regexp="^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$",message="Password format")
	private String password;


}

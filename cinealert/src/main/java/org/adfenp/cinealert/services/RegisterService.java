package org.adfenp.cinealert.services;

import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.LoginResponse;
import org.adfenp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
	
	@Autowired
	private UsersRepo usersRepo;
	
	
	public LoginResponse handleRegister(User user) {
		User userCheck = usersRepo.findUsersByUsername(user.getUsername());
		if( userCheck == null){	
			usersRepo.save(user);
			LoginResponse loginResponse= new LoginResponse("SUCCESS", "User registration complete",String.valueOf(user.getRole()));
			return  loginResponse;
		}
		return new LoginResponse("FAIL", "Username with value ", String.valueOf(userCheck.getUsername())+" exist.Plz provide new username");
	}
	

}

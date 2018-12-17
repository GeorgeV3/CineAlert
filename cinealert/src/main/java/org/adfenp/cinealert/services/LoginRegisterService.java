package org.adfenp.cinealert.services;

import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.LoginRegisterResponse;
import org.adfenp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginRegisterService {

	@Autowired
	private UsersRepo usersRepo;

	public LoginRegisterResponse handleLogin(String username, String password){
		User user = usersRepo.findUserByusernameAndPassword(username, password);
		if( user == null){
			LoginRegisterResponse loginResponse= new LoginRegisterResponse("FAILED", "AUTH FAILED - WHATEVER");
			return  loginResponse;
		}
		return new LoginRegisterResponse("SUCCESS", "OLA KALA", String.valueOf(user.getRole()));
	}
	
	public LoginRegisterResponse handleRegister(User user) {
		User userCheck = usersRepo.findUsersByUsername(user.getUsername());
		if( userCheck == null){	
			usersRepo.save(user);
			LoginRegisterResponse loginResponse= new LoginRegisterResponse("SUCCESS", "User registration complete."
					,String.valueOf(user.getRole()));
			return  loginResponse;
		}
		return new LoginRegisterResponse("FAIL", "DUBLICATE USERNAME"
				,"Username : " + String.valueOf(userCheck.getUsername())+" exist.Plz provide new username");
	}

}

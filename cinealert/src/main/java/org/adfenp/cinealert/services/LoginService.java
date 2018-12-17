package org.adfenp.cinealert.services;

import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.LoginResponse;
import org.adfenp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {

	@Autowired
	private UsersRepo usersRepo;

	public LoginResponse handleLogin(String username, String password){
		User user = usersRepo.findUserByusernameAndPassword(username, password);
		if( user == null){
			LoginResponse loginResponse= new LoginResponse("FAILED", "AUTH FAILED - WHATEVER");
			return  loginResponse;
		}
		return new LoginResponse("SUCCESS", "OLA KALA", String.valueOf(user.getRole()));
	}

}

package org.adfenp.cinealert.services;

import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginRegisterService {

	@Autowired
	private UsersRepo usersRepo;

	public MessagesResponse handleLogin(String username, String password){
		User user = usersRepo.findUserByusernameAndPassword(username, password);
		if( user == null){
			MessagesResponse loginResponse= new MessagesResponse("FAILED", "WRONG USERNAME OR PASSWORD");
			return  loginResponse;
		}
		return new MessagesResponse("SUCCESS", "LOGIN IN", String.valueOf(user.getRole()));
	}
	
	
	public MessagesResponse handleRegister(User user) {
		User userCheck = usersRepo.findUsersByUsername(user.getUsername());
		if( userCheck == null){	
			usersRepo.save(user);
			MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "User registration complete."
					,String.valueOf(user.getRole()));
			return  registerResponce;
		}
		return new MessagesResponse("FAIL", "DUPLICATE USERNAME"
				,"Username : " + String.valueOf(userCheck.getUsername())+" exist.Plz provide new username");
	}

}

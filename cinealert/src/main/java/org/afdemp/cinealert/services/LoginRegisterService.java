package org.afdemp.cinealert.services;

import org.afdemp.cinealert.dao.UsersRepo;
import org.afdemp.cinealert.model.MessagesResponse;
import org.afdemp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class LoginRegisterService {
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 

	@Autowired
	private UsersRepo usersRepo;

	public MessagesResponse handleLogin(String username, String password){
		
		User user = usersRepo.findUsersByUsername(username);
		String passwordDB="";
		
		if( user == null ){
			MessagesResponse loginResponse= new MessagesResponse("FAILED", "WRONG USERNAME");
			return  loginResponse;
		}
		if( passwordEncoder.matches(password, passwordDB = user.getPassword())) {
			return new MessagesResponse("SUCCESS", "LOGIN IN", String.valueOf(user.getRole()));
		}
			
		return new MessagesResponse("FAILED", "WRONG PASSWORD", String.valueOf(user.getRole()));
	}
	

	public MessagesResponse handleRegister(User user) {

		User userCheck = new User();
		userCheck =usersRepo.findUsersByUsername(user.getUsername());
		
		if( userCheck == null ){
			
			usersRepo.save(user);
			MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "User registration complete."
					,String.valueOf(user.getRole()));
			return  registerResponce;
		}
		return new MessagesResponse("FAILED", "DUPLICATE USERNAME"
				,"Username : " + String.valueOf(userCheck.getUsername())+" exist.Plz provide new username");
	}

}

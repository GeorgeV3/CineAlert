package org.adfenp.cinealert.services;

import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.model.User;
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
		
		if( user == null){
			MessagesResponse loginResponse= new MessagesResponse("FAILED", "WRONG USERNAME");
			return  loginResponse;
		}
		if( passwordEncoder.matches(password, passwordDB = user.getPassword())) {
			return new MessagesResponse("SUCCESS", "LOGIN IN", String.valueOf(user.getRole()));
		}
			
		return new MessagesResponse("FAILED", "WRONG PASSWORD", String.valueOf(user.getRole()));
	}
	
	//(String username , String firstName , String lastName , String password , String email)
	public MessagesResponse handleRegister(String username , String firstName , String lastName , String password , String email) {
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(password);
		User userCheck = usersRepo.findUsersByUsername(user.getUsername());
		if( userCheck == null){	
			usersRepo.save(user);
			MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "User registration complete."
					,String.valueOf(user.getRole()));
			return  registerResponce;
		}
		return new MessagesResponse("FAILED", "DUPLICATE USERNAME"
				,"Username : " + String.valueOf(userCheck.getUsername())+" exist.Plz provide new username");
	}

}

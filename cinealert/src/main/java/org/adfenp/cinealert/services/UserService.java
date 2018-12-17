package org.adfenp.cinealert.services;



import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private static final Logger log = LoggerFactory.getLogger(Init.class); 
	@Autowired
	private UsersRepo usersRepo;


	public MessagesResponse handleUpdateUser(User user) {
		User userCheck = usersRepo.findUsersByUsername(user.getUsername());
		String email=null;
		String password=null;
		String role=null;
		role=user.getRole();
		password=user.getPassword();
		email=user.getEmail();
		if( userCheck == null){	
			MessagesResponse loginResponse= new MessagesResponse("FAILED", "NO USER EXIST TO UPDATE");
			return  loginResponse;
		}
		if(email == null || email.trim().length()==0) {
		}
		else {
			userCheck.setEmail(user.getEmail());
		}

		log.info("See pass.."  + user.getRole().length()+"keno");
		if(password == null || password.trim().length()==0) {

		}else {
			userCheck.setPassword(user.getPassword());
		}

		if(role == null || role.trim().length()==0) {
		}
		else {
			userCheck.setRole(user.getRole());
		}

		usersRepo.save(userCheck);
		return new MessagesResponse("SUCCESS", "UPDATE COMPLETE");
	}

	public MessagesResponse handleDeleteUser(User user) {
		User userCheck = usersRepo.findUsersByUsername(user.getUsername());
		if( userCheck != null){	
			userCheck.setStatus("DELETED");
			usersRepo.save(userCheck);
			return new MessagesResponse("SUCCESS", "DELETE COMPLETE",String.valueOf(userCheck.getStatus()));
		}
		return new MessagesResponse("FAIL", "DELETE USER");

	}
}

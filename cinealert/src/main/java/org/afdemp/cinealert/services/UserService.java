package org.afdemp.cinealert.services;



import org.afdemp.cinealert.dao.UsersRepo;
import org.afdemp.cinealert.model.MessagesResponse;
import org.afdemp.cinealert.model.User;
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
		if(userCheck == null){	
			MessagesResponse updateResponse= new MessagesResponse("FAILED", "NO USER EXIST TO UPDATE");
			return  updateResponse;
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
		//thelei ftiaksimo to return 
		usersRepo.save(userCheck);
		return new MessagesResponse("SUCCESS", "UPDATE COMPLETE",String.valueOf(userCheck.getRole()));
	}

	public MessagesResponse handleDeleteUser(User user) {
		User userCheck = usersRepo.findUsersByUsername(user.getUsername());
		
		
		
		if( userCheck != null ){	
			userCheck.setStatus("DELETED");
			usersRepo.save(userCheck);
			MessagesResponse deleteResponse = new MessagesResponse("SUCCESS", "DELETE COMPLETE",String.valueOf(userCheck.getStatus()));
			return deleteResponse;
		}
		return new MessagesResponse("FAIL", "NO USER EXIST IN DATABASE FOR DELETE",String.valueOf(user.getRole()));

	}
}

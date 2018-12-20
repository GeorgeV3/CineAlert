package org.afdemp.cinealert.controllers;

import java.util.List;

import javax.validation.Valid;

import org.afdemp.cinealert.dao.UsersRepo;
import org.afdemp.cinealert.model.MessagesResponse;
import org.afdemp.cinealert.model.User;
import org.afdemp.cinealert.services.LoginRegisterService;
import org.afdemp.cinealert.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UsersController {
	
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
    private LoginRegisterService loginRegisterService;
	
	@Autowired
	private UserService userService;
	


    @GetMapping(path = "/getUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usersRepo.findAll());
    }
    
    @RequestMapping(value = "/findUserMsgs/{username}")
    public User findByUsername(@PathVariable("username")String username){
        return (User) usersRepo.findUsersByUsername(username);
    }
    
    
    
    @RequestMapping(value="/login" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)//requestparam gia form data.
    public ResponseEntity<MessagesResponse> loginUserSimple(@RequestParam (value ="username") String username,
    		@RequestParam (value="password")String password){
        return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleLogin(username, password));
    }
    

    
    @RequestMapping(value = "/register" , method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagesResponse> registerUser( User user){
    	return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleRegister(user));
    }
    
    // testing @Valid 
//    @RequestMapping(value = "/register2" , method = RequestMethod.POST)
//    public String registerUserb(@Valid User user, BindingResult result,
//            ModelMap model){
//    	usersRepo.save(user);
//    	 
//        model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " registered successfully");
//        //model.addAttribute("loggedinuser", getPrincipal());
//		return null;
//    }
    

    
    @RequestMapping(value = "/update/{username}",method = RequestMethod.GET)    
    public ResponseEntity<MessagesResponse> updateUser(User user){
    	return ResponseEntity.status(HttpStatus.OK).body(userService.handleUpdateUser(user));
    }
    
    @RequestMapping(value = "/deleteUSER/{username}",method = RequestMethod.POST)    
    public ResponseEntity<MessagesResponse> deleteUser(User user){
    	return ResponseEntity.status(HttpStatus.OK).body(userService.handleDeleteUser(user));
    }
	

}

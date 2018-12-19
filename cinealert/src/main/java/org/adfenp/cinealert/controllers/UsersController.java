package org.adfenp.cinealert.controllers;

import java.util.List;


import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.model.User;
import org.adfenp.cinealert.services.LoginRegisterService;
import org.adfenp.cinealert.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    
    @RequestMapping(value = "/findUserByRole/{role}")
    public List<User> findByUsernameRole(@PathVariable("role")String role){
        return (List<User>) usersRepo.findUserByRole(role);
    }
    
    
    @RequestMapping(value="/login" , method = RequestMethod.POST)//requestparam gia form data.
    public ResponseEntity<MessagesResponse> loginUserSimple(@RequestParam (value ="username") String username,
    		@RequestParam (value="password")String password){
        return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleLogin(username, password));
    }
    
//    @GetMapping(path="/login/{username}/{password}")
//    public ResponseEntity<MessagesResponse> loginUserSimple(@PathVariable String username, @PathVariable String password){
//        return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleLogin(username, password));
//    }

    
//    @RequestMapping(value = "/register" , method = RequestMethod.POST)
//    public ResponseEntity<MessagesResponse> registerUser( User user){
//    	return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleRegister(user));
//    }
    
    
    @GetMapping(path = "/register" )
    public ResponseEntity<MessagesResponse> registerUser(@RequestParam (value = "username") String username , @RequestParam (value = "firstName") String firstName ,
    		@RequestParam (value = "lastName") String lastName,@RequestParam (value = "email") String email , @RequestParam (value = "password") String password ){
    	return ResponseEntity.status(HttpStatus.OK).body(loginRegisterService.handleRegister(username, firstName, lastName, password, email));
    }
    
    @RequestMapping(value = "/update/{username}",method = RequestMethod.GET)    
    public ResponseEntity<MessagesResponse> updateUser(User user){
    	return ResponseEntity.status(HttpStatus.OK).body(userService.handleUpdateUser(user));
    }
    
    @RequestMapping(value = "/deleteUSER/{username}",method = RequestMethod.POST)    
    public ResponseEntity<MessagesResponse> deleteUser(User user){
    	return ResponseEntity.status(HttpStatus.OK).body(userService.handleDeleteUser(user));
    }
	

}

package org.adfenp.cinealert.controllers;

import java.util.List;


import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.LoginResponse;
import org.adfenp.cinealert.model.User;
import org.adfenp.cinealert.services.LoginService;
import org.adfenp.cinealert.services.RegisterService;
import org.adfenp.cinealert.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsersController {
	
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
    private LoginService loginService;
	
	@Autowired
	private RegisterService registerService;
	

    @GetMapping(path = "/getUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(usersRepo.findAll());
    }
    
    @RequestMapping(value = "findUserMsgs/{username}")
    public User findByUsername(@PathVariable("username")String username){
        return (User) usersRepo.findUsersByUsername(username);
    }
    
    
    @GetMapping(path="/login/{username}/{password}")
    public ResponseEntity<LoginResponse> loginUserSimple(@PathVariable String username, @PathVariable String password){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.handleLogin(username, password));
    }
    
    @RequestMapping(value = "register",method = RequestMethod.POST)
    public ResponseEntity<LoginResponse> createUser(User user){
    	return ResponseEntity.status(HttpStatus.OK).body(registerService.handleRegister(user));
    }
	

}

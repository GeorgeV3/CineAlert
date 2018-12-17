package org.adfenp.cinealert.controllers;

import org.adfenp.cinealert.dao.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	
	@Autowired
	MessageRepo messageRepo;
	
	

}

package org.adfenp.cinealert.controllers;

import java.util.List;

import org.adfenp.cinealert.dao.MessageRepo;
import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.Message;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.model.User;
import org.adfenp.cinealert.services.Init;
import org.adfenp.cinealert.services.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	private static final Logger log = LoggerFactory.getLogger(Init.class); 

	@Autowired
	MessageRepo messageRepo;
	@Autowired
	MessageService messageService;

	@Autowired
	UsersRepo userRepo;


	@RequestMapping(value = "/findReceivedMSGs/{receiver}")
	public List<Message> findByUsernameRole(@PathVariable("receiver")Long receiver){
		return (List<Message>) messageRepo.findMessageByReceiver(receiver);
	}


	@GetMapping(value = "/findSendMSGs/{sender}")
	public ResponseEntity<List<Message>> findSendMSGs(@PathVariable("sender")String sender){
		//Play with ResponseEntity etc...
		HttpHeaders headers = new HttpHeaders();
		headers.add("NO MESSAGES", "You do not have send messages");
		List<Message> checkMsg=null;
		checkMsg=	messageRepo.findMessageBySender(sender);
		log.info("See pass.."  + checkMsg.size() +"keno");
		if (checkMsg.size() == 0) {
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(checkMsg);
	}

	@RequestMapping(value = "/sendMSG",method = RequestMethod.POST)
	public ResponseEntity<MessagesResponse> sendMessage(@RequestParam("username") String username,Message message){	
		return ResponseEntity.status(HttpStatus.OK).body(messageService.handleSendMessage(username , message));

	}
	
	@RequestMapping(value = "/deleteMSG/{messageID}",method = RequestMethod.POST)    
    public ResponseEntity<MessagesResponse> deleteMessage(Message message){
    	return ResponseEntity.status(HttpStatus.OK).body(messageService.handleDeleteMSG(message));
    }
	





}

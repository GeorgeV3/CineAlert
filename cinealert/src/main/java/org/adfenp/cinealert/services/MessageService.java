package org.adfenp.cinealert.services;

import java.util.List;

import org.adfenp.cinealert.dao.MessageRepo;
import org.adfenp.cinealert.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
	
	
	
//	public List<Message> findMessageByUsersUsername(String username){
//		return (List<Message>) messageRepo.findAllMessageBySender(username);
//	}

}

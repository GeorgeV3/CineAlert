package org.afdemp.cinealert.services;


import java.util.Date;

import org.afdemp.cinealert.dao.MessageRepo;
import org.afdemp.cinealert.dao.UsersRepo;
import org.afdemp.cinealert.model.Message;
import org.afdemp.cinealert.model.MessagesResponse;
import org.afdemp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

	@Autowired
	private MessageRepo messageRepo;
	
	@Autowired
	private UsersRepo usersRepo;



	
	public MessagesResponse handleSendMessage(String username ,Message message) {
		User user = usersRepo.findUsersByUsername(username);
		
		Message newMessage= new Message();
		//you need check for null and empty data for each field.
		//No time to find the best solution.We let the front handle it for the moment
		if( user != null ) {
		newMessage.setDate(new Date());
		newMessage.setStatus("UNREAD");
		newMessage.setReceiver(user);
		newMessage.setMsgDeleteStatus("non-deleted");
		newMessage.setSender(message.getSender());
		newMessage.setTitle(message.getTitle());
		newMessage.setText(message.getText());
		messageRepo.save(newMessage);
		MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "Message send."
				,String.valueOf(newMessage.getMessageID()));
		return  registerResponce;
		}
		return new MessagesResponse("FAILED", "Your message did not send. No user with that username exist." );
	}
	
	public MessagesResponse handleDeleteMSG(Message message) {
		Message messageCheck=messageRepo.findMessageByMessageID(message.getMessageID());
		if (!messageCheck.equals(null)) {
			messageCheck.setMsgDeleteStatus("DELETED");
			messageRepo.save(messageCheck);
			MessagesResponse deleteResponce= new MessagesResponse("SUCCESS", "Message deleted",String.valueOf(messageCheck.getMsgDeleteStatus()));
		 return deleteResponce;
		}
		return new MessagesResponse("FAILED", "Message do not delete something went wrong");
	}
	
	
	public MessagesResponse handleChangeStatusMSG(Message message) {
		Message messageCheck=messageRepo.findMessageByMessageID(message.getMessageID());
		if (!messageCheck.equals(null)) {
			messageCheck.setMsgDeleteStatus("READ");
			messageRepo.save(messageCheck);
			MessagesResponse deleteResponce= new MessagesResponse("SUCCESS", "Message change to Read",String.valueOf(messageCheck.getStatus()));
		 return deleteResponce;
		}
		return new MessagesResponse("FAILED", "Message do not change status, something went wrong");
	}





}

package org.adfenp.cinealert.services;


import java.util.Date;

import org.adfenp.cinealert.dao.MessageRepo;
import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.Message;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.model.User;
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
		if(user!=null) {
		newMessage.setDate(new Date());
		newMessage.setStatus("unread");
		newMessage.setReceiver(user);
		newMessage.setSender(message.getSender());
		newMessage.setTitle(message.getText());
		newMessage.setText(message.getText());
		messageRepo.save(newMessage);
		MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "User registration complete."
				,String.valueOf(newMessage.getMessageID()));
		return  registerResponce;
		}
		return new MessagesResponse("MESSAGE FAIL TO SEND", "You must login for send message" );
	}
	
	public MessagesResponse handleDeleteMSG(Message message) {
		Message messageCheck=messageRepo.findMessageByMessageID(message.getMessageID());
		if (messageCheck!=null) {
			messageCheck.setMsgDeleteStatus("DELETED");
			messageRepo.save(messageCheck);
			MessagesResponse deleteResponce= new MessagesResponse("SUCCESS", "Message deleted",String.valueOf(messageCheck.getMsgDeleteStatus()));
		 return deleteResponce;
		}
		return new MessagesResponse("FAIL", "Message do not delete something went wrong");
	}





}

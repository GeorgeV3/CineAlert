package org.adfenp.cinealert.services;

import java.util.Date;

import org.adfenp.cinealert.dao.MessageRepo;
import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.Message;
import org.adfenp.cinealert.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Init implements ApplicationListener<ApplicationReadyEvent> {
	
	private static final Logger log = LoggerFactory.getLogger(Init.class); 
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private MessageRepo messageRepo;

	@Override
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("Starting Model Testing ...");
		log.info("Deleting current user table...");
		messageRepo.deleteAll();
		usersRepo.deleteAll();
		log.info("Creating new user..");
		User users11 = new User();
		users11.setEmail("ferfr@");
		users11.setLastName("verri");
		users11.setFirstName("george");
		users11.setPassword("ede");
		users11.setRole("admin");
		users11.setStatus("active");
		users11.setUsername("skadi555");
		usersRepo.save(users11);
		
		User users22 = new User();
		users22.setEmail("ferfr@frfr");
		users22.setLastName("verri");
		users22.setFirstName("george");
		users22.setPassword("ede");
		users22.setRole("admin");
		users22.setStatus("active");
		users22.setUsername("skadi2");
		usersRepo.save(users22);
		
		User users33 = new User();
		users33.setEmail("ferfr@yahoo.gr");
		users33.setLastName("gianoulis");
		users33.setFirstName("panos");
		users33.setPassword("1234");
		users33.setUsername("skadi3");
		usersRepo.save(users33);
		
		Message message = new Message();
		message.setDate(new Date());
		message.setReceiver(users22);
		message.setText("gia stilame ena msg");
		message.setTitle("Hello word");
		message.setSender(users11.getUsername());
		messageRepo.save(message);
		
		Message message2 = new Message();
		//message2.setDate(new Date());
		message2.setReceiver(users22);
		message2.setText("gia stilame ena msg");
		message2.setTitle("Hello word");
		message2.setMsgDeleteStatus("deleted");
		message2.setStatus("read");
		message2.setSender(users11.getUsername());
		messageRepo.save(message2);
		
		
		
		log.info("Message TABLE : {}", messageRepo.findAll());
		
		log.info("USERS TABLE : {}", usersRepo.findAll());		
	}
	

}

package org.adfenp.cinealert;
import java.util.Date;

import org.afdemp.cinealert.dao.MessageRepo;
import org.afdemp.cinealert.dao.UsersRepo;
import org.afdemp.cinealert.model.Message;
import org.afdemp.cinealert.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;




@RunWith(SpringRunner.class)
@SpringBootTest
public class CinealertApplicationTests {
	
	private static final Logger log = LoggerFactory.getLogger(CinealertApplicationTests.class); 
	
	@Autowired
	private UsersRepo usersRepo;
	
	@Autowired
	private MessageRepo messageRepo;
	

	@Test
	public void contextLoads() {
	}
	
	@Test
	@Transactional
	public void modelTest() {
//		log.info("Starting Model Testing ...");
//		log.info("Deleting current user table...");
//		usersRepo.deleteAll();
//		log.info("Creating new user..");
//		Users users1 = new Users();
//		users1.setEmail("ferfr");
//		users1.setLastName("verri");
//		users1.setFirstName("george");
//		users1.setPassword("ede");
//		users1.setRole("admin");
//		users1.setStatus(0);
//		users1.setUsername("skadi");
//		usersRepo.save(users1);
//		
//		Users users2 = new Users();
//		users2.setEmail("ferfr");
//		users2.setLastName("verri");
//		users2.setFirstName("george");
//		users2.setPassword("ede");
//		users2.setRole("admin");
//		users2.setStatus(0);
//		users2.setUsername("skadi2");
//		usersRepo.save(users2);
//		
//		Message message = new Message();
//		message.setDate(new Date());
//		message.setStatus("unread");
//		message.setMsgDeleteStatus("nonDeleted");
//		message.setReceiver(users2);
//		message.setText("gia stilame ena msg");
//		message.setTitle("Hello word");
//		message.setSender(users1);
//		messageRepo.save(message);
//		
//		log.info("Message TABLE : {}", messageRepo.findAll());
//		
//		log.info("USERS TABLE : {}", usersRepo.findAll());
		
		
	}
	
	

}


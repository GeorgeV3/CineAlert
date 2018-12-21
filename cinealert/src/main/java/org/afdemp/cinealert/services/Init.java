package org.afdemp.cinealert.services;

import java.util.ArrayList;


import org.afdemp.cinealert.dao.ActorsRepo;
import org.afdemp.cinealert.dao.ArticleRepo;
import org.afdemp.cinealert.dao.FilmActorRepo;
import org.afdemp.cinealert.dao.FilmRepo;
import org.afdemp.cinealert.dao.MessageRepo;
import org.afdemp.cinealert.dao.UsersRepo;
import org.afdemp.cinealert.model.Actor;
import org.afdemp.cinealert.model.Article;
import org.afdemp.cinealert.model.Film;
import org.afdemp.cinealert.model.FilmActor;
import org.afdemp.cinealert.model.Message;
import org.afdemp.cinealert.model.User;
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
	
	@Autowired
	private FilmRepo filmRepo;
	
	@Autowired
	private ActorsRepo actorsRepo;
	
	@Autowired
	private ArticleRepo articleRepo;
	
	@Autowired
	private FilmActorRepo filmActorREpo;
	
	
	
	

	@Override
	@Transactional
	public void onApplicationEvent(ApplicationReadyEvent event) {
		log.info("Starting Model Testing ...");
		log.info("Deleting current user table...");
		messageRepo.deleteAll();
		usersRepo.deleteAll();
		filmRepo.deleteAll();
		actorsRepo.deleteAll();
		articleRepo.deleteAll();
		filmActorREpo.deleteAll();
		log.info("Creating new user..");
		User users11 = new User();
		users11.setEmail("ferfr@yahoo.gr");
		users11.setLastName("giannis");
		users11.setFirstName("panoulis");
		users11.setPassword("123456");
		users11.setRole("critic");
		users11.setStatus("active");
		users11.setUsername("critic");
		usersRepo.save(users11);
		
		User users22 = new User();
		users22.setEmail("ferfr@hotmal.com");
		users22.setLastName("verri");
		users22.setFirstName("george");
		users22.setPassword("GOD");
		users22.setRole("admin");
		users22.setStatus("active");
		users22.setUsername("GOD");
		usersRepo.save(users22);
		
		User users33 = new User();
		users33.setEmail("ferfr@yahoo.gr");
		users33.setLastName("gianoulis");
		users33.setFirstName("panos");
		users33.setPassword("123456");
		users33.setUsername("skadi");
		usersRepo.save(users33);
		
		Message message = new Message();
		message.setReceiver(users22);
		message.setMsgDeleteStatus("non-deleted");
		message.setText("gia stilame ena msg");
		message.setTitle("Hello word");
		message.setSender(users11.getUsername());
		messageRepo.save(message);
		
		Message message2 = new Message();
		message2.setReceiver(users22);
		message2.setText("gia stilame ena msg");
		message2.setTitle("Hello word");
		message2.setMsgDeleteStatus("deleted");
		message2.setStatus("READ");
		message2.setSender(users11.getUsername());
		messageRepo.save(message2);
	//////////////////////////////////////////////////////
		///////////////////////////////////////////
		/////////////////////////////////////////////
		ArrayList<Actor> actorss= new ArrayList<>();
		ArrayList<Film> films= new ArrayList<>();
	
		Actor actor = new Actor();
		actor.setLastName("Karasavaw33");
		actor.setFirstName("George33");
		
			
		Actor actor2= new Actor();
		actor2.setLastName("Karasavaw");
		actor2.setFirstName("George");
		
		
		actorss.add(actor);
		actorss.add(actor2);
		
		
		
		Film film= new Film();
		
		Article article=new Article();
		article.setFilm(film);
		article.setText("i kaliteri tenia olown ton epoxwn");
		article.setUser(users33);
		articleRepo.save(article);
		
		Article article2=new Article();
		article2.setFilm(film);
		article2.setText("i kaliteri tenia olown ton epoxwn3332e222222222222222222eeeeeeeeeeeeeeeeeeeeeeeeeeeee2e@@@@");
		article2.setUser(users33);
		articleRepo.save(article2);
		
		
		
		
		film.setTitle("Hellboy");
		film.setDescription("Based on the graphic novels by Mike Mignola, Hellboy, caught between the worlds of the supernatural and human, battles an ancient sorceress bent on revenge. ");
		film.setLength(120);
		film.setReleaseYr(2019-02-11);
		film.setGenre("Action, Adventure, Fantasy ");
		films.add(film);
		
		filmRepo.save(film);
		
		actorsRepo.saveAll(actorss);
		Film film2= new Film();
		film2.setTitle("Το τεμπελόσκυλο");
		film2.setDescription("Ο Πολύδωρος (Δημήτρης Παπαμιχαήλ) είναι ένας επαγγελματίας τεμπέλης, ο οποίος ξαφνικά αρχίζει να εργάζεται ως εισπράκτορας χρεών, για λογαριασμό της εταιρείας στην οποία εργάζεται και ο αδερφός του (Νίκος Βασταρδής).");
		film2.setLength(87);
		film2.setReleaseYr(1963-02-11);
		film2.setGenre("Thriller-Romance-Sex&Drungs");
		filmRepo.save(film2);
		
		Film film3= new Film();
		film3.setTitle("Aquaman");
		film3.setDescription("Arthur Curry learns that he is the heir to the underwater kingdom of Atlantis, and must step forward to lead his people and be a hero to the world. ");
		film3.setLength(120);
		film3.setReleaseYr(2018-02-11);
		film3.setGenre("Action-Adventure-Fantasy-Sci-Fi");
		
		filmRepo.save(film3);
		
		Film film4= new Film();
		film4.setTitle("Mary Poppins Returns");
		film4.setDescription("Decades after her original visit, the magical nanny returns to help the Banks siblings and Michael's children through a difficult time in their lives. ");
		film4.setLength(120);
		film4.setReleaseYr(2002-02-11);
		film4.setGenre("Comedy-Family-Fantasy-Musical");
		filmRepo.save(film4);
		
		Film film5= new Film();
		film5.setTitle("Bumblebee");
		film5.setDescription("On the run in the year of 1987, Bumblebee finds refuge in a junkyard in a small Californian beach town. Charlie, on the cusp of turning 18 and trying to find her place in the world, discovers Bumblebee, battle-scarred and broken. ");
		film5.setLength(120);
		film5.setReleaseYr(2002-02-11);
		film5.setGenre("Action-Adventure-Sci-Fi");
		filmRepo.save(film5);
		
		
		
		FilmActor filmActor= new FilmActor();
		filmActor.setActor(actor2);
		filmActor.setFilm(film5);
		
		FilmActor filmActor2= new FilmActor();
		filmActor2.setActor(actor2);
		filmActor2.setFilm(film3);
		
		filmActorREpo.save(filmActor);
		filmActorREpo.save(filmActor2);
				
		
		
		
		log.info("Message TABLE : {}", messageRepo.findAll());
		
		log.info("USERS TABLE : {}", usersRepo.findAll());		
	}
	

}

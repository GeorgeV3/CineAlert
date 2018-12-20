package org.afdemp.cinealert.services;

import org.afdemp.cinealert.dao.FilmRepo;
import org.afdemp.cinealert.dao.RateFilmRepo;
import org.afdemp.cinealert.dao.UsersRepo;
import org.afdemp.cinealert.model.Film;
import org.afdemp.cinealert.model.MessagesResponse;
import org.afdemp.cinealert.model.RateFilm;
import org.afdemp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateFilmsService {
	//private static final Logger log = LoggerFactory.getLogger(Init.class); 
	@Autowired
	private RateFilmRepo rateFilmRepo;
	
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private FilmRepo filmRepo;
	
	
	//need alot work for the correct logic so a user can rate only one time...no time to implement with better way.
	public MessagesResponse handleRateFilm(String username,Long filmID, RateFilm rateFilm) {
		User user = usersRepo.findUsersByUsername(username);
		Film film = filmRepo.findByFilmID(filmID);
		RateFilm newRateFilm  = new RateFilm();
	
		if (user != null && film !=null ) {
			newRateFilm.setUser(user);
			newRateFilm.setFilm(film);
			newRateFilm.setStars(rateFilm.getStars());
			rateFilmRepo.save(newRateFilm);
			MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "You rate the film successfuly"
					,String.valueOf(film.getTitle()));
			return  registerResponce;

		}
		return new MessagesResponse("FAILED", "You must login for rate a movie" );
	}
	
	public MessagesResponse handleUpdateRateFilm(RateFilm rateFilm) {
		RateFilm checkRateFilm = rateFilmRepo.findRateFilmByRateID(rateFilm.getRateID());
			checkRateFilm.setStars(rateFilm.getStars());
			rateFilmRepo.save(checkRateFilm);
			MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "You change the rating of the film"
					,String.valueOf(checkRateFilm.getStars()));
			return  registerResponce;
		
	}


}

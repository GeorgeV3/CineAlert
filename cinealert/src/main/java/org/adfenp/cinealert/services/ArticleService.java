package org.adfenp.cinealert.services;

import java.util.Optional;

import org.adfenp.cinealert.dao.ArticleRepo;
import org.adfenp.cinealert.dao.FilmRepo;
import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.Article;
import org.adfenp.cinealert.model.Film;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	@Autowired
	private ArticleRepo articleRepo;
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private FilmRepo filmRepo;

	public MessagesResponse handleCreateArticle(String username,Long filmID, Article article) {
		User user = usersRepo.findUsersByUsername(username);
		
		Film film = filmRepo.findByFilmID(filmID);
		Article newArticle= new Article();
		if (user !=null && newArticle!=null) {
			newArticle.setUser(user);
			newArticle.setFilm(film);
			newArticle.setText(article.getText());
			articleRepo.save(newArticle);
			MessagesResponse registerResponce= new MessagesResponse("SUCCESS", "New Article Create."
					,String.valueOf(newArticle.getArticle_ID()));
			return  registerResponce;

		}
		return new MessagesResponse("MESSAGE FAIL TO SEND", "You must login for send message" );
	}


}

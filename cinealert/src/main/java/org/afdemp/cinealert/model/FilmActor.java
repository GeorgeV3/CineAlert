package org.afdemp.cinealert.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="film_actors")
public class FilmActor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO, 
		    generator="native"
		)
		@GenericGenerator(
		    name = "native", 
		    strategy = "native"
		)
	@Column(name="film_actor_ID")
	private Long filmActorID;

	@ManyToOne
	@JoinColumn(name="flmID")
	@JsonBackReference(value="film")
	private Film film;

	@ManyToOne
	@JoinColumn(name="actorID")
	@JsonBackReference(value="actor")
	private Actor actor;

	public FilmActor() {
	}



	public Long getFilmActorID() {
		return filmActorID;
	}



	public void setFilmActorID(Long filmActorID) {
		this.filmActorID = filmActorID;
	}



	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Actor getActor() {
		return this.actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

}
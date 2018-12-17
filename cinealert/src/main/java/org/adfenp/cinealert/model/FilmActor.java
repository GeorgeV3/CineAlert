package org.adfenp.cinealert.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;



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
	private Long film_actor_ID;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="flmID")
	private Film film;

	//bi-directional many-to-one association to Actor
	@ManyToOne
	@JoinColumn(name="actorID")
	private Actor actor;

	public FilmActor() {
	}

	public Long getFilm_actor_ID() {
		return this.film_actor_ID;
	}

	public void setFilm_actor_ID(Long film_actor_ID) {
		this.film_actor_ID = film_actor_ID;
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
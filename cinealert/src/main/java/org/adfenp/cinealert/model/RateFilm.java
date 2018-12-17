package org.adfenp.cinealert.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="rate_films")
public class RateFilm implements Serializable {
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
	private Long rate_ID;

	private int stars;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="usrID")
	@JsonBackReference
	private User user;

	//bi-directional many-to-one association to Film
	@ManyToOne
	@JoinColumn(name="flmID")
	@JsonBackReference
	private Film film;

	public RateFilm() {
	}

	public Long getRate_ID() {
		return this.rate_ID;
	}

	public void setRate_ID(Long rate_ID) {
		this.rate_ID = rate_ID;
	}

	public int getStars() {
		return this.stars;
	}

	public void setStars(int stars) {
		this.stars = stars;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Film getFilm() {
		return this.film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

}
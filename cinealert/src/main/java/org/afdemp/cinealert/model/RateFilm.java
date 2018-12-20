package org.afdemp.cinealert.model;

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
	@Column(name="rate_ID" , nullable=false)
	private Long rateID;

	private int stars;

	@ManyToOne
	@JoinColumn(name="usrID" , nullable=false)
	@JsonBackReference(value="user")

	private User user;

	@ManyToOne
	@JoinColumn(name="flmID" , nullable=false)
	@JsonBackReference(value="film")

	private Film film;

	public RateFilm() {
	}



	public Long getRateID() {
		return rateID;
	}



	public void setRateID(Long rateID) {
		this.rateID = rateID;
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
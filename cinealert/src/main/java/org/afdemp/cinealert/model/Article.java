package org.afdemp.cinealert.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="articles")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO, 
		    generator="native"
		)//for dont create the extra hibernate table for auto increments in db
		@GenericGenerator(
		    name = "native", 
		    strategy = "native"
		)
	private Long article_ID;

	@Lob
	@Column( nullable=false)
	private String text;

	@ManyToOne
	@JoinColumn(name="usr_ID")
	@JsonBackReference(value="user")
	private User user;

	@ManyToOne
	@JoinColumn(name="flm_ID")
	@JsonBackReference(value="film")
	private Film film;

	public Article() {
	}

	public Long getArticle_ID() {
		return this.article_ID;
	}

	public void setArticle_ID(Long article_ID) {
		this.article_ID = article_ID;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
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
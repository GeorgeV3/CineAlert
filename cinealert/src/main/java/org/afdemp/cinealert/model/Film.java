package org.afdemp.cinealert.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;



@Entity
@Table(name="films")
public class Film implements Serializable {
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
	@Column(name="film_id")
	private Long filmID;
	
	@Lob
	@Column(nullable=false )
	private String description;
	
	@Column(nullable=false )
	private String genre;
	
	@Column(nullable=false )
	private int length;

	@Column(name="release_yr" , nullable=false)
	private int releaseYr;
	
	@Column(nullable=false )
	private String title;

	@OneToMany(mappedBy="film")
	@JsonManagedReference
	private List<Article> articles;

	@OneToMany(mappedBy="film")
	@JsonManagedReference
	private List<FilmActor> filmActors;

	@OneToMany(mappedBy="film")
	@JsonManagedReference
	private List<RateFilm> rateFilms;

	public Film() {
	}



	public Long getFilmID() {
		return filmID;
	}



	public void setFilmID(Long filmID) {
		this.filmID = filmID;
	}



	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getReleaseYr() {
		return this.releaseYr;
	}

	public void setReleaseYr(int releaseYr) {
		this.releaseYr = releaseYr;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setFilm(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setFilm(null);

		return article;
	}

	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setFilm(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setFilm(null);

		return filmActor;
	}

	public List<RateFilm> getRateFilms() {
		return this.rateFilms;
	}

	public void setRateFilms(List<RateFilm> rateFilms) {
		this.rateFilms = rateFilms;
	}

	public RateFilm addRateFilm(RateFilm rateFilm) {
		getRateFilms().add(rateFilm);
		rateFilm.setFilm(this);

		return rateFilm;
	}

	public RateFilm removeRateFilm(RateFilm rateFilm) {
		getRateFilms().remove(rateFilm);
		rateFilm.setFilm(null);

		return rateFilm;
	}

}
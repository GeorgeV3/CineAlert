package org.afdemp.cinealert.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;



@Entity
@Table(name="actors")
public class Actor implements Serializable {
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
	@Column(name= "actor_id")
	private Long actorID;
	
	@Column( nullable=false , length=25)
	private String firstName;
	
	@Column( nullable=false , length=25)
	private String lastName;

	@OneToMany(mappedBy="actor")
	@JsonManagedReference
	private List<FilmActor> filmActors;

	public Actor() {
	}




	public Long getActorID() {
		return actorID;
	}




	public void setActorID(Long actorID) {
		this.actorID = actorID;
	}




	public String getFirstName() {
		return firstName;
	}




	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}




	public String getLastName() {
		return lastName;
	}




	public void setLastName(String lastName) {
		this.lastName = lastName;
	}




	public List<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(List<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}

	public FilmActor addFilmActor(FilmActor filmActor) {
		getFilmActors().add(filmActor);
		filmActor.setActor(this);

		return filmActor;
	}

	public FilmActor removeFilmActor(FilmActor filmActor) {
		getFilmActors().remove(filmActor);
		filmActor.setActor(null);

		return filmActor;
	}

}
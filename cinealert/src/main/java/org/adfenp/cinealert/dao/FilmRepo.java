package org.adfenp.cinealert.dao;

import java.util.List;

import org.adfenp.cinealert.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepo extends JpaRepository<Film , Long>{
	List<Film> findAll();
	
	Film findByFilmID(Long filmID);
}

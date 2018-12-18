package org.adfenp.cinealert.controllers;

import java.util.List;

import org.adfenp.cinealert.dao.FilmRepo;
import org.adfenp.cinealert.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmsController {
	
	@Autowired
	private FilmRepo filmRepo;
	
	@GetMapping(path = "/getAllFilms")
    public ResponseEntity<List<Film>> getAllFilms(){
        return ResponseEntity.status(HttpStatus.OK).body(filmRepo.findAll());
    }

}

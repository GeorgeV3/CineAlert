package org.afdemp.cinealert.controllers;

import org.afdemp.cinealert.model.MessagesResponse;
import org.afdemp.cinealert.model.RateFilm;
import org.afdemp.cinealert.services.RateFilmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateFilmControler {
	
	@Autowired
	private RateFilmsService rateFilmsService;
	
	@RequestMapping(value = "/rateMovie",method = RequestMethod.POST)
    public ResponseEntity<MessagesResponse> writeArticle(String username , Long filmID ,RateFilm rateFilm){
    	return ResponseEntity.status(HttpStatus.OK).body(rateFilmsService.handleRateFilm(username, filmID, rateFilm));
    }
	
	@RequestMapping(value = "/updateRateMovie/{rateID}",method = RequestMethod.POST)
    public ResponseEntity<MessagesResponse> updateRateOfMovie(RateFilm rateFilm){
    	return ResponseEntity.status(HttpStatus.OK).body(rateFilmsService.handleUpdateRateFilm(rateFilm));
    }
}

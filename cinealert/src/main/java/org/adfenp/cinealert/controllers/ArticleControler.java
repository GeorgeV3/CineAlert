package org.adfenp.cinealert.controllers;

import org.adfenp.cinealert.model.Article;
import org.adfenp.cinealert.model.MessagesResponse;
import org.adfenp.cinealert.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleControler {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "/writeArticle",method = RequestMethod.POST)
    public ResponseEntity<MessagesResponse> writeArticle(String username , Long filmID ,Article article){
    	return ResponseEntity.status(HttpStatus.OK).body(articleService.handleCreateArticle(username, filmID, article));
    }
	

}

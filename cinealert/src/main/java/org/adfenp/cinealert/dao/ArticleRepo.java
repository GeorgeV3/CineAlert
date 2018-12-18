package org.adfenp.cinealert.dao;

import org.adfenp.cinealert.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Article, Long>{
	
	

}

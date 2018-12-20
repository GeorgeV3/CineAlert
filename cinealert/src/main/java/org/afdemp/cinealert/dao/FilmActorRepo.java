package org.afdemp.cinealert.dao;

import org.afdemp.cinealert.model.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepo  extends JpaRepository<FilmActor, Long>{

}

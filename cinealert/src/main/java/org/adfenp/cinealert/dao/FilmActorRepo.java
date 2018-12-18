package org.adfenp.cinealert.dao;

import org.adfenp.cinealert.model.FilmActor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmActorRepo  extends JpaRepository<FilmActor, Long>{

}

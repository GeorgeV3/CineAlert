package org.adfenp.cinealert.dao;

import org.adfenp.cinealert.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepo extends JpaRepository<Actor, Long>{

}

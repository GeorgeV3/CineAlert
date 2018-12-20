package org.afdemp.cinealert.dao;

import org.afdemp.cinealert.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepo extends JpaRepository<Actor, Long>{

}

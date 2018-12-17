package org.adfenp.cinealert.dao;

import org.adfenp.cinealert.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository 
public interface UsersRepo extends JpaRepository<User, Long>{
	
	User findUsersByUsername(String username);
	User findUserByusernameAndPassword(String username, String password);
	

}

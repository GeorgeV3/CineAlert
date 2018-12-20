package org.afdemp.cinealert.dao;

import java.util.List;

import org.afdemp.cinealert.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository 
public interface UsersRepo extends JpaRepository<User, Long>{
	
	User findUsersByUsername(String username2);
	User findUserByusernameAndPassword(String username, String password);
	
	@Query(value="SELECT * FROM cinealerta.users  where role= ?1" , nativeQuery = true)
	List<User> findUserByRole(String role);
	
	

}

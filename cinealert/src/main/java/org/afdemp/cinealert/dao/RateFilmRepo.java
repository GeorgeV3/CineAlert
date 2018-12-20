package org.afdemp.cinealert.dao;



import org.afdemp.cinealert.model.RateFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RateFilmRepo extends JpaRepository<RateFilm, Long>{
	
	//RateFilm findByFilmAndUser(Film film,User user);
	
	
	@Query(value="SELECT * FROM cinealerta.rate_films where flmid= ?1 and usrid=(select username from users where username= ?1 )" , nativeQuery = true)
	RateFilm findRateByFlmIdANDuserID(Long filmID,String username);
	
	RateFilm findRateFilmByRateID(Long rateID);

}

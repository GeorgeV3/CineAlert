package org.adfenp.cinealert.services;

import org.adfenp.cinealert.dao.UsersRepo;
import org.adfenp.cinealert.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	private UsersRepo usersRepo;
	
    public User save(User user) {
        return usersRepo.save(user);
    }
}

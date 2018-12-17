package org.adfenp.cinealert.dao;

import org.adfenp.cinealert.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {
	Message findAllMessageBysender(long user_ID);
	


}

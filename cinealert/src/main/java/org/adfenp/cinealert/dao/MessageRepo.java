package org.adfenp.cinealert.dao;

import org.adfenp.cinealert.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;



public interface MessageRepo extends JpaRepository<Message, Long> {
	Message findAllMessageBySender(String username );


}

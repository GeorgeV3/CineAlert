package org.adfenp.cinealert.dao;

import java.util.List;

import org.adfenp.cinealert.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface MessageRepo extends JpaRepository<Message, Long> {


	@Query(value="SELECT * FROM cinealerta.messages  where receiver= ?1 and delete_status='non-deleted' " , nativeQuery = true)
	List<Message> findMessageByReceiver(Long receiver);
	@Query(value="SELECT * FROM cinealerta.messages  where sender= ?1 and delete_status='non-deleted' " , nativeQuery = true)
	List<Message> findMessageBySender(String sender);
	
	Message findMessageByMessageID(Long messageID);
	
	@Query(value="SELECT * FROM cinealerta.messages  where receiver= ?1 and delete_status='DELETED' " , nativeQuery = true)
	List<Message> findAllDeleteMSGs(Long receiver2);




}

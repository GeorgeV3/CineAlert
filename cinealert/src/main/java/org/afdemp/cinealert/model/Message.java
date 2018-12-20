package org.afdemp.cinealert.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;



@Entity
@Table(name="messages")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(
			strategy= GenerationType.AUTO, 
			generator="native"
			)
	@GenericGenerator(
			name = "native", 
			strategy = "native"
			)
	@Column(name="message_id")
	private Long messageID;


	@Column(name="date" , nullable = false, updatable = false)
	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = " 'at' HH:mm:ss z dd/MM/yyyy") 
	private Date date;
	
	

	@Column(name="delete_status")
	private String msgDeleteStatus;

	@Column(  length=25)
	private String status;

	@Lob
	@Column( nullable=false )
	private String text;
	@Column( nullable=false , length=50)
	private String title;

//	@ManyToOne
//	@JoinColumn(name="sender")
//	@JsonBackReference
	@Column( nullable=false , length=50)
	private String sender;


	@ManyToOne
	@JoinColumn(name="receiver")
	@JsonBackReference(value="receiver")
	private User receiver;


	

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public Message() {

		date=new Date();
		status="UNREAD";
		msgDeleteStatus="non-deleted";
	}




	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}





	public Long getMessageID() {
		return messageID;
	}

	public void setMessageID(Long messageID) {
		this.messageID = messageID;
	}

	public String getMsgDeleteStatus() {
		return msgDeleteStatus;
	}

	public void setMsgDeleteStatus(String msgDeleteStatus) {
		this.msgDeleteStatus = msgDeleteStatus;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Message [message_ID=" + messageID + ", date=" + date  + ", msgDeleteStatus="
				+ msgDeleteStatus + ", status=" + status + ", text=" + text + ", title=" + title + ", sender=" + sender
				+ ", receiver=" + receiver.getUserId()+ "]";
	}



}
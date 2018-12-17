package org.adfenp.cinealert.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private Long message_ID;

	
	@Column(name="date" , nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
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

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="sender")
	@JsonBackReference
	private User sender;
	
	
	@ManyToOne
	@JoinColumn(name="receiver")
	@JsonBackReference
	private User receiver;
	
	
	@Transient
	private String sendName;

	public String getSendName() {
		return sendName;
	}

	public void setSendName(String sendName) {
		Message message= new Message();	
		this.sendName = message.sender.getUsername();
	}

	public Message() {
		
		date=new Date();
		status="unread";
	}

	public Long getMessage_ID() {
		return this.message_ID;
	}

	public void setMessage_ID(Long message_ID) {
		this.message_ID = message_ID;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Message [message_ID=" + message_ID + ", date=" + date  + ", msgDeleteStatus="
				+ msgDeleteStatus + ", status=" + status + ", text=" + text + ", title=" + title + ", sender=" + sender.getUserId()
				+ ", receiver=" + receiver.getUserId()+ "]";
	}



}
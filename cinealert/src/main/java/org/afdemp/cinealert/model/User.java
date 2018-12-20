package org.afdemp.cinealert.model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;


@Entity
@Table(name="users")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Transient
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); 

	@Id
	@GeneratedValue(
		    strategy= GenerationType.AUTO, 
		    generator="native"
		)//for dont create the extra hibernate table for auto increments in db
		@GenericGenerator(
		    name = "native", 
		    strategy = "native"
		)
	@Column(name = "user_id")
	private Long userId;
	@Column( nullable=false , length=25)
	private String email;
	@Column( nullable=false , length=25)
	private String firstName;
	@Column( nullable=false , length=25)
	private String lastName;
	@Column( name="password" , nullable=false , length=250)
	private String password;
	

	
	
	@Column( nullable=false , length=25)
	private String role;
	@Column( nullable=false , length=25)
	private String status;
	@Column( unique= true, nullable=false , length=25)
	private String username;

	@OneToMany(mappedBy="user")
	@JsonManagedReference
	private List<Article> articles;

//	@OneToMany(mappedBy="sender")
//	@JsonManagedReference
//	private List<Message> sendMessages;
	
		@OneToMany(mappedBy="receiver")
		@JsonManagedReference
		private List<Message> receiveMessages;

	@OneToMany(mappedBy="user")
	@JsonManagedReference
	private List<RateFilm> rateFilms;

	public User() {
		role="FFN";
		status="ACTIVE";
	}



	public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return (this.password);
	}

	public void setPassword(String password) {
		this.password = passwordEncoder.encode(password);
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Article> getArticles() {
		return this.articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public Article addArticle(Article article) {
		getArticles().add(article);
		article.setUser(this);

		return article;
	}

	public Article removeArticle(Article article) {
		getArticles().remove(article);
		article.setUser(null);

		return article;
	}
	
//	public List<Message> getSendMessages() {
//		return sendMessages;
//	}
//
//	public void setSendMessages(List<Message> sendMessages) {
//		this.sendMessages = sendMessages;
//	}
//	
//	
//	public Message addSendMessage(Message sendMsg) {
//		getSendMessages().add(sendMsg);
//		sendMsg.setSender(null);
//	
//		return sendMsg;
//	}
//	
//	public Message removeSendMessage(Message sendMsg) {
//		getSendMessages().remove(sendMsg);
//		sendMsg.setSender(null);
//		
//		return sendMsg;
//	}

	public List<Message> getReceiveMessages() {
		return receiveMessages;
	}

	public void setReceiveMessages(List<Message> receiveMessages) {
		this.receiveMessages = receiveMessages;
	}
	
	
	public Message addReceiveMessage(Message receiveMsg) {
		getReceiveMessages().add(receiveMsg);
		receiveMsg.setReceiver(null);
		
		return receiveMsg;
	}
	
	public Message removeReceiveMessages(Message receiveMsg) {
		getReceiveMessages().remove(receiveMsg);
		receiveMsg.setReceiver(null);
		
		return receiveMsg;	
	}

	@Override
	public String toString() {
		return "User [user_ID=" + userId + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", password=" + password + ", role=" + role + ", status=" + status + ", username=" + username
				+  ", receiveMessages=" + receiveMessages + "]";
	}



	public List<RateFilm> getRateFilms() {
		return this.rateFilms;
	}

	public void setRateFilms(List<RateFilm> rateFilms) {
		this.rateFilms = rateFilms;
	}

	public RateFilm addRateFilm(RateFilm rateFilm) {
		getRateFilms().add(rateFilm);
		rateFilm.setUser(this);

		return rateFilm;
	}

	public RateFilm removeRateFilm(RateFilm rateFilm) {
		getRateFilms().remove(rateFilm);
		rateFilm.setUser(null);

		return rateFilm;
	}
	
	

}
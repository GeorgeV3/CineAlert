package org.afdemp.cinealert.model;

public class MessagesResponse {

    private String status;
    private String message;
    private String role;
    private String username;

    public MessagesResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public MessagesResponse(String status, String message, String role) {
        this.status = status;
        this.message = message;
        this.role = role;
    }

    
    public MessagesResponse(String status, String message, String role, String username) {
		super();
		this.status = status;
		this.message = message;
		this.role = role;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

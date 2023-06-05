package com.moviebookingapp.payload.response;


public class MessageResponse {
    private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "MessageResponse [message=" + message + "]";
	}

	public MessageResponse(String message) {
		super();
		this.message = message;
	}

	public MessageResponse() {
		super();

	}
    
}
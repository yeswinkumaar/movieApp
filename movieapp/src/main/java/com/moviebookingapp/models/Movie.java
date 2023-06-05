package com.moviebookingapp.models;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
public class Movie {
	
	private ObjectId _id;
	
	private String movieName;

	private String theatreName;
	private Integer noOfTicketsAvailable;

	private String ticketsStatus;

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public Integer getNoOfTicketsAvailable() {
		return noOfTicketsAvailable;
	}

	public void setNoOfTicketsAvailable(Integer noOfTicketsAvailable) {
		this.noOfTicketsAvailable = noOfTicketsAvailable;
	}

	public String getTicketsStatus() {
		return ticketsStatus;
	}

	public void setTicketsStatus(String ticketsStatus) {
		this.ticketsStatus = ticketsStatus;
	}

	public Movie(String movieName, String theatreName, Integer noOfTicketsAvailable, String ticketsStatus) {
		super();
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.noOfTicketsAvailable = noOfTicketsAvailable;
		this.ticketsStatus = ticketsStatus;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

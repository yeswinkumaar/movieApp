package com.moviebookingapp.security.services;

import com.moviebookingapp.models.Movie;
import com.moviebookingapp.models.Ticket;
import com.moviebookingapp.repository.MovieRepository;
import com.moviebookingapp.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private TicketRepository ticketRepository;

	public List<Movie> getAllMovies() {
		return movieRepository.findAll();
	}

	public List<Movie> findByMovieName(String movieName) {
		return movieRepository.findByMovieNameStartingWith(movieName);
	}

	public List<Ticket> findTickets(String movieName, String theatreName) {

		return ticketRepository.findByMovieNameAndTheatreName(movieName, theatreName);
	}

	public Movie findMovieByMovieNameAndTheatreName(String movieName, String theatreName) {

		return movieRepository.findByMovieNameAndTheatreName(movieName, theatreName);
	}

	public void saveTicket(Ticket ticket) {
		ticketRepository.save(ticket);
	}

	public void saveMovie(Movie movie) {
		movieRepository.save(movie);
	}

	public List<Ticket> getAllBookedTickets(String movieName) {
		return ticketRepository.findByMovieName(movieName);
	}

	public void deleteByMovieName(String movieName) {
		movieRepository.deleteByMovieName(movieName);
	}

}

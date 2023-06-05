package com.moviebookingapp.security.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import com.moviebookingapp.models.Movie;
import com.moviebookingapp.models.Ticket;
import com.moviebookingapp.repository.MovieRepository;
import com.moviebookingapp.repository.TicketRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.Silent.class)
class MovieServiceTest {

	@Mock
	private MovieRepository movieRepository;

	@Mock
	private TicketRepository ticketRepository;

	@InjectMocks
	private MovieService movieService;

	List<Movie> movies = new ArrayList<>();
	Movie movie1 = new Movie("Pushpa", "Theatre 1", 100, "Book ASAP");
	Movie movie2 = new Movie("KGF", "Theatre 2", 200, "Book ASAP");
	
	List<Ticket> tickets = new ArrayList<>();
	Ticket ticket=new Ticket("1000", "Pushpa", "Theatre 1", 3, List.of("A1","A2","A3"));
	

	// Set up mock data
	@BeforeEach
	void testData() {

		movies.add(movie1);
		movies.add(movie2);
		
		tickets.add(ticket);

	}

	@Test
    void getAllMoviesTest() {
       
        // Set up mock behavior
        when(movieRepository.findAll()).thenReturn(movies);

        // Call the method under test
        List<Movie> result = movieService.getAllMovies();

        // Assert the result
        assertEquals(movies, result);
    }
	@Test
	void findByMovieNameTest() {
		
		List<Movie> movieList=List.of(movie1);
		when(movieRepository.findByMovieNameStartingWith("KGF")).thenReturn(movieList);
		// Call the method being tested
		List<Movie> result = movieService.findByMovieName("KGF");

		// Assert the results
		assertEquals(movieList,result);
	}
	@Test
	void findTicketsTest() {
		// Set up mock data
		when(ticketRepository.findByMovieNameAndTheatreName("KGF", "Theatre 1")).thenReturn(tickets);

		// Call the method being tested
		List<Ticket> result = movieService.findTickets("KGF", "Theatre 1");

		// Assert the results
		assertEquals(tickets, result);
	}

	@Test
	void findMovieByMovieNameAndTheatreNameTest() {
		
		when(movieRepository.findByMovieNameAndTheatreName("KGF", "Theatre 1")).thenReturn(movie1);
		Movie actualMovie = movieService.findMovieByMovieNameAndTheatreName("KGF", "Theatre 1");
		assertEquals(actualMovie, movie1);
	}

	@Test
	void saveTicketTest() {
		
		movieService.saveTicket(ticket);
		verify(ticketRepository, times(1)).save(ticket);
	}

	@Test
	void saveMovieTest() {
	
		movieService.saveMovie(movie1);
		verify(movieRepository, times(1)).save(movie1);
	}

	@Test
	void getAllBookedTicketsTest() {
	
		when(ticketRepository.findByMovieName("Pushpa")).thenReturn(tickets);
		List<Ticket> actualTickets = movieService.getAllBookedTickets("Pushpa");
		assertEquals(tickets, actualTickets);
	}

	

	@Test
	void deleteByMovieNameTest() {
		
		movieService.deleteByMovieName("KGF");
		verify(movieRepository, times(1)).deleteByMovieName("KGF");
	}

}

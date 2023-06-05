package com.moviebookingapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.moviebookingapp.repository.MovieRepository;
import com.moviebookingapp.repository.RoleRepository;

import java.util.List;

@SpringBootApplication
public class MovieappApplication implements CommandLineRunner {

	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private MongoTemplate mongoTemplate;


	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}

package com.moviebookingapp.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebookingapp.models.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends MongoRepository<Ticket,String> {

    List<Ticket> findByMovieNameAndTheatreName(String movieName, String theatreName);
    List<Ticket> findByMovieName(String movieName);

    Ticket findBy_id(ObjectId id);
}

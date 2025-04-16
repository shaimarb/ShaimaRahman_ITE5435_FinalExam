package com.sr.spring.finalex.repo;


import com.sr.spring.finalex.models.Reservation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository extends MongoRepository<Reservation, String> {
}

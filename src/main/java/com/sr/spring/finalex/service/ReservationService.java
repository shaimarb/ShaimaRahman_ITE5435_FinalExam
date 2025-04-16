package com.sr.spring.finalex.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sr.spring.finalex.models.AirlineTicket;
import com.sr.spring.finalex.models.Payment;
import com.sr.spring.finalex.models.Reservation;
import com.sr.spring.finalex.repo.ReservationRepository;
import java.io.File;


@Service
public class ReservationService {
    @Autowired private ReservationRepository repo;
    @Autowired private ObjectMapper objectMapper;

    public Reservation save(Reservation r) {
        try {
            objectMapper.writeValue(new File("reservation.json"), r);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (r.getPayment() == null) {
            r.setPayment(new Payment());
        }

        calculateAndSetPayment(r);
        return repo.save(r);
    }


    public List<Reservation> findAll() { return repo.findAll(); }
    public Optional<Reservation> findById(String id) { return repo.findById(id); }

    public Reservation update(String id, Reservation updated) {
        return repo.findById(id).map(existing -> {
            existing.setDetails(updated.getDetails());
            existing.setDate(updated.getDate());
            updateTicket(existing.getTicket(), updated.getTicket());
            calculateAndSetPayment(existing);
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public void updateTicket(AirlineTicket original, AirlineTicket updated) {
        original.setNumber(updated.getNumber());
        original.setDetails(updated.getDetails());
        original.setPrice(updated.getPrice());
    }

    public void calculateAndSetPayment(Reservation r) {
        int amount = 0;
        try {
            amount = (int) Double.parseDouble(r.getTicket().getPrice());
        } catch (NumberFormatException ignored) {}
        r.getPayment().setAmount(amount);
        r.getPayment().setDate(LocalDate.now().toString());
    }
}
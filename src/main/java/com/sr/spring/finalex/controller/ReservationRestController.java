package com.sr.spring.finalex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sr.spring.finalex.models.Reservation;
import com.sr.spring.finalex.service.ReservationService;

@RestController
@RequestMapping("/api/reservations")
public class ReservationRestController {
    @Autowired private ReservationService service;

    @PostMapping
    public Reservation create(@RequestBody Reservation reservation) { return service.save(reservation); }

    @GetMapping
    public List<Reservation> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Reservation get(@PathVariable String id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable String id, @RequestBody Reservation updatedReservation) {
        return service.update(id, updatedReservation);
    }
}

package com.sr.spring.finalex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sr.spring.finalex.models.Reservation;
import com.sr.spring.finalex.service.ReservationService;

import jakarta.validation.Valid;


@Controller
public class ReservationWebController {
    @Autowired private ReservationService service;

    @GetMapping("/")
    public String redirectToForm() { return "redirect:/reservation/form"; }

    @GetMapping("/reservation/form")
    public String showForm(Model model) {
        model.addAttribute("reservation", new Reservation());
        return "reservation_form";
    }

    @PostMapping("/reservation/submit")
    public String submit(@Valid @ModelAttribute Reservation reservation, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "reservation_form";
        }
        try {
            Reservation saved = service.save(reservation);
            model.addAttribute("payment", saved.getPayment());
            return "success";
        } catch (Exception e) {
            return "error";
        }
    }
}

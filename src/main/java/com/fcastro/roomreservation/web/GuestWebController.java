package com.fcastro.roomreservation.web;

import com.fcastro.roomreservation.business.service.ReservationService;
import com.fcastro.roomreservation.data.entity.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class GuestWebController {
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public String getGuests(@RequestParam (value="lastName", required=false)String lastName, Model model){
        List<Guest> guests = this.reservationService.getGuestsByLastName(lastName);
        model.addAttribute("guests", guests);
        return "guests";
    }
}

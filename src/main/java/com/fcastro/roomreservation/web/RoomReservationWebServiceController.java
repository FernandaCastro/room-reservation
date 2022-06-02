package com.fcastro.roomreservation.web;

import com.fcastro.roomreservation.business.domain.RoomReservation;
import com.fcastro.roomreservation.business.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/reservations")
public class RoomReservationWebServiceController {
    @Autowired
    ReservationService reservationService;

    @GetMapping
    public List<RoomReservation> getReservations(@RequestParam(name="date", required=false)String dateString){
        Date date = DateUtils.createDateFromDateString(dateString);
        return reservationService.getRoomReservationsForDate(date);
    }
}

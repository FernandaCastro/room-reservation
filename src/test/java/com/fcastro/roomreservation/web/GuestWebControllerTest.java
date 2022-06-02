package com.fcastro.roomreservation.web;

import com.fcastro.roomreservation.business.service.ReservationService;
import com.fcastro.roomreservation.data.entity.Guest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(GuestWebController.class)
public class GuestWebControllerTest {
    @MockBean
    private ReservationService reservationService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getGuests() throws Exception{
        String lastName = "Unit";
        List<Guest> guests = new ArrayList<>();
        Guest guest = new Guest();
        guest.setGuestId(1);
        guest.setLastName("Unit");
        guest.setFirstName("Junit");
        guest.setPhoneNumber("+155555555555");
        guest.setEmailAddress("Junit.Unit@gmail.com");
        guest.setAddress("1, JUnit Street");
        guest.setState("NY");
        guest.setCountry("US");
        guests.add(guest);

        given(reservationService.getGuestsByLastName(lastName)).willReturn(guests);

        this.mockMvc.perform(get("/guests?lastName=Unit"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Unit")));
    }
}

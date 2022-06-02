package com.fcastro.roomreservation.data.repository;

import com.fcastro.roomreservation.data.entity.Guest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<Guest, Long> {

    Iterable<Guest> findAllByLastName(String lastName);
}

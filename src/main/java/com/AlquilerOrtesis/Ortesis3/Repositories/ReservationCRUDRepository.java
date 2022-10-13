package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {
}

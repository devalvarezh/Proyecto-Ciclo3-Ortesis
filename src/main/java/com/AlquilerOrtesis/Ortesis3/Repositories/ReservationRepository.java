package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }

    public Optional<Reservation> getReservation(int idReservaation){
        return reservationCRUDRepository.findById(idReservaation);
    }

    public Reservation save(Reservation reservation){
        return reservationCRUDRepository.save(reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservationCRUDRepository.delete(reservation);
    }
}

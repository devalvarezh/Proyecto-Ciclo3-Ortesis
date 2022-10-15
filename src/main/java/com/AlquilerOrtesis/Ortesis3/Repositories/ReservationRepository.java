package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Client;
import com.AlquilerOrtesis.Ortesis3.Model.DTO.ReservationsByClient;
import com.AlquilerOrtesis.Ortesis3.Model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    //Connect to Reservation CRUD repository
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection") //To avoid warning on reservationCRUDRepository couldn't Autowire
    @Autowired
    private ReservationCRUDRepository reservationCRUDRepository;

    //Get a list of all reservations
    public List<Reservation> getAll() {
        return (List<Reservation>) reservationCRUDRepository.findAll();
    }

    //Get info of only one reservation
    public Optional<Reservation> getReservation(int idReservation){
        return reservationCRUDRepository.findById(idReservation);
    }

    //Create and update details of one reservation
    public Reservation save(Reservation reservation){
        return reservationCRUDRepository.save(reservation);
    }

    //Delete one reservation
    public void deleteReservation(Reservation reservation){
        reservationCRUDRepository.delete(reservation);
    }

    //Reservations within two dates
    public List<Reservation> getReservationInPeriod(Date initDate, Date endDate){
        return reservationCRUDRepository.findAllByStartDateAfterAndDevolutionDateBefore(initDate, endDate);
    }

    //Reservations by status
    public List<Reservation> getReservationByStatus(String status){
        return reservationCRUDRepository.findAllByStatus(status);
    }

    //Clients sorted by reservations
    public List<ReservationsByClient> getTopClients(){
        List<ReservationsByClient> respuesta = new ArrayList<>();
        List<Object[]> report = reservationCRUDRepository.countTotalReservationByClient();

        for (int i = 0; i < report.size(); i++) {
            respuesta.add(new ReservationsByClient((Long) report.get(i)[1], (Client)report.get(i)[0]));

        }
        return respuesta;
    }
}

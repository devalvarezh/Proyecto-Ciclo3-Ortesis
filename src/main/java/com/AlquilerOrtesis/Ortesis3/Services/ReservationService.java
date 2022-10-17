package com.AlquilerOrtesis.Ortesis3.Services;

import com.AlquilerOrtesis.Ortesis3.Model.DTO.ReservationsByClient;
import com.AlquilerOrtesis.Ortesis3.Model.DTO.StatusReport;
import com.AlquilerOrtesis.Ortesis3.Model.Reservation;
import com.AlquilerOrtesis.Ortesis3.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int idReservation){
        return reservationRepository.getReservation(idReservation);
    }

    public Reservation createReservation(Reservation reservation){
        if(reservation.getIdReservation()==null){
            return reservationRepository.save(reservation);
        } else
            return reservation;
    }

    public Reservation updateReservation(Reservation reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservation> temp = reservationRepository.getReservation(reservation.getIdReservation());
            if (temp.isPresent()){
                if(reservation.getStartDate()!=null)
                    temp.get().setStartDate(reservation.getStartDate());
                if(reservation.getDevolutionDate()!=null)
                    temp.get().setDevolutionDate(reservation.getDevolutionDate());
                if(reservation.getStatus()!=null)
                    temp.get().setStatus(reservation.getStatus());
                if(reservation.getOrtopedic()!=null)
                    temp.get().setOrtopedic(reservation.getOrtopedic());
                return reservationRepository.save(temp.get());
            }else
                return reservation;
        }else
            return reservation;
    }

    public boolean deleteReservation(int idReservation){
        Boolean success = getReservation(idReservation).map(reservation -> {
            reservationRepository.deleteReservation(reservation);
            return true;
        }).orElse(false);
        return true;
    }

    //Reto 5

    public List<Reservation> getReservationsInPeriodReport(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yy-MM-dd");
        Date initialDate = new Date();
        Date endDate = new Date();
        try {
            initialDate = parser.parse(dateA);
            endDate = parser.parse(dateB);
        }catch (ParseException exception){
            exception.printStackTrace();
        }

        if (initialDate.before(endDate)){
            return reservationRepository.getReservationInPeriod(initialDate, endDate);
        } else
            return new ArrayList<>();
    }

    public StatusReport getReservationStatusReport() {
        List<Reservation> completed = reservationRepository.getReservationByStatus("completed");
        List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

        return new StatusReport((int) completed.size(), (int) cancelled.size());
    }

    public List<ReservationsByClient> getTopClientsReport(){
        return reservationRepository.getTopClients();
    }

}

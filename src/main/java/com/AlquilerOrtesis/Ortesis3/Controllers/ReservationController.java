package com.AlquilerOrtesis.Ortesis3.Controllers;

import com.AlquilerOrtesis.Ortesis3.Model.DTO.ReservationsByClient;
import com.AlquilerOrtesis.Ortesis3.Model.DTO.StatusReport;
import com.AlquilerOrtesis.Ortesis3.Model.Reservation;
import com.AlquilerOrtesis.Ortesis3.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @GetMapping("/{idReservation}")
    public Optional<Reservation> getReservation(@PathVariable("idReservation") int idReservaation){
        return reservationService.getReservation(idReservaation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation createReservation(@RequestBody Reservation reservation){
        return reservationService.createReservation(reservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.updateReservation(reservation);
    }

    @DeleteMapping("/idReservation")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteReservation(@PathVariable("idReservation")int idReservation){
        return reservationService.deleteReservation(idReservation);
    }

    @GetMapping("/report-dates/{dateA}/{dateB}")
    public List<Reservation> getReservationsInPeriodReport(@PathVariable("dateA") String dateA, @PathVariable("dateB") String dateB){
        return reservationService.getReservationsInPeriodReport(dateA, dateB);
    }

    @GetMapping("/report-status")
    public StatusReport getReservationStatusReport(){
        return reservationService.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<ReservationsByClient> getTopClientsReport(){
        return reservationService.getTopClientsReport();
    }
}

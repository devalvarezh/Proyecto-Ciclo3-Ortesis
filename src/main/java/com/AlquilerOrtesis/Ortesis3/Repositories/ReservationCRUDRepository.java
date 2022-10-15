package com.AlquilerOrtesis.Ortesis3.Repositories;

import com.AlquilerOrtesis.Ortesis3.Model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCRUDRepository extends CrudRepository<Reservation, Integer> {

    //Get reservations within two dates
    public List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date initDate, Date endDate);

    public List<Reservation> findAllByStatus(String status);

    @Query("SELECT r.client, COUNT(r.client) FROM Reservation AS r GROUP BY r.client ORDER BY COUNT(r.client) DESC")
    public List<Object[]> countTotalReservationByCLient();
}

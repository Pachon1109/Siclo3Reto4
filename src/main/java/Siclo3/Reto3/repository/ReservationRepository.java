package Siclo3.Reto3.repository;

import Siclo3.Reto3.model.Reservation;
import Siclo3.Reto3.repository.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Repository
public class ReservationRepository {
    @Autowired
    private ReservationCrudRepository reservationCrudRepository;
    
    public List<Reservation>getAll(){
        return (List<Reservation>)reservationCrudRepository.findAll();
    }
    public Optional<Reservation>getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation SaveReservation(Reservation p){
        return reservationCrudRepository.save(p);
    }
    public void ReservationDel(Reservation p){
        reservationCrudRepository.delete(p);
    }
}

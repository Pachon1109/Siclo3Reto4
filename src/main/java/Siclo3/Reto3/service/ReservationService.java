package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Reservation;
import Siclo3.Reto3.repository.ReservationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    
    public List<Reservation>getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation>getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation SaveReservation (Reservation r){
        if (r.getIdReservation()==null){
            return reservationRepository.SaveReservation(r);
        }else{
            Optional<Reservation>raux=reservationRepository.getReservation(r.getIdReservation());
            if(raux.isEmpty()){
                return reservationRepository.SaveReservation(r);
            }else{
                return r;
            }
        }
    }
    public Reservation ReservationUpdate(Reservation r) {
    if (r.getIdReservation()!= null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Reservation> auxReservation = reservationRepository.getReservation(r.getIdReservation());

      //Verifica que el id no sea vacío
      if (!auxReservation.isEmpty()) {

        if (r.getStartDate() != null) {
          auxReservation.get().setStartDate(r.getStartDate());
        }

        if (r.getDevolutionDate() != null) {
          auxReservation.get().setDevolutionDate(r.getDevolutionDate());
        }

        if (r.getStatus() != null) {
          auxReservation.get().setStatus(r.getStatus());
        }

        //Tablas relacionadas 
        if (r.getPartyroom()!= null) {
          auxReservation.get().setPartyroom(r.getPartyroom());
        }

        if (r.getClient() != null) {
          auxReservation.get().setClient(r.getClient());
        }

        if (r.getScore() != null) {
          auxReservation.get().setScore(r.getScore());
        }

        //Guarda el valor actual
        reservationRepository.SaveReservation(auxReservation.get());

        //Retorna el valor 
        return auxReservation.get();
      } else {
        return r;
      }
    } else {
      return r;
    }
  }

  public Boolean ReservationDel(Integer id) {
    Boolean objEliminar = getReservation(id).map(Reservation -> {
      reservationRepository.ReservationDel(Reservation);
      return true;
    }).orElse(false);
    return objEliminar;
  }
}

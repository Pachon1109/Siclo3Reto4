/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Siclo3.Reto3.repository.crud;

import Siclo3.Reto3.model.Reservation;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Francisco Andrade Navarro
 */
public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{
    
}

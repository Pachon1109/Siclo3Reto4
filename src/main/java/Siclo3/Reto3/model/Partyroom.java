/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Siclo3.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Entity
@Table(name = "partyroom")
public class Partyroom implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String owner;
    private Integer capacity;
    private String description;
    //private Integer category_id;
    

    //Relacion de la tabla categoria
    @ManyToOne
    @JoinColumn(name="categoryid")
    @JsonIgnoreProperties({"partyrooms","Category"})
    private Category category; 
    

    //relacion de la tabla message
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "partyroom")
    @JsonIgnoreProperties({"partyroom","client"})
    public List<Message>messages;
    
    //Relacion con la tabla Reservation
    public List<Reservation> getReservations() {
        return reservations;
    }
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "partyroom")
    @JsonIgnoreProperties({"partyroom", "Reservations"})
    public List<Reservation> reservations;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    
    
}

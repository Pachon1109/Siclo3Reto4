/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Siclo3.Reto3.repository;

import Siclo3.Reto3.model.Message;
import Siclo3.Reto3.repository.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Repository
public class MessageRepository {
    @Autowired
    private MessageCrudRepository messageCrudRepository;
    
    public List<Message>getMessage(){
        return (List<Message>)messageCrudRepository.findAll();
    }
    public Optional<Message>getMessage(int id){
        return messageCrudRepository.findById(id);
    }
    public Message SaveMessage(Message m){
        return messageCrudRepository.save(m);
    }
    public void MessageDel(Message m){
        messageCrudRepository.delete(m);
    }
}

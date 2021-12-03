package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Message;
import Siclo3.Reto3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message>getMessage(){
        return messageRepository.getMessage();
    }
    public Optional<Message>getIdMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message SaveMessage(Message m){
        if (m.getIdMessage()==null){
            return messageRepository.SaveMessage(m);        
    }else{
            Optional<Message> maux=messageRepository.getMessage(m.getIdMessage());
            if(maux.isEmpty()){
                return messageRepository.SaveMessage(m);
            }else{
                return m;
            }
        }
    }
    public Message MessageUpdate(Message a){
        if(a.getIdMessage()!=null){
            
            Optional<Message>auxi=messageRepository.getMessage(a.getIdMessage());
            
            if(!auxi.isEmpty()){
                if(a.getIdMessage()!=null){
                    auxi.get().setIdMessage((a.getIdMessage()));
                    }                
                //Tablas relacionadas 
                if (a.getPartyroom()!= null) {
                    auxi.get().setPartyroom(a.getPartyroom());
                    }
                if (a.getClient() != null) {
                auxi.get().setClient(a.getClient());
                    }
                messageRepository.SaveMessage(auxi.get());
                
                return auxi.get();
                }else{
                return a;
                }
            }else{
            return a;
            }
        }
    public Boolean MessageDel(Integer id){
        Boolean objEliminar = getIdMessage(id).map(Message ->{
        messageRepository.MessageDel(Message);
        return true;
     }).orElse(false);
     return objEliminar;
    }    
}

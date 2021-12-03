package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Client;
import Siclo3.Reto3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client>getAll(){
        return clientRepository.getAll();
    }
    
    public Optional<Client>getClient(int id){
        return clientRepository.getClient(id);
    }
    
    public Client SaveClient(Client c){
        if (c.getIdClient()==null){
            return clientRepository.SaveClient(c);
        }else{
            Optional<Client> cpaux=clientRepository.getClient(c.getIdClient());
            if(cpaux.isEmpty()){
                return clientRepository.SaveClient(c);
            }else{
                return c;
            }
        }
    }
    public Client ClientUpdate(Client a){
        if(a.getIdClient()!=null){
            
            Optional<Client>auxi=clientRepository.getClient(a.getIdClient());
            
            if(!auxi.isEmpty()){
                if(a.getEmail()!=null){
                    auxi.get().setEmail((a.getEmail()));
                    }
                if(a.getPassword()!=null){
                    auxi.get().setPassword(a.getPassword());
                    }
                if(a.getName()!=null){
                    auxi.get().setName(a.getName());
                    }
                if(a.getAge()!=null){
                    auxi.get().setAge(a.getAge());
                    }
                //tablas relacionadas 
                if (a.getMessages() != null) {
                auxi.get().setMessages(a.getMessages());
                }
                if (a.getReservations() != null) {
                auxi.get().setReservations(a.getReservations());
                }
                
                clientRepository.SaveClient(auxi.get());
                
                return auxi.get();
                }else{
                return a;
                }
            }else{
            return a;
            }
        }
    public Boolean ClientDel(Integer id){
        Boolean objEliminar = getClient(id).map(Client ->{
            clientRepository.ClientDel(Client);
            return true;
            }).orElse(false);
        return objEliminar;
    }
}

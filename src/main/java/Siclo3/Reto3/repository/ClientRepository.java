package Siclo3.Reto3.repository;

import Siclo3.Reto3.model.Client;
import Siclo3.Reto3.repository.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Repository
public class ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    public List<Client>getAll(){
        return (List<Client>)clientCrudRepository.findAll();
    }
    
    public Optional<Client>getClient(int id){
        return clientCrudRepository.findById(id);
    }
    
    public Client SaveClient(Client c){
        return clientCrudRepository.save(c);
    }
    
    public void ClientDel (Client c){
        clientCrudRepository.delete(c);
    }
}

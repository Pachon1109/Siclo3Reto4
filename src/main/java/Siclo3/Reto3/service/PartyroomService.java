package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Partyroom;
import Siclo3.Reto3.repository.PartyroomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Service
public class PartyroomService {
    @Autowired
    private PartyroomRepository partyroomRepository;
    
    public List<Partyroom>getAll(){
        return partyroomRepository.getAll();
    }
    
    public Optional<Partyroom>getParyroom(int id){
        return partyroomRepository.getPartyroom(id);
    }
    
    public Partyroom SavePartyroom(Partyroom p){
        if (p.getId()==null){
            return partyroomRepository.SavePartyroom(p);
        }else{
            Optional<Partyroom> paux=partyroomRepository.getPartyroom(p.getId());
            if(paux.isEmpty()){
                return partyroomRepository.SavePartyroom(p);
            }else{
                return p;
            }
        }
    }
     public Partyroom partyroomUpdate(Partyroom a){
        if(a.getId()!=null){
            
            Optional<Partyroom>auxi=partyroomRepository.getPartyroom(a.getId());
            
            if(!auxi.isEmpty()){
                if(a.getName()!=null){
                    auxi.get().setName((a.getName()));
                    }
                if(a.getOwner()!=null){
                    auxi.get().setOwner(a.getOwner());
                    }
                if(a.getCapacity()!=null){
                    auxi.get().setCapacity(a.getCapacity());
                    }
                if(a.getDescription()!=null){
                    auxi.get().setDescription(a.getDescription());
                    }
                //Tablas relacionadas   
                if (a.getCategory() != null) {
                auxi.get().setCategory(a.getCategory());
                }

                if (a.getMessages() != null) {
                auxi.get().setMessages(a.getMessages());
                }

                if (a.getReservations()!= null) {
                auxi.get().setReservations(a.getReservations());
                }
                partyroomRepository.SavePartyroom(auxi.get());
                
                return auxi.get();
                }else{
                return a;
                }
            }else{
            return a;
            }
        }
    public Boolean PartyroomDel(Integer id){
        Boolean objEliminar = getParyroom(id).map(Partyroom ->{
            partyroomRepository.PartyroomDel(Partyroom);
            return true;
            }).orElse(false);
        return objEliminar;
    }
}


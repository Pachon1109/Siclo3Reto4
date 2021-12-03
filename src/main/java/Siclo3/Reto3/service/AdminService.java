package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Admin;
import Siclo3.Reto3.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
    
    public List<Admin>getAll(){
        return adminRepository.getAll();
    }
    public Optional<Admin>getAdmin(int id){
        return adminRepository.getAdmin(id);
    }
    public Admin SaveAdmin(Admin a){
        if(a.getId()==null){
            return adminRepository.SaveAdmin(a);        
    }else{
            Optional<Admin> aaux=adminRepository.getAdmin(a.getId());
            if(aaux.isEmpty()){
                return adminRepository.SaveAdmin(a);
            }else{
                return a;
            }
        }
    }
    public Admin AdminUpdate(Admin a){
        if(a.getId()!=null){
            
            Optional<Admin>auxi=adminRepository.getAdmin(a.getId());
            
            if(!auxi.isEmpty()){
                if(a.getName()!=null){
                    auxi.get().setName((a.getName()));
                    }
                if(a.getEmail()!=null){
                    auxi.get().setEmail(a.getEmail());
                    }
                if(a.getPassword()!=null){
                    auxi.get().setPassword(a.getPassword());
                    }
                adminRepository.SaveAdmin(auxi.get());
                
                return auxi.get();
                }else{
                return a;
                }
            }else{
            return a;
            }
        }
    public Boolean AdminDel(Integer id){
        Boolean objEliminar = getAdmin(id).map(Admin ->{
            adminRepository.AdminDel(Admin);
            return true;
            }).orElse(false);
        return objEliminar;
    }
}


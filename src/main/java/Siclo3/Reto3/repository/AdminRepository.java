package Siclo3.Reto3.repository;
import Siclo3.Reto3.model.Admin;
import Siclo3.Reto3.repository.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



/**
 *
 * @author Francisco Andrade Navarro
 */
@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    
    public List<Admin>getAll(){
        return (List<Admin>)adminCrudRepository.findAll();
    }
    public Optional<Admin>getAdmin(int id){
        return adminCrudRepository.findById(id);
    }
    public Admin SaveAdmin(Admin a){
        return adminCrudRepository.save(a);
    }
    public void AdminDel (Admin a){
        adminCrudRepository.delete(a);
    } 
}

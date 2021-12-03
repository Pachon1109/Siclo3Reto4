package Siclo3.Reto3.repository;

import Siclo3.Reto3.model.Category;
import Siclo3.Reto3.repository.crud.CategoryCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;
    
    public List<Category>getAll(){
        return (List<Category>)categoryCrudRepository.findAll();
    }
    public Optional<Category>getCategory(int id){
        return categoryCrudRepository.findById(id);
    }
    public Category SaveCategory(Category c){
        return categoryCrudRepository.save(c);
    }
    public void CategoryDel (Category c){
        categoryCrudRepository.delete(c);
    }
}

package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Category;
import Siclo3.Reto3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category>getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category>getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    public Category SaveCategory(Category c){
        if (c.getId()==null){
            return categoryRepository.SaveCategory(c);
        }else{
            Optional<Category> caux=categoryRepository.getCategory(c.getId());
            if(caux.isEmpty()){
                return categoryRepository.SaveCategory(c);
            }else{
                return c;
            }
        }
    }
    public Category CategoryUpdate(Category c){
        if(c.getId()!=null){
            
            Optional<Category>auxicategory=categoryRepository.getCategory(c.getId());
            
            if(!auxicategory.isEmpty()){
                if(c.getName()!=null){
                    auxicategory.get().setName((c.getName()));
                    }
                if(c.getDescription()!=null){
                    auxicategory.get().setDescription(c.getDescription());
                    }
                categoryRepository.SaveCategory(auxicategory.get());
                return auxicategory.get();
                }else{
                return c;
                }
            }else{
            return c;
            }
        }
    public Boolean CategoryDel(Integer id){
        Boolean objEliminar = getCategory(id).map(Category ->{
        categoryRepository.CategoryDel(Category);
        return true;
     }).orElse(false);
     return objEliminar;
    }
}


package Siclo3.Reto3.service;

import Siclo3.Reto3.model.Score;
import Siclo3.Reto3.repository.ScoreRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Francisco Andrade Navarro
 */
@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepoitory;
    
    public List<Score>getAll(){
        return scoreRepoitory.getAll();
    }
    public Optional<Score>getScore(int id){
        return scoreRepoitory.getScore(id);
    }
    public Score SaveScore(Score s){
        if(s.getId()==null){
            return scoreRepoitory.SaveScore(s);
        }else{
            Optional<Score> saux=scoreRepoitory.getScore(s.getId());
            if(saux.isEmpty()){
                return scoreRepoitory.SaveScore(s);
            }else{
                return s;
            }
        }
    }
    public Score ScoreUpdate(Score s) {
    if (s.getId()!= null) { //Verifica si el id no está vacío

      //Crea un auxiliar en el que se guarda el id del elemento
      Optional<Score> auxScore = scoreRepoitory.getScore(s.getId());

      //Verifica que el id no sea vacío
      if (!auxScore.isEmpty()) {

        if (s.getScore()!= null) {
          auxScore.get().setScore(s.getScore());
        }

        if (s.getMessage() != null) {
          auxScore.get().setMessage(s.getMessage());
        }
        //Guarda el valor actual
        scoreRepoitory.SaveScore(auxScore.get());

        //Retorna el valor 
        return auxScore.get();
      } else {
        return s;
      }
    } else {
      return s;
    }
  }

  public Boolean ScoreDel(Integer id) {
    Boolean objEliminar = getScore(id).map(Score -> {
      scoreRepoitory.ScoreDel(Score);
      return true;
    }).orElse(false);
    return objEliminar;
  }
}

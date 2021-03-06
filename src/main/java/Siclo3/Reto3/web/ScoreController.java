package Siclo3.Reto3.web;

import Siclo3.Reto3.model.Score;
import Siclo3.Reto3.service.ScoreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Francisco Andrade Navarro
 */
@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    
    @GetMapping("/all")
    public List<Score>getScore(){
        return scoreService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Score>getScore(@PathVariable("id")int id){
        return scoreService.getScore(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score s){
    return scoreService.SaveScore(s);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score ScoreUpdate(@RequestBody Score s) {
    return scoreService.ScoreUpdate(s);
  }

  @DeleteMapping("{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public Boolean ScoreDel(@PathVariable Integer id) {
    return scoreService.ScoreDel(id);
  }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Siclo3.Reto3.web;

import Siclo3.Reto3.model.Admin;
import Siclo3.Reto3.service.AdminService;
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
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AdminController {
    @Autowired
    private AdminService adminService;
    
    @GetMapping("/all")
    public List<Admin>getAdmin(){
        return adminService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Admin>getAdmin(@PathVariable("id")int id){
        return adminService.getAdmin(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)  
    public Admin save(@RequestBody Admin a){
        return adminService.SaveAdmin(a);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin AdminUpdate(@RequestBody Admin a) {
    return adminService.AdminUpdate(a);
  }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Boolean delAdmin(@PathVariable Integer id) {
    return adminService.AdminDel(id);
  }
}

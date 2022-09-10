package com.sample.Project.prac.controller;

import com.sample.Project.prac.models.users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sample.Project.prac.repository.Userdetails;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@RestController
public class userController {
    @Autowired
    Userdetails UserDetails;
    @PostMapping("/insertUser")
    public users insert(@RequestBody users User){
        UserDetails.save(User);
        return User;
    }
    @PostMapping("/getAllUsers")
    public List<users> getAllUsers(){
        return (List<users>) UserDetails.findAll();
    }
    @PostMapping("/findUser/{name}")
    public List<users> findUserByName(@PathVariable("name") String name){
        return (List<users>) UserDetails.findByfirstName(name);
    }
    @PostMapping("/findById/{id}")
    public Optional<users> findById(@PathVariable("id") int id){
      return  UserDetails.findById(id);
    }
   @PostMapping("/updatefirstName/{id}")
    public void updatefirstName(@PathVariable("id") int id , @RequestBody users Users){
      UserDetails.updatefirstName(id, Users.getFirstName());
   }
   @PostMapping("/updateDetails")
    public void updateDetails(@RequestBody users User){
      try {
          users Users = UserDetails.findById(User.getId()).orElse(null);
          if(Users==null){
          }
          Users.setFirstName(User.getFirstName());
          Users.setLastName(User.getLastName());
          Users.setCity(User.getCity());
          Users.setAddress(User.getAddress());
          UserDetails.save(Users);
      }
      catch(Exception e){
          System.out.println(e);
      }
   };
    @PostMapping("/simple")
    public String fun(){
        try {
            return "Cha Tha Kayo";
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "Cha Tha Kayo";

    };


}

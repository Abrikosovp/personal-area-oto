package com.example.personalareaoto.controller;

import com.example.personalareaoto.model.User;
import com.example.personalareaoto.repo.UserRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:8080"})
@RestController
public class AuthController {

    private final UserRepo repo;

    public AuthController(UserRepo repo) {
        this.repo = repo;
    }

    @PostMapping("/registration")
    public User registration(
            @RequestBody User user
    ) {
       User userBd = repo.findByEmail(user.getEmail());

       if (userBd != null) {
          return null;
       }
        repo.save(user);
        return user;
    }

    @PostMapping("/login")
    public User authentication(
            @RequestBody User user
    ) {
        System.out.println(user);

//        User userBd = repo.findByEmail(user.getEmail());
//        if (userBd == null) {
//            throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
//        }
        repo.save(user);
        return user;
    }

    @RequestMapping(value = "/employees/{id}")
    public ResponseEntity<User> getEmployeeById (@PathVariable("id") int id)
    {
        if (id <= 3) {
            User employee = new User(1L, "howtodoinjava@gmail.com", "Lokesh","Gupta", true);
            return new ResponseEntity<User>(employee, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(
            @RequestHeader(name = "X-COM-PERSIST", required = true) String headerPersist,
            @RequestHeader(name = "X-COM-LOCATION", defaultValue = "ASIA") String headerLocation,
            @RequestBody User employee)
            throws Exception
    {

        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(employee.getId())
                .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
}

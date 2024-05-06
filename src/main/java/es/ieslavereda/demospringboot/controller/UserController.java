package es.ieslavereda.demospringboot.controller;


import es.ieslavereda.demospringboot.model.User;
import es.ieslavereda.demospringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/api/v1/users")
    public List<User> getUsers() {
       return userService.getAllUsers();
    }

    @GetMapping("/api/v1/user/{id}")
    public User getUser(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/api/v1/user")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    private ResponseEntity<?> getResponseError(Exception e){
        Map<String, String > map = new HashMap<>();

        map.put("errorCode", String.valueOf(e.getCause()));
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}












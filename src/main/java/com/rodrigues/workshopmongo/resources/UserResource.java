package com.rodrigues.workshopmongo.resources;

import com.rodrigues.workshopmongo.domain.User;
import com.rodrigues.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();

        return ResponseEntity.ok().body(list);
    }

/*    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {

    }*/

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User obj = service.save(user);;

        return ResponseEntity.ok().body(obj);
    }
}

package com.rodrigues.workshopmongo.resources;

import com.rodrigues.workshopmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1001", "Maria", "maria@gmail.com");
        User alex = new User("1002", "Alex", "alex@gmail.com");

        List<User> list = new ArrayList<>(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        User maria = new User("1001", "Maria", "maria@gmail.com");

        if (id.equals(maria.getId())) {
            return ResponseEntity.ok().body(maria);
        }
        else{
            return ResponseEntity.ok().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User x = user;
        user.setId("1003");


        return ResponseEntity.ok().body(x);
    }
}

package com.rodrigues.workshopmongo.resources;

import com.rodrigues.workshopmongo.domain.User;
import com.rodrigues.workshopmongo.dto.UserDTO;
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
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();

        List<UserDTO> listDTO = list.stream().map(UserDTO::new).toList();

        return ResponseEntity.ok().body(listDTO);
    }

/*    @GetMapping(path = "/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {

    }*/

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User obj = service.save(user);

        return ResponseEntity.ok().body(obj);
    }
}

package com.rodrigues.workshopmongo.resources;

import com.rodrigues.workshopmongo.domain.User;
import com.rodrigues.workshopmongo.dto.UserDTO;
import com.rodrigues.workshopmongo.resources.exceptions.StandardError;
import com.rodrigues.workshopmongo.service.UserService;
import com.rodrigues.workshopmongo.service.exception.ObjectNotFoundException;
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

    @GetMapping(path = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
            User user = service.findById(id);

            UserDTO userDTO = new UserDTO(user);

            return ResponseEntity.ok().body(userDTO);
    }

    @PostMapping
    public ResponseEntity<User> add(@RequestBody User user) {
        User obj = service.save(user);

        return ResponseEntity.ok().body(obj);
    }
}

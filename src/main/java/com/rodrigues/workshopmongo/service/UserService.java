package com.rodrigues.workshopmongo.service;

import com.rodrigues.workshopmongo.domain.User;
import com.rodrigues.workshopmongo.dto.UserDTO;
import com.rodrigues.workshopmongo.repository.UserRepository;
import com.rodrigues.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
    }

    public User insert(User user) {
        return userRepository.insert(user);
    }

    public void delete(String id) {
        findById(id); // chamada apenas para verificar se é um id existente.
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());

        updateData(newObj, obj);

        return userRepository.save(newObj);
    }

    public User fromDTO(UserDTO userDTO) {
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
    }

    public void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

}

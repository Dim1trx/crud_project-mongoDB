package com.rodrigues.workshopmongo.config;

import com.rodrigues.workshopmongo.domain.Post;
import com.rodrigues.workshopmongo.domain.User;
import com.rodrigues.workshopmongo.dto.AuthorDTO;
import com.rodrigues.workshopmongo.repository.PostRepository;
import com.rodrigues.workshopmongo.repository.UserRepository;
import com.rodrigues.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;
    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        postRepository.deleteAll();

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, LocalDate.parse("21/03/2018", fmt),
                "Partiu viagem", "Vou viajar para Sao Paulo. Abracos!", new AuthorDTO(maria));

        Post post2 = new Post(null, LocalDate.parse("23/03/2018", fmt),
                "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}

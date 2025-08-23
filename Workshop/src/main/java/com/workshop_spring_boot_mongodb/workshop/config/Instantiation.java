package com.workshop_spring_boot_mongodb.workshop.config;

import com.workshop_spring_boot_mongodb.workshop.dto.AuthorDTO;
import com.workshop_spring_boot_mongodb.workshop.entities.Post;
import com.workshop_spring_boot_mongodb.workshop.entities.User;
import com.workshop_spring_boot_mongodb.workshop.repositories.PostRepository;
import com.workshop_spring_boot_mongodb.workshop.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    private final SimpleDateFormat sdf;

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Instantiation(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.sdf = new SimpleDateFormat("dd/MM/yyyy");
        this.sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
    }

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(List.of(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acorde feliz hoje!", new AuthorDTO(maria));

        postRepository.saveAll(List.of(post1, post2));
    }
}

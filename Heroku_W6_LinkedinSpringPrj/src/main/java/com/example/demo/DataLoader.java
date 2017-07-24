package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner{


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... strings) throws Exception {
        if (roleRepository.findByRole("recruiter")==null)
        {

            System.out.println("Loading data . . .");

            roleRepository.save(new Role("recruiter"));
            roleRepository.save(new Role("jobSeeker"));

            Role jobRole = roleRepository.findByRole("recruiter");
            Role recruitRole = roleRepository.findByRole("jobSeeker");
            /*
            User user = new User("bob@bob.com", "bob", "Bob", "Bobberson", true, "bob", "jobSeeker");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList(jobRole));
            userRepository.save(user);
            user = new User("jim@jim.com", "jim", "Jim", "Jimmerson", true, "jim", "recruiter");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(Arrays.asList(recruitRole));
            userRepository.save(user);
            */
        }
    }
}
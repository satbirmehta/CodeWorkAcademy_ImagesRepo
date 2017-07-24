package com.example.demo.configs;

import com.example.demo.models.Role;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{


    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run(String... strings) throws Exception
    {
        if (roleRepository.findByRole("USER")==null)
        {
            System.out.println("Loading data . . .");

            roleRepository.save(new Role("USER"));
            roleRepository.save(new Role("ADMIN"));

            Role adminRole = roleRepository.findByRole("ADMIN");
            Role userRole = roleRepository.findByRole("USER");


        }
    }
}
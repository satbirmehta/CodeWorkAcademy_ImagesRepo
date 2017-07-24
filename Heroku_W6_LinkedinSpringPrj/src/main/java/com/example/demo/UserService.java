package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public Long countByEmail(String email) {
        return userRepository.countByEmail(email);
    }
    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public void saveJobSeeker(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("job seeker")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void saveRecruiter(User user) {
        user.setRoles(Arrays.asList(roleRepository.findByRole("recruiter")));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
    }
}
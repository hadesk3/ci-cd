package com.tutorial.employeemanagmentbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tutorial.employeemanagmentbackend.model.User;
import com.tutorial.employeemanagmentbackend.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
	private PasswordEncoder encoder;
    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            User admin = new User();
            admin.setEmail("ngocchau2962003@gmail.com");
            admin.setName("Trần Phạm Ngọc Châu");
            admin.setPassword(encoder.encode("Ngocchau@296"));
            admin.setPhoneNumber("0889318089");
            admin.setRole("ADMIN");
            userRepository.save(admin);
        }
    }
}

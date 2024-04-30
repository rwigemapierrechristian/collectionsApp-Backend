package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.Admin;
import com.example.demo.models.Collections;
import com.example.demo.repository.AdminRepository;
import com.example.demo.repository.CollectionsRepository;


@Service
public class Services {

    @Autowired
    private AdminRepository adminRepository;
    private CollectionsRepository collectionsRepository;
    int strength = 12;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);

    public Services (AdminRepository adminRepository, CollectionsRepository collectionsRepository)
    {
        this.adminRepository = adminRepository;
        this.collectionsRepository = collectionsRepository;
    }

    public String VerifyOfficer(String username, String password) 
    {
        Admin officer = adminRepository.findByUsername(username);

        if (passwordEncoder.matches(password, officer.getPassword())) {
            return "Learning is awesome 🥳";
        } else {
            return "Nuh, Wrong entry dummy 😒";
        }
     }

    public List<Collections> getAllCollections() {
        return collectionsRepository.findAll();
    }
}

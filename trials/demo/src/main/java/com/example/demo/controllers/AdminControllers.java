package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Admin;
import com.example.demo.models.Collections;
import com.example.demo.repository.AdminRepository;
import com.example.demo.services.Services;

@RestController
@RequestMapping("/android")
public class AdminControllers {
    private final Services services;
    @Autowired
    private AdminRepository adminRepository;

    public AdminControllers(Services services)
    {
        this.services = services;
    }

    @GetMapping("/admins")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @CrossOrigin(origins = "http://localhost:8000")
    @PostMapping("/login")
    public String addUser(@RequestBody Admin requestBody) {
        String username = requestBody.getUsername();
        String password = requestBody.getPassword();
        System.out.println("name ===== " + username);
        System.out.println("password ===== " + password);
        return services.VerifyOfficer(username,password);
    }

    @CrossOrigin(origins = "http://localhost:33856")
        @GetMapping("/getdata")
    public ResponseEntity<List<Collections>> getAllUsers() {
        return new ResponseEntity<List<Collections>>(services.getAllCollections(), HttpStatus.OK);
    }
}
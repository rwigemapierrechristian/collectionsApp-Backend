package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {
    Admin findByUsername(String username);
}

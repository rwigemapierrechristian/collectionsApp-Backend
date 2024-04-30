package com.example.demo.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Collections;
@Repository
public interface CollectionsRepository extends MongoRepository<Collections, String> {
    Collections findByname(String name);
}

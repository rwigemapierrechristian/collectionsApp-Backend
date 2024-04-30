package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="collections")
public class Collections {

    @Id
    private String id;
    private String name;
    private String installment;
    private String collection;
    private String savings;
    
    public Collections()
    {
        super();
    }

    public Collections(String name, String installment, String collection, String savings) {
        super();
        this.name = name;
        this.installment = installment;
        this.collection = collection;
        this.savings = savings;
    }

     // Getters and setters
     public String getName() {
        return name;
    }


    public String getInstallment() {
        return installment;
    }


    public String getCollections() {
        return collection;
    }

    public String getSavings() {
        return savings;
    }
}

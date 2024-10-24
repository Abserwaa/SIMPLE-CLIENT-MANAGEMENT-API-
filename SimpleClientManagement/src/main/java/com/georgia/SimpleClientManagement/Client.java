package com.georgia.SimpleClientManagement;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private UUID id;// UUID primary key

    private String name;

    private String age;
    
    private String address;

    private String medicalCondition;

    // Constructors
    public Client() {
    }

    public Client(String name, String age,String address,String medicalCondition) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.medicalCondition = medicalCondition;
    }

    //Getters and Setters
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getMedicalCondition() {
        return medicalCondition;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMedicalCondition(String medicalCondition) {
        this.medicalCondition = medicalCondition;
    }
}





    




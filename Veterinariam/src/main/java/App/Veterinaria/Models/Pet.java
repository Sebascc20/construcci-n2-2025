/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 *
 * @author User
 */
public class Pet {
    private String name;
    private PetOwner idpetowner;
    private int age; 
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String idpet;
    private String specie;
    private String breed;
    private String characteristics;
    private double weight;

    public Pet(String name, PetOwner idpetowner, int age, String idpet, String specie, String breed, String characteristics, double weight) {
        this.name = name;
        this.idpetowner = idpetowner;
        this.age = age;
        this.idpet = idpet;
        this.specie = specie;
        this.breed = breed;
        this.characteristics = characteristics;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetOwner getIdpetowner() {
        return idpetowner;
    }

    public void setIdpetowner(PetOwner idpetowner) {
        this.idpetowner = idpetowner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIdpet() {
        return idpet;
    }

    public void setIdpet(String idpet) {
        this.idpet = idpet;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }



       
    
}

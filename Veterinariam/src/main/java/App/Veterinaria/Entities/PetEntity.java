/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package App.Veterinaria.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PetEntity {
    private String name;
    private PetOwnerEntity idpetowner;
    private int age;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String petId;
    private String specie;
    private String breed;
    private String characteristics;
    private double weight;
    

    public PetEntity() {
    }

    public PetEntity(String name, PetOwnerEntity idpetowner, int age, String petId, String specie, String breed, String characteristics, double weight) {
        this.name = name;
        this.idpetowner = idpetowner;
        this.age = age;
        this.petId = petId;
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

    public PetOwnerEntity getIdpetowner() {
        return idpetowner;
    }

    public void setIdpetowner(PetOwnerEntity idpetowner) {
        this.idpetowner = idpetowner;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
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

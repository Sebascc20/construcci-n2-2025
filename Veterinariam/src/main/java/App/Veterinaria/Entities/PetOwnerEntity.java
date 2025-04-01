/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package App.Veterinaria.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class PetOwnerEntity {
   
    @Id
    private String ownerId;
    private String name;
    private int age;
    @OneToMany(mappedBy = "petOwner") // Relación uno a muchos con mascotas
    private List<PetEntity> pets;
    private String role;
    public PetOwnerEntity() {
    }

    public PetOwnerEntity(String ownerId, String name, int age, List<PetEntity> pets, String role) {
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.pets = pets;
        this.role = "Owner";
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<PetEntity> getPets() {
        return pets;
    }

    public void setPets(List<PetEntity> pets) {
        this.pets = pets;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    

   

}
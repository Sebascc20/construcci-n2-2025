/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Models;


public class PetOwner {
    private String idpetowner;
    private String name;
    private int age;
    private String role;
    private Pet pet;

    public PetOwner(String idpetowner, String name, int age, String role, Pet pet) {
        this.idpetowner = idpetowner;
        this.name = name;
        this.age = age;
        this.role = "Owner";
        this.pet = pet;
        
    }
    public String getId() {
        return idpetowner;
    }

    public void setId(String idpetowner) {
        this.idpetowner = idpetowner;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Pet getNamepet() {
        return pet;
    }

    public void setNamepet(Pet namepet) {
        this.pet = namepet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public String getOwnerId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    

    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Models;

/**
 *
 * @author User
 */
public class Seller {
    private String idseller;
    private String name;
    private int age;
    private String username;
    private String password;
    private String role;

    public Seller(String idseller, String name, int age, String username, String password) {
        this.idseller = idseller;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = "seller";
    }

    public String getidseller() {
        return idseller;
    }

    public void setId(String idseller) {
        this.idseller = idseller;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSellerId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
   
    
    
}

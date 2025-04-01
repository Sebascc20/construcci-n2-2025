/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package App.Veterinaria.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class AdminEntity {

    @Id // Marca este campo como la clave primaria
    private String idAdmin;

    private String name;
    private String username;
    private String password;
    private int age;

    // Constructor sin parámetros (requerido por JPA)
    public AdminEntity() {
    }

    public AdminEntity(String idAdmin, String name, String username, String password, int age) {
        this.idAdmin = idAdmin;
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // Getters y Setters
    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

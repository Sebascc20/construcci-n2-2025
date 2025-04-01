/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Entities;

/**
 *
 * @author User
 */
import jakarta.persistence.*;
import java.util.List;

@Entity
public class SellerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generador de UUID para IDs únicos
    private String idseller;

    private String name;

    private int age;

    private String username;

    private String password;

    private String role;

    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntity> orders; // Relación uno a muchos con órdenes

    public SellerEntity() {
        this.role = "seller"; // Inicializar el rol por defecto
    }

    public SellerEntity(String idseller, String name, int age, String username, String password) {
        this.idseller = idseller;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.role = "seller";
    }

    // Getters y Setters
    public String getIdseller() {
        return idseller;
    }

    public void setIdseller(String idseller) {
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

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }
}

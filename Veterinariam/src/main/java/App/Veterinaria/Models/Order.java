/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;


public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) 
    private String orderId;
    private Pet idpet;
    private PetOwner idpetowner;
    private Veterinarian idveterinarian;
    private String nameMedication;
    private LocalDateTime time;
    private boolean isCanceled;

    public Order(String orderId, Pet idpet, PetOwner idpetowner, Veterinarian idveterinarian, String nameMedication, LocalDateTime time) {
        this.orderId = orderId;
        this.idpet = idpet;
        this.idpetowner = idpetowner;
        this.idveterinarian = idveterinarian;
        this.nameMedication = nameMedication;
        this.time = time;
        this.isCanceled = false;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Pet getIdpet() {
        return idpet;
    }

    public void setIdpet(Pet idpet) {
        this.idpet = idpet;
    }

    public PetOwner getIdpetowner() {
        return idpetowner;
    }

    public void setIdpetowner(PetOwner idpetowner) {
        this.idpetowner = idpetowner;
    }

    public Veterinarian getIdveterinarian() {
        return idveterinarian;
    }

    public void setIdveterinarian(Veterinarian idveterinarian) {
        this.idveterinarian = idveterinarian;
    }

    public String getNameMedication() {
        return nameMedication;
    }

    public void setNameMedication(String nameMedication) {
        this.nameMedication = nameMedication;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public void cancelOrder() {
        this.isCanceled = true;
    }

}

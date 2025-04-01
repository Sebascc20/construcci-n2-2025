/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class Billing {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Genera un String único automáticamente
    private String idInvoice;
    private Pet idpet;
    private PetOwner idpetowner;
    private Order idorder;
    private String productname;
    private double cost;
    private long amount;
    private LocalDateTime datetoday;

    public Billing(String idInvoice, Pet idpet, PetOwner idpetowner, Order idorder, String productname, double cost, long amount, LocalDateTime datetoday) {
        this.idInvoice = idInvoice;
        this.idpet = idpet;
        this.idpetowner = idpetowner;
        this.idorder = idorder;
        this.productname = productname;
        this.cost = cost;
        this.amount = amount;
        this.datetoday = datetoday;
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
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

    public Order getIdorder() {
        return idorder;
    }

    public void setIdorder(Order idorder) {
        this.idorder = idorder;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDateTime getDatetoday() {
        return datetoday;
    }

    public void setDatetoday(LocalDateTime datetoday) {
        this.datetoday = datetoday;
    }
    
    
}

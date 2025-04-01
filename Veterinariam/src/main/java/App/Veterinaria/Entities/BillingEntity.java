/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package App.Veterinaria.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;

@Entity
public class BillingEntity {

    @Id
    private String billingId;

    private PetEntity petId;
    private PetOwnerEntity ownerId;
    private OrderEntity orderId;

    @Column(nullable = false) // Define restricciones en la base de datos
    private String productName;

    private double cost;

    private int quantity;

    @Temporal(TemporalType.TIMESTAMP) // Define el tipo de columna en la base de datos
    private LocalDateTime billingDate;

    public BillingEntity() {
    }

    public BillingEntity(String billingId, PetEntity petId, PetOwnerEntity ownerId, OrderEntity orderId, String productName, double cost, int quantity, LocalDateTime billingDate) {
        this.billingId = billingId;
        this.petId = petId;
        this.ownerId = ownerId;
        this.orderId = orderId;
        this.productName = productName;
        this.cost = cost;
        this.quantity = quantity;
        this.billingDate = billingDate;
    }

    
}

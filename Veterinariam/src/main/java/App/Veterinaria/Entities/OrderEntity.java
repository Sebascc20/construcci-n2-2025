/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Entities;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generador de UUID para IDs únicos
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    private PetEntity pet;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private PetOwnerEntity petOwner;

    @ManyToOne
    @JoinColumn(name = "vet_id", nullable = false)
    private VeterinarianEntity veterinarian;

    private String nameMedication;

    private LocalDateTime time;
    

    private boolean isCanceled;

    public OrderEntity() {
        this.isCanceled = false; // Por defecto, las órdenes no están canceladas
    }

    public OrderEntity(String orderId, PetEntity pet, PetOwnerEntity petOwner, VeterinarianEntity veterinarian, String nameMedication, LocalDateTime time) {
        this.orderId = orderId;
        this.pet = pet;
        this.petOwner = petOwner;
        this.veterinarian = veterinarian;
        this.nameMedication = nameMedication;
        this.time = time;
        this.isCanceled = false;
    }

    // Getters y Setters
    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public PetOwnerEntity getPetOwner() {
        return petOwner;
    }

    public void setPetOwner(PetOwnerEntity petOwner) {
        this.petOwner = petOwner;
    }

    public VeterinarianEntity getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(VeterinarianEntity veterinarian) {
        this.veterinarian = veterinarian;
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

    public boolean isCanceled() {
        return isCanceled;
    }

    public void cancelOrder() {
        this.isCanceled = true;
    }
   
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package App.Veterinaria.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MedicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String recordId; // ID único del registro

    private LocalDateTime date; // Fecha del registro

    private String reason; // Motivo de consulta
    private String symptoms; // Sintomatología
    private String diagnosis; // Diagnóstico
    private String procedure; // Procedimiento realizado
    private String medication; // Medicamento recetado (si aplica)
    private String medicationDose; // Dosis del medicamento (si aplica)
    private String vaccinationHistory; // Historial de vacunación (si aplica)
    private String allergies; // Medicamentos a los que presenta alergia
    private String procedureDetails; // Detalles del procedimiento
    private Boolean canceled; // Estado de la orden (anulada o activa)

    @ManyToOne
    private PetEntity pet; // Relación con la mascota

    @ManyToOne
    private VeterinarianEntity veterinarian; // Relación con el veterinario

    @OneToOne
    private OrderEntity order; // Relación con la orden de medicamentos

    // Constructor vacío
    public MedicalRecordEntity() {
    }

    
    public MedicalRecordEntity(String recordId, LocalDateTime date, String reason, String diagnosis, String procedure,
            PetEntity pet, VeterinarianEntity veterinarian) {
        this.recordId = recordId;
        this.date = date;
        this.reason = reason;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.pet = pet;
        this.veterinarian = veterinarian;
    }

    // Constructor completo con parámetros extendidos
    public MedicalRecordEntity(String recordId, LocalDateTime date, VeterinarianEntity veterinarian, String reason,
            String symptoms, String diagnosis, String procedure, String medication,
            String medicationDose, OrderEntity order, String vaccinationHistory, String allergies,
            String procedureDetails, Boolean canceled, PetEntity pet) {
        this.recordId = recordId;
        this.date = date;
        this.veterinarian = veterinarian;
        this.reason = reason;
        this.symptoms = symptoms;
        this.diagnosis = diagnosis;
        this.procedure = procedure;
        this.medication = medication;
        this.medicationDose = medicationDose;
        this.order = order;
        this.vaccinationHistory = vaccinationHistory;
        this.allergies = allergies;
        this.procedureDetails = procedureDetails;
        this.canceled = canceled;
        this.pet = pet;
    }

    // Getters y Setters
    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getMedicationDose() {
        return medicationDose;
    }

    public void setMedicationDose(String medicationDose) {
        this.medicationDose = medicationDose;
    }

    public String getVaccinationHistory() {
        return vaccinationHistory;
    }

    public void setVaccinationHistory(String vaccinationHistory) {
        this.vaccinationHistory = vaccinationHistory;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getProcedureDetails() {
        return procedureDetails;
    }

    public void setProcedureDetails(String procedureDetails) {
        this.procedureDetails = procedureDetails;
    }

    public Boolean getCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public PetEntity getPet() {
        return pet;
    }

    public void setPet(PetEntity pet) {
        this.pet = pet;
    }

    public VeterinarianEntity getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(VeterinarianEntity veterinarian) {
        this.veterinarian = veterinarian;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }
}

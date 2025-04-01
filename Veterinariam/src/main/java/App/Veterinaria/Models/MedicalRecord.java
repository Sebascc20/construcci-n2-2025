/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;

/**
 *
 * @author User
 */
public class MedicalRecord {
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDateTime date;
    private Veterinarian veterinarian;
    private String reason;
    private String symptoms;
    private String diagnosis;
    private String procedure;
    private String medication;
    private String medicationDose;
    private Order order;
    private String vaccinationHistory;
    private String allergies;
    private String procedureDetails;
    private Boolean canceled;
    private Pet pet;

    public MedicalRecord(String id, LocalDateTime date, Veterinarian veterinarian, String reason, String symptoms, String diagnosis, String procedure, String medication, String medicationDose, Order order, String vaccinationHistory, String allergies, String procedureDetails, Boolean canceled, Pet pet) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Veterinarian getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(Veterinarian veterinarian) {
        this.veterinarian = veterinarian;
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

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setPetId(String petId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setOwnerName(String get) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getPetId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}

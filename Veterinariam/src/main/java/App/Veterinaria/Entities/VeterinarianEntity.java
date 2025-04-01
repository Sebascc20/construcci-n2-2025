/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package App.Veterinaria.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class VeterinarianEntity {
    @Id
    private String vetId;
    private int age;
    private String name;
    private String username;
    private String password;

    @OneToMany(mappedBy = "veterinarian") // Relación uno a muchos con registros médicos
    private List<MedicalRecordEntity> medicalRecords;

    public VeterinarianEntity() {
    }

    public VeterinarianEntity(String vetId, int age, String name, String username, String password, List<MedicalRecordEntity> medicalRecords) {
        this.vetId = vetId;
        this.age = age;
        this.name = name;
        this.username = username;
        this.password = password;
        this.medicalRecords = medicalRecords;
    }

    public String getVetId() {
        return vetId;
    }

    public void setVetId(String vetId) {
        this.vetId = vetId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public List<MedicalRecordEntity> getMedicalRecords() {
        return medicalRecords;
    }

    public void setMedicalRecords(List<MedicalRecordEntity> medicalRecords) {
        this.medicalRecords = medicalRecords;
    }

    
}

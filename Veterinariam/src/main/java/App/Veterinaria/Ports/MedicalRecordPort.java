/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Ports;

import App.Veterinaria.Models.MedicalRecord;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MedicalRecordPort {

    void createRecord(String petId, MedicalRecord medicalRecord, Map<String, String> petAndOwner);

    List<MedicalRecord> consultRecords(String petId);

    void editRecord(String petId, LocalDateTime date, MedicalRecord updatedRecord);
}

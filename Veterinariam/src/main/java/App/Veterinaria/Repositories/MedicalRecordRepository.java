/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Repositories;

import App.Veterinaria.Models.MedicalRecord;
import java.util.List;

public interface MedicalRecordRepository {

    void save(MedicalRecord medicalRecord); // Guardar un registro médico

    MedicalRecord findById(String recordId); // Buscar un registro por ID

    List<MedicalRecord> findAll(); // Listar todos los registros

    void deleteById(String recordId); // Eliminar un registro por ID
}

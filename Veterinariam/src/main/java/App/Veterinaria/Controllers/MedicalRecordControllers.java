/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Controllers;

import App.Veterinaria.Models.MedicalRecord;
import App.Veterinaria.Ports.MedicalRecordPort;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class MedicalRecordControllers {

    private static final Logger logger = Logger.getLogger(MedicalRecordControllers.class.getName());
    private final MedicalRecordPort medicalRecordPort;

    public MedicalRecordControllers(MedicalRecordPort medicalRecordPort) {
        this.medicalRecordPort = medicalRecordPort;
    }

    // Crear un nuevo registro médico
    public void createRecord(String petId, MedicalRecord medicalRecord, Map<String, String> petAndOwner) {
        logger.info("Iniciando creación de registro médico...");
        if (medicalRecord == null || petAndOwner.isEmpty()) {
            logger.warning("Datos inválidos para crear el registro médico.");
            return;
        }
        try {
            medicalRecordPort.createRecord(petId, medicalRecord, petAndOwner);
            logger.info("Registro médico creado exitosamente.");
        } catch (Exception e) {
            logger.severe("Error al crear el registro médico: " + e.getMessage());
        }
    }

    // Consultar los registros médicos de una mascota
    public void consultRecords(String petId) {
        logger.info("Consultando registros clínicos para la mascota con ID: " + petId);
        List<MedicalRecord> records = medicalRecordPort.consultRecords(petId);
        if (records.isEmpty()) {
            logger.warning("No se encontraron registros para la mascota con ID: " + petId);
        } else {
            for (MedicalRecord record : records) {
                logger.info("Fecha: " + record.getDate() + ", Motivo: " + record.getDiagnosis());
            }
        }
    }

    // Editar un registro médico
    public void editRecord(String petId, LocalDateTime date, MedicalRecord updatedRecord) {
        logger.info("Iniciando edición de registro médico...");
        if (updatedRecord == null) {
            logger.warning("Datos inválidos para editar el registro médico.");
            return;
        }
        try {
            medicalRecordPort.editRecord(petId, date, updatedRecord);
            logger.info("Registro médico editado exitosamente.");
        } catch (Exception e) {
            logger.severe("Error al editar el registro médico: " + e.getMessage());
        }
    }
}



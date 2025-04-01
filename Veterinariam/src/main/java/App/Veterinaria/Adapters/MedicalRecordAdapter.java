/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Models.MedicalRecord;
import App.Veterinaria.Models.Pet;
import App.Veterinaria.Ports.MedicalRecordPort;
import App.Veterinaria.Ports.PetPort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class MedicalRecordAdapter implements MedicalRecordPort {

    private static final Logger logger = Logger.getLogger(MedicalRecordAdapter.class.getName());
    private final Map<String, MedicalRecord> database = new HashMap<>();

    @Autowired
    private PetPort petPort; // Inyecta el puerto para obtener información de mascotas

    public void save(MedicalRecord medicalRecord) {
        database.put(medicalRecord.getId(), medicalRecord);
        logger.info("Registro médico guardado con ID: " + medicalRecord.getId());
    }

   
    public MedicalRecord findById(String recordId) {
        if (recordId == null || recordId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID del registro médico no puede estar vacío.");
        }
        MedicalRecord record = database.get(recordId);
        if (record == null) {
            logger.warning("No se encontró el registro médico con ID: " + recordId);
        }
        return record;
    }

    
    public List<MedicalRecord> findAll() {
        logger.info("Consultando todos los registros médicos...");
        return new ArrayList<>(database.values());
    }

    
    public void deleteById(String recordId) {
        if (database.remove(recordId) != null) {
            logger.info("Registro médico eliminado con ID: " + recordId);
        } else {
            logger.warning("No se encontró el registro médico con ID: " + recordId + " para eliminar.");
        }
    }

    @Override
    public void createRecord(String petId, MedicalRecord medicalRecord, Map<String, String> petAndOwner) {
        if (petId == null || petId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la mascota no puede estar vacío.");
        }

        if (medicalRecord == null) {
            throw new IllegalArgumentException("Error: El registro médico no puede ser nulo.");
        }

        // Usar el puerto para buscar la información completa de la mascota
        Pet pet = petPort.findPetById(petId);
        if (pet == null) {
            throw new IllegalArgumentException("Error: No se encontró la mascota con ID: " + petId);
        }

        // Crear el nuevo registro médico utilizando toda la información proporcionada
        MedicalRecord newRecord = new MedicalRecord(
                medicalRecord.getId(),
                medicalRecord.getDate(),
                medicalRecord.getVeterinarian(),
                medicalRecord.getReason(),
                medicalRecord.getSymptoms(),
                medicalRecord.getDiagnosis(),
                medicalRecord.getProcedure(),
                medicalRecord.getMedication(),
                medicalRecord.getMedicationDose(),
                medicalRecord.getOrder(),
                medicalRecord.getVaccinationHistory(),
                medicalRecord.getAllergies(),
                medicalRecord.getProcedureDetails(),
                medicalRecord.getCanceled(),
                pet // Usar la instancia completa de Pet obtenida del puerto
        );

        save(newRecord);
        logger.info("Registro médico creado exitosamente para la mascota con ID: " + petId);
    }

    @Override
    public List<MedicalRecord> consultRecords(String petId) {
        if (petId == null || petId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la mascota no puede estar vacío.");
        }

        logger.info("Consultando registros médicos para la mascota con ID: " + petId);

        List<MedicalRecord> records = new ArrayList<>();
        for (MedicalRecord record : database.values()) {
            if (petId.equals(record.getPet().getIdpet())) { // Verificar usando el objeto `Pet`
                records.add(record);
            }
        }

        if (records.isEmpty()) {
            logger.warning("No se encontraron registros médicos para la mascota con ID: " + petId);
        }

        return records;
    }

    @Override
    public void editRecord(String petId, LocalDateTime date, MedicalRecord updatedRecord) {
        if (petId == null || petId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la mascota no puede estar vacío.");
        }

        if (updatedRecord == null) {
            throw new IllegalArgumentException("Error: El registro médico actualizado no puede ser nulo.");
        }

        logger.info("Editando registro médico para la mascota con ID: " + petId + " y fecha: " + date);

        boolean recordFound = false;
        for (MedicalRecord record : database.values()) {
            if (petId.equals(record.getPet().getIdpet()) && date.equals(record.getDate())) {
                record.setReason(updatedRecord.getReason());
                record.setSymptoms(updatedRecord.getSymptoms());
                record.setDiagnosis(updatedRecord.getDiagnosis());
                record.setProcedure(updatedRecord.getProcedure());
                record.setMedication(updatedRecord.getMedication());
                record.setMedicationDose(updatedRecord.getMedicationDose());
                record.setOrder(updatedRecord.getOrder());
                record.setVaccinationHistory(updatedRecord.getVaccinationHistory());
                record.setAllergies(updatedRecord.getAllergies());
                record.setProcedureDetails(updatedRecord.getProcedureDetails());
                record.setCanceled(updatedRecord.getCanceled());
                recordFound = true;
                logger.info("Registro médico actualizado exitosamente para la mascota con ID: " + petId);
                break;
            }
        }

        if (!recordFound) {
            throw new IllegalArgumentException("Error: No se encontró un registro médico para la mascota con ID: " + petId + " en la fecha especificada.");
        }
    }
}

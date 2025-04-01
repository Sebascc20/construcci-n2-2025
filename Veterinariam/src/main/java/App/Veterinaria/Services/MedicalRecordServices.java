/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Services;

import App.Veterinaria.Models.MedicalRecord;
import App.Veterinaria.Repositories.MedicalRecordRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordServices  {

    private final Map<String, List<MedicalRecord>> recordsPerPet = new HashMap<>(); // Registros en memoria por mascota
    private final MedicalRecordRepository medicalRecordRepository; 

    // Constructor para inicializar el repositorio
    public MedicalRecordServices(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    // Validar que una mascota esté asociada a un dueño
    public boolean checkPetWithOwner(String petId, Map<String, String> petAndOwnerMap) {
        return petAndOwnerMap.containsKey(petId);
    }

   
    public void createRecord(String petId, MedicalRecord record, Map<String, String> petAndOwnerMap) {
        // Validar asociación de mascota con dueño
        if (!checkPetWithOwner(petId, petAndOwnerMap)) {
            System.out.println("Error: La mascota no está asociada a un dueño registrado.");
            return;
        }

        // Validar que la ID de la orden sea única
        if (record.getOrder() != null && !isIdUniqueOrder(record.getOrder().getOrderId())) {
            System.out.println("Error: La ID de la orden ya existe.");
            return;
        }

        // Guardar en memoria
        recordsPerPet.putIfAbsent(petId, new ArrayList<>());
        recordsPerPet.get(petId).add(record);

        // Guardar en el repositorio
        medicalRecordRepository.save(record);

        System.out.println("Registro clínico creado exitosamente para la mascota con ID: " + petId);
    }

    // Validar que la ID de la orden sea única en todos los registros médicos
    private boolean isIdUniqueOrder(String orderId) {
        return recordsPerPet.values().stream()
                .flatMap(List::stream)
                .noneMatch(record -> record.getOrder() != null && record.getOrder().getOrderId().equals(orderId));
    }

    
    public List<MedicalRecord> consultRecords(String petId) {
        // Consultar registros desde memoria
        return recordsPerPet.getOrDefault(petId, new ArrayList<>());
    }

    
    public void editRecord(String petId, LocalDateTime date, MedicalRecord updatedRecord) {
        // Consultar registros asociados a la mascota
        List<MedicalRecord> records = recordsPerPet.get(petId);
        if (records == null) {
            System.out.println("Error: No se encontraron registros para esta mascota.");
            return;
        }

        // Buscar y actualizar el registro correspondiente
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).getDate().equals(date)) {
                records.set(i, updatedRecord);

                // Actualizar en el repositorio
                medicalRecordRepository.save(updatedRecord);

                System.out.println("Registro clínico actualizado exitosamente.");
                return;
            }
        }

        System.out.println("Error: No se encontró un registro con la fecha especificada.");
    }
}

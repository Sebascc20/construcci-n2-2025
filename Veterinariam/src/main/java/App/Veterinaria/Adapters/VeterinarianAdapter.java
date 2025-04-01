/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Models.Veterinarian;
import App.Veterinaria.Ports.VeterinarianPort;
import App.Veterinaria.Repositories.VeterinarianRepository;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeterinarianAdapter implements VeterinarianPort {

    private final VeterinarianRepository veterinarianRepository;

    @Autowired
    public VeterinarianAdapter(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    public void saveVeterinarian(Veterinarian veterinarian) {
        if (veterinarian == null) {
            throw new IllegalArgumentException("Error: El objeto Veterinarian no puede ser nulo.");
        }
        veterinarianRepository.save(veterinarian); // Guardar veterinario
        System.out.println("Veterinario guardado con ID: " + veterinarian.getVetId());
    }

    public Veterinarian findVeterinarianById(String vetId) {
        if (vetId == null || vetId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID del veterinario no puede estar vacío.");
        }
        Veterinarian veterinarian = veterinarianRepository.findByVetId(vetId);
        if (veterinarian == null) {
            throw new IllegalArgumentException("Error: No se encontró el veterinario con ID: " + vetId);
        }
        return veterinarian;
    }

    public List<Veterinarian> findAllVeterinarians() {
        return veterinarianRepository.findAll(); // Listar todos los veterinarios
    }

    @Override
    public void createVeterinarian(String name, String idVeterinarian, String username, String password) {
        if (Arrays.asList(name, idVeterinarian, username, password).contains(null)
                || name.isEmpty() || idVeterinarian.isEmpty() || username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Error: Los datos del veterinario no pueden estar vacíos.");
        }

        saveVeterinarian(new Veterinarian(idVeterinarian, name, 0, username, password));
        System.out.println("Veterinario creado exitosamente con ID: " + idVeterinarian);
    }

    @Override
    public Iterable<Veterinarian> listVeterinarians() {
        System.out.println("Listando todos los veterinarios...");
        return findAllVeterinarians(); // Reutilizar el método existente
    }

    @Override
    public Veterinarian findById(String vetId) {
        return findVeterinarianById(vetId); // Delegar al método existente
    }
}

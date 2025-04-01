/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Models.PetOwner;
import App.Veterinaria.Ports.OwnerPort;
import App.Veterinaria.Repositories.PetOwnerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetOwnerAdapter implements OwnerPort{

    private final PetOwnerRepository petOwnerRepository;

    public PetOwnerAdapter(PetOwnerRepository petOwnerRepository) {
        this.petOwnerRepository = petOwnerRepository;
    }

    @Override
    public PetOwner findOwnerById(String ownerId) {
        return petOwnerRepository.findById(ownerId).orElse(null); // Buscar dueño por ID
    }

    public List<PetOwner> findAllOwners() {
        return petOwnerRepository.findAll(); // Listar todos los dueños
    }

    public void saveOwner(PetOwner owner) {
        petOwnerRepository.save(owner); // Guardar dueño
        System.out.println("Dueño guardado con ID: " + owner.getOwnerId());
    }

    public PetOwner findOwnerByName(String name) {
        return petOwnerRepository.findByName(name); // Buscar dueño por nombre
    }
}


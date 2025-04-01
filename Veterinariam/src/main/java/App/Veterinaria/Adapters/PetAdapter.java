/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Entities.PetEntity;
import App.Veterinaria.Entities.PetOwnerEntity;
import App.Veterinaria.Models.Pet;
import App.Veterinaria.Models.PetOwner;
import App.Veterinaria.Ports.PetPort;
import App.Veterinaria.Repositories.PetRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetAdapter implements PetPort {

    private final PetRepository petRepository;

    public PetAdapter(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findPetById(String petId) {
        PetEntity petEntity = petRepository.findById(petId).orElse(null);
        return petEntity != null ? convertToPet(petEntity) : null;
    }

    @Override
    public Pet findByName(String name) {
        PetEntity petEntity = petRepository.findByName(name);
        return convertToPet(petEntity);
    }

    @Override
    public List<Pet> findPetsByOwnerId(String ownerId) {
        List<PetEntity> petEntities = petRepository.findByOwnerOwnerId(ownerId);
        return petEntities.stream().map(this::convertToPet).toList();
    }

    private Pet convertToPet(PetEntity petEntity) {

        return new Pet(
                petEntity.getName(),
                convertToDomain(petEntity.getIdpetowner()),
                petEntity.getAge(),
                petEntity.getPetId(),
                petEntity.getSpecie(),
                petEntity.getBreed(),
                petEntity.getCharacteristics(),
                petEntity.getWeight()
        );
    }
    
    public static PetOwner convertToDomain(PetOwnerEntity petOwnerEntity) {
        return new PetOwner(
                petOwnerEntity.getOwnerId(),
                petOwnerEntity.getName(),
                petOwnerEntity.getAge(),
                petOwnerEntity.getRole(), (Pet) petOwnerEntity.getPets());
    }
   
}

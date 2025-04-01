/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Ports;

import App.Veterinaria.Models.Pet;
import java.util.List;

/**
 *
 * @author User
 */
public interface PetPort {

    Pet findPetById(String petId);

    Pet findByName(String name);
  
    List<Pet> findPetsByOwnerId(String ownerId);
}

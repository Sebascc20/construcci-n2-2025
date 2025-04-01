/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Repositories;

import App.Veterinaria.Models.PetOwner;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author User
 */
public interface PetOwnerRepository extends JpaRepository<PetOwner, Object>{

    public PetOwner findByName(String name);

  
    
}

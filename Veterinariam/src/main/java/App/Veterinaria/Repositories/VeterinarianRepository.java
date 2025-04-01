/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Repositories;

/**
 *
 * @author User
 */
import App.Veterinaria.Models.Veterinarian;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, String> {
    Optional<Veterinarian> findByUsername(String username);

    public Veterinarian findByVetId(String vetId);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Repositories;

import App.Veterinaria.Models.Admin;
import App.Veterinaria.Models.Seller;
import App.Veterinaria.Models.Veterinarian;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    boolean existsByUsername(String username); // Verifica si el nombre de usuario existe

    List<Veterinarian> findAllVeterinarians(); // Encuentra todos los veterinarios
    List<Seller> findAllSellers(); // Encuentra todos los vendedores

    public void save(Veterinarian veterinarian);

    public void save(Seller seller);
}

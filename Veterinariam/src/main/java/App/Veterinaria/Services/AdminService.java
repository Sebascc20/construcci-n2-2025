/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Services;

import App.Veterinaria.Models.Admin;
import App.Veterinaria.Models.Seller;
import App.Veterinaria.Models.Veterinarian;
import App.Veterinaria.Repositories.AdminRepository;
import App.Veterinaria.Repositories.SellerRepository;
import App.Veterinaria.Repositories.VeterinarianRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminRepository adminRepository; // Repositorio específico para Admin
    private final VeterinarianRepository veterinarianRepository; // Repositorio específico para Veterinarian
    private final SellerRepository sellerRepository; // Repositorio específico para Seller
    private Admin admin; // Administrador registrado en memoria

    public AdminService(AdminRepository adminRepository,
            VeterinarianRepository veterinarianRepository,
            SellerRepository sellerRepository) {
        this.adminRepository = adminRepository;
        this.veterinarianRepository = veterinarianRepository;
        this.sellerRepository = sellerRepository;
    }
   
    public void createVeterinarian(String name, String idVeterinarian, String username, String password) {
        if (veterinarianRepository.findById(idVeterinarian).isPresent()
                || veterinarianRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Error: Ya existe un veterinario con el mismo ID o nombre de usuario.");
        }
        Veterinarian veterinarian = new Veterinarian(idVeterinarian, name, 0, username, password);
        veterinarianRepository.save(veterinarian);
        System.out.println("Veterinario creado exitosamente con ID: " + idVeterinarian);
    }

   
    public void createSeller(String name, String idSeller, String username, String password) {
        if (sellerRepository.findById(idSeller).isPresent()
                || sellerRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Error: Ya existe un vendedor con el mismo ID o nombre de usuario.");
        }
        Seller seller = new Seller(idSeller, name, 0, username, password);
        sellerRepository.save(seller);
        System.out.println("Vendedor creado exitosamente con ID: " + idSeller);
    }

    
    public List<Veterinarian> listVeterinarians() {
        return veterinarianRepository.findAll();
    }

   
    public List<Seller> listSellers() {
        return sellerRepository.findAll();
    }

    public List<Admin> listAdmins() {
        return adminRepository.findAll(); // Usar método genérico
    }

   
    public void createAdministrator(String name, String idAdmin, String username, String password) {
        if (admin != null) {
            throw new IllegalArgumentException("Error: Ya existe un administrador registrado.");
        }
        admin = new Admin(name, name, 0); 
        System.out.println("Administrador creado exitosamente con ID: " + idAdmin);
    }

   
    public List<Admin> listAdministrators() {
        List<Admin> adminList = adminRepository.findAll(); // Consulta todos los administradores desde el repositorio

        if (adminList.isEmpty()) { // Validar si no hay administradores
            throw new IllegalStateException("No hay administradores registrados.");
        }

        return adminList; 
    }


}

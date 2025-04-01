/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Models.Admin;
import App.Veterinaria.Models.Seller;
import App.Veterinaria.Models.Veterinarian;
import App.Veterinaria.Ports.AdminPort;
import App.Veterinaria.Repositories.AdminRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminAdapter implements AdminPort {

    private final AdminRepository adminRepository;

    public AdminAdapter(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public void createAdministrator(String name, String idAdmin, String username, String password) {
        // Validar si el ID o el nombre de usuario ya existen
        if (adminRepository.existsById(idAdmin)) {
            throw new IllegalArgumentException("Error: Ya existe un administrador con el ID: " + idAdmin);
        }
        if (adminRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Error: Ya existe un administrador con el nombre de usuario: " + username);
        }

        Admin admin = new Admin(name, name, 0);
        adminRepository.save(admin);
        System.out.println("Administrador creado exitosamente con ID: " + idAdmin);
    }

    @Override
    public void createVeterinarian(String name, String idVeterinarian, String username, String password) {
        // Validar si el ID o el nombre de usuario ya existen
        if (adminRepository.existsById(idVeterinarian)) {
            throw new IllegalArgumentException("Error: Ya existe un veterinario con el ID: " + idVeterinarian);
        }
        if (adminRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Error: Ya existe un veterinario con el nombre de usuario: " + username);
        }

        Veterinarian veterinarian = new Veterinarian(idVeterinarian, name, 0, username, password);
        adminRepository.save(veterinarian);
        System.out.println("Veterinario creado exitosamente con ID: " + idVeterinarian);
    }

    @Override
    public void createSeller(String name, String idSeller, String username, String password) {
        // Validar si el ID o el nombre de usuario ya existen
        if (adminRepository.existsById(idSeller)) {
            throw new IllegalArgumentException("Error: Ya existe un vendedor con el ID: " + idSeller);
        }
        if (adminRepository.existsByUsername(username)) {
            throw new IllegalArgumentException("Error: Ya existe un vendedor con el nombre de usuario: " + username);
        }

        Seller seller = new Seller(idSeller, name, 0, username, password);
        adminRepository.save(seller);
        System.out.println("Vendedor creado exitosamente con ID: " + idSeller);
    }

    @Override
    public List<Admin> listAdministrators() {
        return adminRepository.findAll(); // Retorna todos los administradores
    }

    @Override
    public List<Veterinarian> listVeterinarians() {
        return adminRepository.findAllVeterinarians(); // Asume que el repositorio soporta veterinarios
    }

    @Override
    public List<Seller> listSellers() {
        return adminRepository.findAllSellers(); // Asume que el repositorio soporta vendedores
    }
}


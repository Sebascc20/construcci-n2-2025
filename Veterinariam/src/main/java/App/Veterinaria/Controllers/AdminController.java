/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Controllers;

import App.Veterinaria.Models.Admin;
import App.Veterinaria.Models.Seller;
import App.Veterinaria.Models.Veterinarian;
import App.Veterinaria.Ports.AdminPort;
import App.Veterinaria.Ports.SellerPort;
import App.Veterinaria.Ports.VeterinarianPort;

public class AdminController {

    private final VeterinarianPort veterinarianPort;
    private final SellerPort sellerPort;
    private final AdminPort adminPort;

    public AdminController(VeterinarianPort veterinarianPort, SellerPort sellerPort, AdminPort adminPort) {
        this.veterinarianPort = veterinarianPort;
        this.sellerPort = sellerPort;
        this.adminPort = adminPort;
    }

    public void createAdministrator(String name, String idAdmin, String username, String password) {
        adminPort.createAdministrator(name, idAdmin, username, password);
    }

    public void createVeterinarian(String name, String idVeterinarian, String username, String password) {
        veterinarianPort.createVeterinarian(name, idVeterinarian, username, password);
    }

    public void createSeller(String name, String idSeller, String username, String password) {
        sellerPort.createSeller(name, idSeller, username, password);
    }

    public void listAdministrators() {
        System.out.println("Lista de administradores:");
        for (Admin admin : adminPort.listAdministrators()) {
            System.out.println("Nombre: " + admin.getName() + ", Usuario: " + admin.getUsername() + ", Rol: " + admin.getRole());
        }
    }

    public void listVeterinarians() {
        System.out.println("Lista de veterinarios:");
        for (Veterinarian veterinarian : veterinarianPort.listVeterinarians()) {
            System.out.println("Nombre: " + veterinarian.getName() + ", Usuario: " + veterinarian.getUsername() + ", Rol: " + veterinarian.getRole());
        }
    }

    public void listSellers() {
        System.out.println("Lista de vendedores:");
        for (Seller seller : sellerPort.listSellers()) {
            System.out.println("Nombre: " + seller.getName() + ", Usuario: " + seller.getUsername() + ", Rol: " + seller.getRole());
        }
    }
}

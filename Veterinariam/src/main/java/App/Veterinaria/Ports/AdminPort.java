/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Ports;

import App.Veterinaria.Models.Admin;
import App.Veterinaria.Models.Seller;
import App.Veterinaria.Models.Veterinarian;

import java.util.List;

public interface AdminPort {

    void createAdministrator(String name, String idAdmin, String username, String password);

    void createVeterinarian(String name, String idVeterinarian, String username, String password);

    void createSeller(String name, String idSeller, String username, String password);

    List<Admin> listAdministrators();

    List<Veterinarian> listVeterinarians();

    List<Seller> listSellers();
}

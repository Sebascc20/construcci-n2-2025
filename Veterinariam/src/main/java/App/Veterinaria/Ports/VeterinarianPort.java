/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Ports;

import App.Veterinaria.Models.Veterinarian;

/**
 *
 * @author User
 */
public interface VeterinarianPort {

    public void createVeterinarian(String name, String idveterinarian, String username, String password);

    public Iterable<Veterinarian> listVeterinarians();

    public Veterinarian findById(String vetId);
    
}

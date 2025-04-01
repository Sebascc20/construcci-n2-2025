/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Ports;

import App.Veterinaria.Models.Seller;

/**
 *
 * @author User
 */
public interface SellerPort {

    public Iterable<Seller> listSellers();

    public void createSeller(String name, String idSeller, String username, String password);
    
}

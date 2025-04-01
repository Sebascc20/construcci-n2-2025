/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Ports;

import App.Veterinaria.Models.Billing;
import App.Veterinaria.Models.PetOwner;
import java.util.List;

/**
 *
 * @author User
 */
public interface BillingPort {

    void createBilling(String petId,  PetOwner owner, String orderId, String productName,
            double value, int quantity);

    List<Billing> listBillings();

    Billing findBillingById(String billingId);
}

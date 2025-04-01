/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Controllers;

import App.Veterinaria.Models.Billing;
import App.Veterinaria.Models.PetOwner;
import App.Veterinaria.Services.BillingService;



import java.util.List;

public class BillingController {

    private final BillingService billingService;

    public BillingController(BillingService billingService) {
        this.billingService = billingService;
    }

    // Crear una nueva factura
    public void createBilling(String petId, PetOwner ownerId, String orderId, String productName,
            double value, int quantity) {
        System.out.println("Iniciando creación de factura...");
        if (value <= 0 || quantity <= 0) {
            System.out.println("Error: El valor y la cantidad deben ser mayores a 0.");
            return;
        }

        try {
            billingService.createBilling(petId, ownerId, orderId, productName, value, quantity);
        } catch (Exception e) {
            System.out.println("Error al crear la factura: " + e.getMessage());
        }
    }

    // Listar todas las facturas
    public void listBillings() {
        System.out.println("Listado de facturas:");
        List<Billing> billings = billingService.listBillings();
        if (billings.isEmpty()) {
            System.out.println("No se encontraron facturas.");
        } else {
            for (Billing billing : billings) {
                System.out.println("ID Factura: " + billing.getIdInvoice()
                        + ", Producto: " + billing.getProductname()
                        + ", Valor: " + billing.getCost()
                        + ", Cantidad: " + billing.getAmount()
                        + ", Fecha: " + billing.getDatetoday());
            }
        }
    }

    // Buscar factura por ID
    public void findBillingById(String billingId) {
        System.out.println("Buscando factura con ID: " + billingId);
        Billing billing = billingService.findBillingById(billingId);
        if (billing == null) {
            System.out.println("Error: No se encontró la factura con ID: " + billingId);
        } else {
            System.out.println("Detalles de la factura:");
            System.out.println("ID Factura: " + billing.getIdInvoice());
            System.out.println("Mascota: " + billing.getIdpet());
            System.out.println("Dueño: " + billing.getIdpetowner());
            System.out.println("Producto: " + billing.getProductname());
            System.out.println("Valor: " + billing.getCost());
            System.out.println("Cantidad: " + billing.getAmount());
            System.out.println("Fecha: " + billing.getDatetoday());
        }
    }
}

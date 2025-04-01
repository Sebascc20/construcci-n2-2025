/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Repositories;

import App.Veterinaria.Models.Billing;
import java.util.List;



public interface BillingRepository {

    void save(Billing billing); // Guardar una factura

    Billing findById(String idInvoice); // Buscar una factura por su ID

    List<Billing> findAll(); // Listar todas las facturas

    void deleteById(String idInvoice); // Eliminar una factura por su ID
}

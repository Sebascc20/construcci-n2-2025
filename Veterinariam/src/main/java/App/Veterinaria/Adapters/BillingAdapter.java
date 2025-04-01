/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Models.Billing;
import App.Veterinaria.Models.Order;
import App.Veterinaria.Models.Pet;
import App.Veterinaria.Models.PetOwner;
import App.Veterinaria.Ports.BillingPort;
import App.Veterinaria.Ports.PetPort;
import App.Veterinaria.Repositories.BillingRepository;
import App.Veterinaria.Repositories.OrderRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.logging.Logger;

public class BillingAdapter implements BillingPort {

    @Autowired
    private PetPort petPort; // Inyección de dependencias para buscar mascotas

    @Autowired
    private OrderRepository orderRepository; // Repositorio para buscar órdenes

    @Autowired
    private BillingRepository billingRepository; // Repositorio para guardar facturas

    private static final Logger logger = Logger.getLogger(BillingAdapter.class.getName());
    private final Map<String, Billing> database = new HashMap<>();

    public void save(Billing billing) {
        database.put(billing.getIdInvoice(), billing);
        logger.info("Factura guardada con ID: " + billing.getIdInvoice());
    }

    public Billing findById(String idInvoice) {
        Billing billing = database.get(idInvoice);
        if (billing == null) {
            logger.warning("No se encontró la factura con ID: " + idInvoice);
        }
        return billing;
    }

    public List<Billing> findAll() {
        logger.info("Consultando todas las facturas...");
        return new ArrayList<>(database.values());
    }

    public void deleteById(String idInvoice) {
        if (database.remove(idInvoice) != null) {
            logger.info("Factura eliminada con ID: " + idInvoice);
        } else {
            logger.warning("No se encontró la factura con ID: " + idInvoice + " para eliminar");
        }
    }

    @Override
    public void createBilling(String petId, PetOwner owner, String orderId, String productName, double value, int quantity) {
        // Validar los datos de entrada
        if (value <= 0 || quantity <= 0 || productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Error: Los datos de la factura no son válidos.");
        }

        // Crear el ID de la factura
        String idInvoice = UUID.randomUUID().toString();

        // Inicializar objetos necesarios
        Pet idpet = findPetById(petId); // Buscar mascota por ID
        if (idpet == null) {
            throw new IllegalArgumentException("Error: No se encontró la mascota con ID: " + petId);
        }

        Order idorder = findOrderById(orderId); // Buscar orden por ID
        if (idorder == null) {
            throw new IllegalArgumentException("Error: No se encontró la orden con ID: " + orderId);
        }

        // Crear la factura
        Billing billing = new Billing(idInvoice, idpet, owner, idorder, productName, value, quantity, LocalDateTime.now());

        // Guardar la factura
        save(billing);
        logger.info("Factura creada exitosamente con ID: " + idInvoice);
    }

    @Override
    public List<Billing> listBillings() {
        logger.info("Listando todas las facturas...");
        return findAll(); // Reutilizar método findAll
    }

    @Override
    public Billing findBillingById(String billingId) {
        if (billingId == null || billingId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la factura no puede estar vacío.");
        }

        Billing billing = findById(billingId);
        if (billing == null) {
            throw new IllegalArgumentException("Error: No se encontró una factura con ID: " + billingId);
        }
        return billing;
    }

    private Pet findPetById(String petId) {
        if (petId == null || petId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la mascota no puede estar vacío.");
        }

        // Buscar mascota usando el puerto petPort
        Pet pet = petPort.findPetById(petId); // petPort debe estar configurado y funcionando
        if (pet == null) {
            throw new IllegalArgumentException("Error: No se encontró la mascota con ID: " + petId);
        }
        return pet;
    }

    private Order findOrderById(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la orden no puede estar vacío.");
        }

        // Buscar orden usando el repositorio orderRepository
        Order order = orderRepository.findById(orderId); // orderRepository debe estar configurado
        if (order == null) {
            throw new IllegalArgumentException("Error: No se encontró la orden con ID: " + orderId);
        }
        return order;
    }
}


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Services;

import App.Veterinaria.Models.Billing;
import App.Veterinaria.Models.Order;
import App.Veterinaria.Models.Pet;
import App.Veterinaria.Models.PetOwner;
import App.Veterinaria.Ports.BillingPort;
import App.Veterinaria.Ports.OrderPort;
import App.Veterinaria.Ports.OwnerPort;
import App.Veterinaria.Ports.PetPort;
import App.Veterinaria.Repositories.BillingRepository;
import App.Veterinaria.Repositories.OrderRepository;

import org.apache.el.stream.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BillingService implements BillingPort {

    @Autowired
    private OrderRepository orderRepository;

    private final BillingRepository billingRepository;
    private final PetPort petPort;
    private static final Logger logger = Logger.getLogger(BillingService.class.getName());

    public BillingService(BillingRepository billingRepository, PetPort petPort, OwnerPort ownerPort, OrderPort orderPort) {
        this.billingRepository = billingRepository;
        this.petPort = petPort;
    }

    @Override
    public List<Billing> listBillings() {
        logger.info("Listando todas las facturas...");
        List<Billing> billings = billingRepository.findAll();
        if (billings.isEmpty()) {
            logger.warning("No se encontraron facturas registradas.");
        }
        return billings;
    }

    @Override
    public Billing findBillingById(String billingId) {
        logger.log(Level.INFO, "Buscando factura con ID: {0}", billingId);
        Billing billing = billingRepository.findById(billingId);
        if (billing == null) {
            throw new IllegalArgumentException("Error: No se encontró la factura con ID: " + billingId);
        }
        return billing;
    }


    @Override
    public void createBilling(String petId, PetOwner owner, String orderId, String productName, double value, int quantity) {
        logger.info("Iniciando la creación de una nueva factura...");

        // Validar los datos de entrada
        if (value <= 0 || quantity <= 0 || productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Error: Los datos de la factura no son válidos.");
        }

        // Crear el ID único de la factura
        String idInvoice = UUID.randomUUID().toString();

        // Buscar la mascota usando el ID proporcionado
        Pet idpet = findPetById(petId);
        if (idpet == null) {
            throw new IllegalArgumentException("Error: No se encontró la mascota con ID: " + petId);
        }

        // Buscar la orden usando el ID proporcionado
        Order idorder = findOrderById(orderId);
        if (idorder == null) {
            throw new IllegalArgumentException("Error: No se encontró la orden con ID: " + orderId);
        }

        // Crear la factura con los datos proporcionados
        Billing billing = new Billing(idInvoice, idpet, owner, idorder, productName, value, quantity, LocalDateTime.now());

        // Guardar la factura en el repositorio
        billingRepository.save(billing);

        // Registrar el éxito
        logger.log(Level.INFO, "Factura creada exitosamente con ID: {0}", idInvoice);
    }

    private Pet findPetById(String petId) {
        if (petId == null || petId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la mascota no puede estar vacío.");
        }

        // Busca la mascota utilizando el PetPort
        Pet pet = petPort.findPetById(petId);
        if (pet == null) {
            throw new IllegalArgumentException("Error: No se encontró la mascota con ID: " + petId);
        }
        return pet;
    }

    private Order findOrderById(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la orden no puede estar vacío.");
        }

        // Buscar la orden directamente en el repositorio
        Order order = orderRepository.findById(orderId); // Asume que retorna un objeto de tipo Order directamente
        if (order == null) {
            throw new IllegalArgumentException("Error: No se encontró una orden con el ID: " + orderId);
        }
        return order;
    }
}


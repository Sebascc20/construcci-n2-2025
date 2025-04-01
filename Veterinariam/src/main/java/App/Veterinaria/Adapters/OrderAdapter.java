/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Models.Order;
import App.Veterinaria.Models.Veterinarian;
import App.Veterinaria.Ports.OrderPort;
import App.Veterinaria.Ports.VeterinarianPort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderAdapter implements OrderPort {

    private static final Logger logger = Logger.getLogger(OrderAdapter.class.getName());
    private final Map<String, Order> database = new HashMap<>();

    @Autowired
    private VeterinarianPort veterinarianPort; // Inyectar dependencia para manejo de veterinarios

    public void save(Order order) {
        database.put(order.getOrderId(), order);
        logger.info("Orden guardada con ID: " + order.getOrderId());
    }

    @Override
    public Order findById(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la orden no puede estar vacío.");
        }

        Order order = database.get(orderId);
        if (order == null) {
            logger.warning("No se encontró la orden con ID: " + orderId);
        }
        return order;
    }

    public List<Order> findAll() {
        logger.info("Consultando todas las órdenes...");
        return new ArrayList<>(database.values());
    }

    public void deleteById(String orderId) {
        if (database.remove(orderId) != null) {
            logger.info("Orden eliminada con ID: " + orderId);
        } else {
            logger.warning("No se encontró la orden con ID: " + orderId + " para eliminar.");
        }
    }

    @Override
    public void createOrder(Order order, String vetId) {
        if (order == null) {
            throw new IllegalArgumentException("Error: La orden no puede ser nula.");
        }

        if (vetId == null || vetId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID del veterinario no puede estar vacío.");
        }

        // Validar si el veterinario es válido utilizando el puerto correspondiente
        Veterinarian veterinarian = veterinarianPort.findById(vetId);
        if (veterinarian == null) {
            throw new IllegalArgumentException("Error: No se encontró el veterinario con ID: " + vetId);
        }

        // Validar que la orden sea única
        if (database.containsKey(order.getOrderId())) {
            throw new IllegalArgumentException("Error: La orden con ID " + order.getOrderId() + " ya existe.");
        }
        save(order);
        logger.info("Orden creada exitosamente con ID: " + order.getOrderId());
    }

    @Override
    public void cancelOrder(String orderId, String vetId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la orden no puede estar vacío.");
        }

        if (vetId == null || vetId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID del veterinario no puede estar vacío.");
        }

        Order order = findById(orderId);
        if (order == null) {
            throw new IllegalArgumentException("Error: No se encontró la orden con ID: " + orderId);
        }

        // Validar que el veterinario que anula la orden sea el creador de la misma
        if (!vetId.equals(order.getIdveterinarian())) {
            throw new IllegalArgumentException("Error: Solo el veterinario que creó la orden puede anularla.");
        }

        // Cancelar la orden
        order.cancelOrder();
        database.put(orderId, order); // Actualizar el estado de la orden
        logger.info("Orden con ID: " + orderId + " ha sido anulada.");
    }

    @Override
    public List<Order> listOrders() {
        logger.info("Listando todas las órdenes...");
        return findAll(); // Reutilizar el método findAll
    }

    @Override
    public Order findOrderById(String orderId) {
        return findById(orderId); // Delegar a findById
    }
}

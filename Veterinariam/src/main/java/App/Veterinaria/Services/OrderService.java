/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Services;


import App.Veterinaria.Models.Order;
import App.Veterinaria.Ports.OrderPort;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class OrderService implements OrderPort {

    private static final Logger logger = Logger.getLogger(OrderService.class.getName());
    private final Map<String, Order> orders = new HashMap<>();

    @Override
    public void createOrder(Order order, String vetId) {
        logger.info("Iniciando creación de orden...");

        // Validar que la ID de la orden sea única
        if (!isOrderIdUnique(order.getOrderId())) {
            logger.warning("Error: La ID de la orden ya existe.");
            return;
        }

        // Validar que el veterinario asociado sea válido
        if (!validateVeterinarian(order, vetId)) {
            logger.warning("Error: Solo veterinarios pueden generar órdenes.");
            return;
        }

        // Guardar la orden en memoria
        orders.put(order.getOrderId(), order);
        logger.info("Orden creada exitosamente con ID: " + order.getOrderId());
    }

    @Override
    public void cancelOrder(String orderId, String vetId) {
        logger.info("Iniciando anulación de orden...");

        // Buscar la orden por ID
        Order order = findOrderById(orderId);
        if (order == null) {
            logger.warning("Error: No se encontró la orden con ID: " + orderId);
            return;
        }

        // Validar que el veterinario asociado sea el creador de la orden
        if (!vetId.equals(order.getIdveterinarian())) {
            logger.warning("Error: Solo el veterinario que creó la orden puede anularla.");
            return;
        }

        // Cancelar la orden
        order.cancelOrder();
        orders.put(orderId, order); // Actualizar el estado en el almacenamiento
        logger.info("Orden con ID: " + orderId + " ha sido anulada.");
    }

    @Override
    public List<Order> listOrders() {
        logger.info("Consultando listado de órdenes...");
        return new ArrayList<>(orders.values());
    }

    @Override
    public Order findOrderById(String orderId) {
        logger.info("Buscando orden con ID: " + orderId);
        return orders.get(orderId);
    }

    private boolean isOrderIdUnique(String orderId) {
        return !orders.containsKey(orderId);
    }

    private boolean validateVeterinarian(Order order, String vetId) {
        return vetId.equals(order.getIdveterinarian());
    }

    @Override
    public Order findById(String orderId) {
        if (orderId == null || orderId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID de la orden no puede estar vacío.");
        }

        logger.info("Buscando orden con ID: " + orderId);
        Order order = orders.get(orderId);
        if (order == null) {
            logger.warning("No se encontró la orden con ID: " + orderId);
        }
        return order;
    }
}

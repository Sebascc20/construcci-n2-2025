/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Controllers;

import App.Veterinaria.Models.Order;
import App.Veterinaria.Ports.OrderPort;


import java.util.List;
import java.util.logging.Logger;

public class OrderController {

    private static final Logger logger = Logger.getLogger(OrderController.class.getName());
    private final OrderPort orderPort;

    public OrderController(OrderPort orderPort) {
        this.orderPort = orderPort;
    }

    public void createOrder(Order order, String vetId) {
        logger.info("Iniciando creación de orden...");
        if (order == null || vetId == null || vetId.isEmpty()) {
            logger.warning("Datos inválidos para crear la orden.");
            return;
        }
        try {
            orderPort.createOrder(order, vetId);
            logger.info("Orden creada exitosamente.");
        } catch (Exception e) {
            logger.severe("Error al crear la orden: " + e.getMessage());
        }
    }

    public void cancelOrder(String orderId, String vetId) {
        logger.info("Iniciando anulación de orden...");
        if (orderId == null || orderId.isEmpty() || vetId == null || vetId.isEmpty()) {
            logger.warning("Datos inválidos para anular la orden.");
            return;
        }
        try {
            orderPort.cancelOrder(orderId, vetId);
            logger.info("Orden anulada exitosamente.");
        } catch (Exception e) {
            logger.severe("Error al anular la orden: " + e.getMessage());
        }
    }

    public void listOrders() {
        logger.info("Consultando listado de órdenes...");
        List<Order> orders = orderPort.listOrders();
        if (orders.isEmpty()) {
            logger.warning("No hay órdenes registradas.");
        } else {
            for (Order order : orders) {
                logger.info("ID Orden: " + order.getOrderId()
                        + ", Mascota: " + order.getIdpet()
                        + ", Dueño: " + order.getIdpetowner()
                        + ", Veterinario: " + order.getIdveterinarian()
                        + ", Medicamento: " + order.getNameMedication());
            }
        }
    }

    public void findOrderById(String orderId) {
        logger.info("Buscando orden con ID: " + orderId);
        if (orderId == null || orderId.isEmpty()) {
            logger.warning("Datos inválidos para buscar la orden.");
            return;
        }
        Order order = orderPort.findOrderById(orderId);
        if (order == null) {
            logger.warning("No se encontró la orden con ID: " + orderId);
        } else {
            logger.info("Detalles de la orden: ID Orden: " + order.getOrderId()
                    + ", Mascota: " + order.getIdpet()
                    + ", Dueño: " + order.getIdpetowner()
                    + ", Veterinario: " + order.getIdveterinarian()
                    + ", Medicamento: " + order.getNameMedication());
        }
    }
}

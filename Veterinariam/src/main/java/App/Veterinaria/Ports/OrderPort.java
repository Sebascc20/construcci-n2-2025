/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Ports;

import App.Veterinaria.Models.Order;
import java.util.List;

public interface OrderPort {

    Order findById(String orderId);

    // Crear una nueva orden
    void createOrder(Order order, String vetId);

    // Cancelar una orden por ID y veterinario asociado
    void cancelOrder(String orderId, String vetId);

    // Listar todas las órdenes registradas
    List<Order> listOrders();

    // Buscar una orden específica por ID
    Order findOrderById(String orderId);
}

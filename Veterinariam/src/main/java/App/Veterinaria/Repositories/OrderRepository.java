/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Repositories;

import App.Veterinaria.Models.Order;
import java.util.List;

public interface OrderRepository {

    // Guardar una orden en el repositorio
    void save(Order order);

    // Buscar una orden por su ID
     Order findById(String orderId);

    // Listar todas las órdenes almacenadas
    List<Order> findAll();

    // Eliminar una orden por su ID
    void deleteById(String orderId);
}

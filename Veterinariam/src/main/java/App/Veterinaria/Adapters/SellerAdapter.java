/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Adapters;

import App.Veterinaria.Models.Seller;
import App.Veterinaria.Ports.SellerPort;
import App.Veterinaria.Repositories.SellerRepository;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerAdapter implements SellerPort {

    private final SellerRepository sellerRepository;

    @Autowired
    public SellerAdapter(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public void saveSeller(Seller seller) {
        if (seller == null) {
            throw new IllegalArgumentException("Error: El objeto Seller no puede ser nulo.");
        }
        sellerRepository.save(seller); // Guardar vendedor
        System.out.println("Vendedor guardado con ID: " + seller.getSellerId());
    }

    public Seller findSellerById(String sellerId) {
        if (sellerId == null || sellerId.isEmpty()) {
            throw new IllegalArgumentException("Error: El ID del vendedor no puede estar vacío.");
        }
        Seller seller = sellerRepository.findBySellerId(sellerId);
        if (seller == null) {
            throw new IllegalArgumentException("Error: No se encontró el vendedor con ID: " + sellerId);
        }
        return seller;
    }

    public List<Seller> findAllSellers() {
        return sellerRepository.findAll(); // Listar todos los vendedores
    }

    @Override
    public Iterable<Seller> listSellers() {
        return findAllSellers(); // Reutilizar el método existente
    }

    @Override
    public void createSeller(String name, String idSeller, String username, String password) {
        if (Arrays.asList(name, idSeller, username, password).contains(null)
                || name.isEmpty() || idSeller.isEmpty() || username.isEmpty() || password.isEmpty()) {
            throw new IllegalArgumentException("Error: Los datos del vendedor no pueden estar vacíos.");
        }

        saveSeller(new Seller(idSeller, name, 0, username, password));
        System.out.println("Vendedor creado exitosamente con ID: " + idSeller);
    }

  
}

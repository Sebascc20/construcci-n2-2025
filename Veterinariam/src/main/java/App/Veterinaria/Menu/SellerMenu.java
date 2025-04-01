/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Menu;

import java.util.Scanner;

public class SellerMenu {
    private final VeterinarySystem veterinarySystem;

    public SellerMenu(VeterinarySystem veterinarySystem) {
        this.veterinarySystem = veterinarySystem;
    }

    public void displaySellerMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menú del Vendedor ===");
            System.out.println("1. Generar Factura");
            System.out.println("2. Consultar Órdenes");
            System.out.println("3. Regresar al Login");

            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> veterinarySystem.generateInvoice(scanner);
                case "2" -> veterinarySystem.consultOrders(scanner, "seller");
                case "3" -> {
                    System.out.println("Regresando al Login...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}

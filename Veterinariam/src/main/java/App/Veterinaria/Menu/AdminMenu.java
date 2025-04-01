/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Menu;

import java.util.Scanner;

public class AdminMenu {
    private final VeterinarySystem veterinarySystem;

    public AdminMenu(VeterinarySystem veterinarySystem) {
        this.veterinarySystem = veterinarySystem;
    }

    public void displayAdminMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menú del Administrador ===");
            System.out.println("1. Registrar Veterinarios");
            System.out.println("2. Registrar Vendedores");
            System.out.println("3. Registrar Dueños");
            System.out.println("4. Regresar al Login");

            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1" ->
                    veterinarySystem.registerVeterinarian(scanner);
                case "2" ->
                    veterinarySystem.registerSeller(scanner);
                case "3" ->
                    veterinarySystem.registerOwner(scanner);
                case "4" -> {
                    System.out.println("Regresando al Login...");
                    return;
                }
                default ->
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}

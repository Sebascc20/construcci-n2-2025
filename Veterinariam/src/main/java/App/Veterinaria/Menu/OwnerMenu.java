/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Menu;

import java.util.Scanner;

public class OwnerMenu {
    private final VeterinarySystem veterinarySystem;

    public OwnerMenu(VeterinarySystem veterinarySystem) {
        this.veterinarySystem = veterinarySystem;
    }

    public void displayOwnerMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menú del Dueño de Mascotas ===");
            System.out.println("1. Consultar Mascotas");
            System.out.println("2. Regresar al Login");

            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1" -> veterinarySystem.consultPets(scanner);
                case "2" -> {
                    System.out.println("Regresando al Login...");
                    return;
                }
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}

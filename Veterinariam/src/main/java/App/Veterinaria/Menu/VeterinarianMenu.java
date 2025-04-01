/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Menu;

import java.util.Scanner;

public class VeterinarianMenu {
    private final VeterinarySystem veterinarySystem;

    public VeterinarianMenu(VeterinarySystem veterinarySystem) {
        this.veterinarySystem = veterinarySystem;
    }

    public void displayVeterinarianMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menú del Veterinario ===");
            System.out.println("1. Registrar Historia Clínica");
            System.out.println("2. Registrar Mascota");
            System.out.println("3. Crear Orden"); // Opción permitida solo para veterinarios
            System.out.println("4. Anular Orden");
            System.out.println("5. Consultar Historia Clínica");
            System.out.println("6. Consultar Órdenes");
            System.out.println("7. Regresar al Login");

            System.out.print("Seleccione una opción: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1" ->
                    veterinarySystem.registerMedicalRecord(scanner);
                case "2" ->
                    veterinarySystem.registerPet(scanner);
                case "3" ->
                    veterinarySystem.createOrder(scanner, "veterinarian"); // Paso del rol para validación
                case "4" ->
                    veterinarySystem.cancelOrder(scanner, option);
                case "5" ->
                    veterinarySystem.consultMedicalRecord(scanner, "veterinarian");
                case "6" ->
                    veterinarySystem.consultOrders(scanner, "veterinarian");
                case "7" -> {
                    System.out.println("Regresando al Login...");
                    return;
                }
                default ->
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Menu;

import java.util.Scanner;

public class LoginMenu {
    private final VeterinarySystem veterinarySystem;

    public LoginMenu(VeterinarySystem veterinarySystem) {
        this.veterinarySystem = veterinarySystem;
    }

    public void displayLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Inicio de Sesión ===");
            System.out.print("Usuario (o escriba 'salir' para terminar): ");
            String username = scanner.nextLine();

            // Verificar si el usuario desea salir
            if ("salir".equalsIgnoreCase(username)) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            System.out.print("Contraseña: ");
            String password = scanner.nextLine();

            // Verificar si se desea salir con la contraseña
            if ("salir".equalsIgnoreCase(password)) {
                System.out.println("Saliendo del sistema...");
                break;
            }

            String role = veterinarySystem.authenticate(username, password);
            if (role != null) {
                switch (role) {
                    case "admin" ->
                        new AdminMenu(veterinarySystem).displayAdminMenu();
                    case "veterinarian" ->
                        new VeterinarianMenu(veterinarySystem).displayVeterinarianMenu();
                    case "seller" ->
                        new SellerMenu(veterinarySystem).displaySellerMenu();
                    case "owner" ->
                        new OwnerMenu(veterinarySystem).displayOwnerMenu();
                    default ->
                        System.out.println("Rol desconocido.");
                }
            } else {
                System.out.println("Inicio de sesión fallido. Usuario o contraseña incorrectos.");
            }
        }
    }
}

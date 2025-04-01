/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Menu;

import java.util.Scanner;



class VeterinaryApp {

    public static void main(String[] args) {
        VeterinarySystem veterinarySystem = new VeterinarySystem(); // Sistema central de datos

        while (true) {
            System.out.println("\n=== Sistema de Gestión Veterinaria ===");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");

            System.out.print("Seleccione una opción: ");
            String option = new Scanner(System.in).nextLine();

            switch (option) {
                case "1" ->
                    new LoginMenu(veterinarySystem).displayLoginMenu();
                case "2" -> {
                    System.out.println("¡Gracias por usar el sistema! Hasta pronto.");
                    return;
                }
                default ->
                    System.out.println("Opción inválida.");
            }
        }
    }
}

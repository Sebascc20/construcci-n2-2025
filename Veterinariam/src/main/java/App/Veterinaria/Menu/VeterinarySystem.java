/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Veterinaria.Menu;

import App.Veterinaria.Entities.BillingEntity;
import App.Veterinaria.Entities.MedicalRecordEntity;
import App.Veterinaria.Entities.OrderEntity;
import App.Veterinaria.Entities.PetEntity;
import App.Veterinaria.Entities.PetOwnerEntity;
import App.Veterinaria.Entities.SellerEntity;
import App.Veterinaria.Entities.VeterinarianEntity;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;

import java.util.*;

public class VeterinarySystem {

    private final Map<String, VeterinarianEntity> veterinarians = new HashMap<>();
    private final Map<String, SellerEntity> sellers = new HashMap<>();
    private final Map<String, PetOwnerEntity> owners = new HashMap<>();
    private final Map<String, PetEntity> pets = new HashMap<>();
    private final Map<String, Map<LocalDateTime, MedicalRecordEntity>> medicalRecords = new HashMap<>();
    private final Map<String, OrderEntity> orders = new HashMap<>();
    private final Map<String, BillingEntity> invoices = new HashMap<>();
    private final Map<String, String> users = new HashMap<>(); // Usuarios y contraseñas
    private final Map<String, String> roles = new HashMap<>();

    public VeterinarySystem() {
        // Crear usuario administrador por defecto
        users.put("admin", "admin123");
        roles.put("admin", "admin");
    }

    public String authenticate(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return roles.get(username);
        }
        return null;
    }

    public void registerVeterinarian(Scanner scanner) {
        System.out.println("\n=== Registrar Veterinario ===");

        // Solicitar ID del veterinario
        System.out.print("Ingrese la cédula del veterinario: ");
        String id = scanner.nextLine();

        // Verificar si ya existe un veterinario con la misma cédula
        if (veterinarians.containsKey(id)) {
            System.out.println("Error: Ya existe un veterinario registrado con esta cédula.");
            return;
        }

        // Solicitar nombre
        System.out.print("Ingrese el nombre completo del veterinario: ");
        String name = scanner.nextLine();

        // Solicitar edad
        System.out.print("Ingrese la edad del veterinario: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: La edad debe ser un número válido.");
            return;
        }

        // Solicitar nombre de usuario
        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();

        // Solicitar contraseña
        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        // Crear un nuevo objeto VeterinarianEntity
        VeterinarianEntity veterinarian = new VeterinarianEntity();
        veterinarian.setVetId(id);
        veterinarian.setName(name);
        veterinarian.setAge(age);
        veterinarian.setUsername(username);
        veterinarian.setPassword(password);

        // Agregar al almacenamiento en memoria
        veterinarians.put(id, veterinarian);
        users.put(username, password); // Añadir al sistema de autenticación
        roles.put(username, "veterinarian"); // Asociar el rol

        System.out.println("¡Veterinario registrado exitosamente!");
    }

    public void registerSeller(Scanner scanner) {
        System.out.println("\n=== Registrar Vendedor ===");

        // Solicitar ID del vendedor
        System.out.print("Ingrese la cédula del vendedor: ");
        String id = scanner.nextLine();

        // Verificar si ya existe un vendedor con la misma cédula
        if (sellers.containsKey(id)) {
            System.out.println("Error: Ya existe un vendedor registrado con esta cédula.");
            return;
        }

        // Solicitar nombre
        System.out.print("Ingrese el nombre completo del vendedor: ");
        String name = scanner.nextLine();

        // Solicitar edad
        System.out.print("Ingrese la edad del vendedor: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: La edad debe ser un número válido.");
            return;
        }

        // Solicitar nombre de usuario
        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();

        // Verificar si el nombre de usuario ya existe
        if (users.containsKey(username)) {
            System.out.println("Error: El nombre de usuario ya está en uso.");
            return;
        }

        // Solicitar contraseña
        System.out.print("Ingrese la contraseña: ");
        String password = scanner.nextLine();

        // Crear un nuevo objeto SellerEntity
        SellerEntity seller = new SellerEntity();
        seller.setIdseller(id);
        seller.setName(name);
        seller.setAge(age);
        seller.setUsername(username);
        seller.setPassword(password);

        // Agregar al almacenamiento en memoria
        sellers.put(id, seller); // Registrar el vendedor
        users.put(username, password); // Añadir al sistema de autenticación
        roles.put(username, "seller"); // Asociar el rol

        System.out.println("¡Vendedor registrado exitosamente!");
    }

    public void registerOwner(Scanner scanner) {
        System.out.println("\n=== Registrar Dueño de Mascota ===");

        // Solicitar cédula del dueño
        System.out.print("Ingrese la cédula del dueño: ");
        String ownerId = scanner.nextLine();

        // Verificar si ya existe un dueño con la misma cédula
        if (owners.containsKey(ownerId)) {
            System.out.println("Error: Ya existe un dueño registrado con esta cédula.");
            return;
        }

        // Solicitar nombre completo
        System.out.print("Ingrese el nombre completo del dueño: ");
        String name = scanner.nextLine();

        // Solicitar edad
        System.out.print("Ingrese la edad del dueño: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: La edad debe ser un número válido.");
            return;
        }

        // Crear un nuevo objeto OwnerEntity
        PetOwnerEntity owner = new PetOwnerEntity();
        owner.setOwnerId(ownerId);
        owner.setName(name);
        owner.setAge(age);

        // Agregar al almacenamiento en memoria
        owners.put(ownerId, owner); // Registrar el dueño

        System.out.println("¡Dueño registrado exitosamente!");
    }

    public void registerPet(Scanner scanner) {
        System.out.println("\n=== Registrar Mascota ===");

        // Solicitar la cédula del dueño
        System.out.print("Ingrese la cédula del dueño de la mascota: ");
        String ownerId = scanner.nextLine();

        // Validar si el dueño existe en el sistema
        PetOwnerEntity owner = owners.get(ownerId); // Asumimos que `owners` es un mapa que contiene dueños
        if (owner == null) {
            System.out.println("Error: No se encontró un dueño registrado con esta cédula. Registre al dueño primero.");
            return;
        }

        // Solicitar el nombre de la mascota
        System.out.print("Ingrese el nombre de la mascota: ");
        String petName = scanner.nextLine();

        // Solicitar la edad de la mascota
        System.out.print("Ingrese la edad de la mascota (en años): ");
        int petAge;
        try {
            petAge = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: La edad debe ser un número válido.");
            return;
        }

        // Solicitar la especie
        System.out.println("Seleccione la especie de la mascota:");
        System.out.println("1. Perro");
        System.out.println("2. Gato");
        System.out.println("3. Pez");
        System.out.println("4. Ave");
        System.out.print("Opción: ");
        String specieOption = scanner.nextLine();
        String specie;
        switch (specieOption) {
            case "1" ->
                specie = "Perro";
            case "2" ->
                specie = "Gato";
            case "3" ->
                specie = "Pez";
            case "4" ->
                specie = "Ave";
            default -> {
                System.out.println("Opción inválida. Intente nuevamente.");
                return;
            }
        }

        // Solicitar la raza
        System.out.print("Ingrese la raza de la mascota: ");
        String breed = scanner.nextLine();

        // Solicitar las características (color y tamaño)
        System.out.print("Ingrese las características de la mascota (por ejemplo, color y tamaño): ");
        String characteristics = scanner.nextLine();

        // Solicitar el peso de la mascota
        System.out.print("Ingrese el peso de la mascota (en kg): ");
        double weight;
        try {
            weight = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El peso debe ser un número válido.");
            return;
        }

        // Generar un ID único para la mascota
        String petId = "PET-" + System.currentTimeMillis();

        // Crear una nueva instancia de `PetEntity` utilizando el constructor
        PetEntity pet = new PetEntity(
                petName,
                owner, // Relacionar al dueño existente
                petAge,
                petId,
                specie,
                breed,
                characteristics,
                weight
        );

        
        pets.put(petId, pet);

        System.out.println("¡Mascota registrada exitosamente con ID: " + petId + "!");
    }
    
    public void registerMedicalRecord(Scanner scanner) {
        System.out.println("\n=== Registrar Historia Clínica ===");

        // Solicitar ID de la mascota
        System.out.print("Ingrese el ID de la mascota: ");
        String petId = scanner.nextLine();

        // Validar que la mascota exista
        PetEntity pet = pets.get(petId); // Mapa de mascotas
        if (pet == null) {
            System.out.println("Error: No se encontró una mascota registrada con este ID.");
            return;
        }

        // Solicitar ID del veterinario
        System.out.print("Ingrese su ID de veterinario: ");
        String veterinarianId = scanner.nextLine();

        // Validar que el veterinario exista
        VeterinarianEntity veterinarian = veterinarians.get(veterinarianId); // Mapa de veterinarios
        if (veterinarian == null) {
            System.out.println("Error: No se encontró un veterinario registrado con este ID.");
            return;
        }

        // Solicitar información del registro médico
        System.out.print("Motivo de consulta: ");
        String reason = scanner.nextLine();

        System.out.print("Síntomas observados: ");
        String symptoms = scanner.nextLine();

        System.out.print("Diagnóstico: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Procedimiento realizado: ");
        String procedure = scanner.nextLine();

        System.out.print("Medicamento recetado (opcional): ");
        String medication = scanner.nextLine();

        System.out.print("Dosis del medicamento (opcional): ");
        String medicationDose = scanner.nextLine();

        System.out.print("Historial de vacunación (opcional): ");
        String vaccinationHistory = scanner.nextLine();

        System.out.print("Medicamentos con alergias (opcional): ");
        String allergies = scanner.nextLine();

        System.out.print("Detalles del procedimiento (opcional): ");
        String procedureDetails = scanner.nextLine();

        System.out.print("¿La orden asociada ya existe? (sí/no): ");
        String orderExists = scanner.nextLine();

        OrderEntity order = null; // Asociar una orden si existe
        if ("sí".equalsIgnoreCase(orderExists)) {
            System.out.print("Ingrese el ID de la orden asociada: ");
            String orderId = scanner.nextLine();
            order = orders.get(orderId); // Buscar la orden en el mapa de órdenes
            if (order == null) {
                System.out.println("Advertencia: No se encontró una orden con este ID. Continuando sin asociar la orden.");
            }
        }

        // Generar un ID único para el registro clínico
        String recordId = "REC-" + System.currentTimeMillis();

        // Crear el nuevo registro médico
        LocalDateTime date = LocalDateTime.now(); // Fecha actual
        MedicalRecordEntity medicalRecord = new MedicalRecordEntity(
                recordId, // ID único del registro
                date, // Fecha
                veterinarian, // Veterinario asociado
                reason, // Motivo de consulta
                symptoms, // Síntomas
                diagnosis, // Diagnóstico
                procedure, // Procedimiento
                medication, // Medicamento recetado
                medicationDose, // Dosis del medicamento
                order, // Orden asociada (opcional)
                vaccinationHistory, // Historial de vacunación
                allergies, // Medicamentos con alergias
                procedureDetails, // Detalles del procedimiento
                false, // Estado de cancelación inicial
                pet // Mascota asociada
        );

        // Almacenar el registro médico en el mapa
        medicalRecords.putIfAbsent(petId, new HashMap<>());
        medicalRecords.get(petId).put(date, medicalRecord);

        System.out.println("¡Historia clínica registrada exitosamente!");
    }

    public void consultMedicalRecord(Scanner scanner, String currentRole) {
        System.out.println("\n=== Consultar Historia Clínica ===");

        // Validar que el rol actual sea el de médico veterinario
        if (!"veterinarian".equalsIgnoreCase(currentRole)) {
            System.out.println("Error: Solo los médicos veterinarios pueden consultar las historias clínicas.");
            return;
        }

        // Solicitar ID de la mascota
        System.out.print("Ingrese el ID de la mascota: ");
        String petId = scanner.nextLine();

        // Validar que la mascota exista
        PetEntity pet = pets.get(petId); // Mapa que contiene las mascotas registradas
        if (pet == null) {
            System.out.println("Error: No se encontró una mascota registrada con este ID.");
            return;
        }

        // Validar que existan registros médicos para la mascota
        Map<LocalDateTime, MedicalRecordEntity> records = medicalRecords.get(petId); // Mapa de registros médicos por mascota
        if (records == null || records.isEmpty()) {
            System.out.println("No se encontraron registros clínicos para esta mascota.");
            return;
        }

        // Mostrar información general de la mascota
        System.out.println("\n=== Información de la Mascota ===");
        System.out.println("Nombre: " + pet.getName());

        // Validar y obtener el dueño de la mascota
        PetOwnerEntity owner = owners.get(pet.getIdpetowner().getOwnerId());
        if (owner == null) {
            System.out.println("Dueño: No registrado.");
        } else {
            System.out.println("Dueño: " + owner.getName());
        }

        System.out.println("Especie: " + pet.getSpecie());
        System.out.println("Raza: " + pet.getBreed());
        System.out.println("Peso: " + pet.getWeight() + " kg");
        System.out.println("Características: " + pet.getCharacteristics());

        // Mostrar registros médicos
        System.out.println("\n=== Historial Clínico ===");
        for (Map.Entry<LocalDateTime, MedicalRecordEntity> entry : records.entrySet()) {
            LocalDateTime date = entry.getKey();
            MedicalRecordEntity record = entry.getValue();

            System.out.println("\nFecha: " + date);
            System.out.println("Motivo de consulta: " + record.getReason());
            System.out.println("Síntomas: " + record.getSymptoms());
            System.out.println("Diagnóstico: " + record.getDiagnosis());
            System.out.println("Procedimiento realizado: " + record.getProcedure());
            System.out.println("Medicamento recetado: " + record.getMedication());
            System.out.println("Dosis del medicamento: " + record.getMedicationDose());

            // Validar si la orden asociada está presente
            OrderEntity order = record.getOrder();
            if (order == null) {
                System.out.println("ID de la orden: No especificado.");
            } else {
                System.out.println("ID de la orden: " + order.getOrderId());
            }

            System.out.println("Historial de vacunación: " + record.getVaccinationHistory());
            System.out.println("Medicamentos con alergia: " + record.getAllergies());
            System.out.println("Detalles del procedimiento: " + record.getProcedureDetails());

            // Validar si la orden está cancelada
            Boolean isCanceled = record.getCanceled();
            if (isCanceled == null) {
                System.out.println("Estado de la orden: Desconocido.");
            } else {
                System.out.println("Estado de la orden: " + (isCanceled ? "Anulada" : "Activa"));
            }

            System.out.println("-----------------------------------");
        }
    }

    public void createOrder(Scanner scanner, String currentRole) {
        System.out.println("\n=== Crear Orden ===");

        // Validar que el rol actual sea veterinario
        if ("veterinarian".equalsIgnoreCase(currentRole)) {
            System.out.println("Error: Solo los médicos veterinarios pueden crear órdenes.");
            return;
        }

        // Solicitar el ID de la mascota
        System.out.print("Ingrese el ID de la mascota: ");
        String petId = scanner.nextLine();

        // Validar que la mascota exista
        PetEntity pet = pets.get(petId); // Mapa que almacena las mascotas registradas
        if (pet == null) {
            System.out.println("Error: No se encontró una mascota registrada con este ID. Registre la mascota primero.");
            return;
        }

        // Solicitar la cédula del dueño
        System.out.print("Ingrese la cédula del dueño de la mascota: ");
        String ownerId = scanner.nextLine();

        // Validar que el dueño exista y sea el dueño registrado de la mascota
        PetOwnerEntity owner = owners.get(ownerId); // Mapa que almacena los dueños
        if (owner == null || !ownerId.equals(pet.getIdpetowner())) {
            System.out.println("Error: El ID del dueño no coincide con el dueño registrado para esta mascota.");
            return;
        }

        // Solicitar datos del medicamento
        System.out.print("Ingrese el nombre del medicamento recetado: ");
        String medication = scanner.nextLine();

        System.out.print("Ingrese la dosis del medicamento: ");
        String medicationDose = scanner.nextLine();

        // Generar un ID único para la orden
        String orderId = "ORD-" + System.currentTimeMillis();

        // Crear una nueva instancia de OrderEntity utilizando el constructor parametrizado
        OrderEntity order = new OrderEntity(
                orderId, // ID de la orden
                pet, // Mascota asociada
                owner, // Dueño de la mascota
                veterinarians.get(currentRole), // Veterinario que realiza la orden
                medication, // Medicamento recetado
                LocalDateTime.now() // Fecha y hora de creación
        );

        // Almacenar la orden en el sistema
        orders.put(orderId, order); // Mapa que almacena órdenes

        System.out.println("¡Orden creada exitosamente con ID: " + orderId + "!");
    }

    public void cancelOrder(Scanner scanner, String currentRole) {
        System.out.println("\n=== Anular Orden ===");

        // Validar que el rol actual sea veterinario
        if ("veterinarian".equalsIgnoreCase(currentRole)) {
            System.out.println("Error: Solo los médicos veterinarios pueden anular órdenes.");
            return;
        }

        // Solicitar el ID de la orden
        System.out.print("Ingrese el ID de la orden a anular: ");
        String orderId = scanner.nextLine();

        // Validar que la orden exista
        OrderEntity order = orders.get(orderId);
        if (order == null) {
            System.out.println("Error: No se encontró una orden con este ID.");
            return;
        }

        // Validar que la orden no esté ya anulada
        if (order.isCanceled()) {
            System.out.println("Error: Esta orden ya ha sido anulada.");
            return;
        }

        // Marcar la orden como anulada
        order.cancelOrder();

        // Registrar la anulación en la historia clínica
        PetEntity pet = order.getPet(); // Obtener la mascota asociada a la orden
        LocalDateTime cancellationDate = LocalDateTime.now();

        MedicalRecordEntity cancelRecord = new MedicalRecordEntity(
                null, // ID generado automáticamente por la base de datos
                cancellationDate,
                order.getVeterinarian(), // Veterinario que anula la orden
                "Anulación de orden con ID: " + orderId,
                "", // Sintomatología no requerida
                "", // Diagnóstico no requerido
                "Anulación de receta",
                null, // Sin medicamento
                null, // Sin dosis
                order, // Relación con la orden anulada
                null, // Sin historial de vacunación
                "", // Sin alergias
                "La orden fue anulada por el veterinario", // Detalles del procedimiento
                true, // Indicar que la orden fue anulada
                pet // Mascota asociada
        );

        // Registrar la anulación en la historia clínica de la mascota
        medicalRecords.putIfAbsent(pet.getPetId(), new HashMap<>());
        medicalRecords.get(pet.getPetId()).put(cancellationDate, cancelRecord);

        System.out.println("¡Orden con ID " + orderId + " ha sido anulada exitosamente y registrada en la historia clínica!");
    }

    public void generateInvoice(Scanner scanner) {
        System.out.println("\n=== Generar Factura ===");

        // Solicitar el ID de la orden
        System.out.print("Ingrese el ID de la orden: ");
        String orderId = scanner.nextLine();

        // Validar que la orden exista
        OrderEntity order = orders.get(orderId); // Mapa que almacena las órdenes
        if (order == null) {
            System.out.println("Error: No se encontró una orden con este ID.");
            return;
        }

        // Validar que la orden no esté anulada
        if (order.isCanceled()) {
            System.out.println("Error: La orden está anulada y no puede generar una factura.");
            return;
        }

        // Solicitar el precio por unidad del producto
        System.out.print("Ingrese el precio por unidad del producto: ");
        double pricePerUnit;
        try {
            pricePerUnit = Double.parseDouble(scanner.nextLine());
            if (pricePerUnit <= 0) {
                System.out.println("Error: El precio por unidad debe ser mayor a cero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: El precio debe ser un número válido.");
            return;
        }

        // Solicitar la cantidad del producto
        System.out.print("Ingrese la cantidad del producto: ");
        int quantity;
        try {
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity <= 0) {
                System.out.println("Error: La cantidad debe ser mayor a cero.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: La cantidad debe ser un número válido.");
            return;
        }

        // Calcular el precio total
        double totalPrice = pricePerUnit * quantity;

        // Generar un ID único para la factura
        String invoiceId = "INV-" + System.currentTimeMillis();

        // Mostrar detalles de la factura
        System.out.println("\n=== Factura ===");
        System.out.println("ID Factura: " + invoiceId);
        System.out.println("ID Orden: " + order.getOrderId());
        System.out.println("Fecha de Generación: " + LocalDateTime.now());
        System.out.println("ID Mascota: " + order.getPet().getPetId());
        System.out.println("ID Dueño: " + order.getPetOwner().getOwnerId());
        System.out.println("Nombre del Producto: " + order.getNameMedication());
        System.out.println("Precio Unitario: $" + pricePerUnit);
        System.out.println("Cantidad: " + quantity);
        System.out.println("Precio Total: $" + totalPrice);
        System.out.println("Estado: " + (order.isCanceled() ? "Anulada" : "Activa"));

        System.out.println("\nFactura generada exitosamente.");
    }

    public void consultOrders(Scanner scanner, String currentRole) {
        System.out.println("\n=== Consultar Órdenes ===");

        // Verificar el rol actual
        if ("veterinarian".equalsIgnoreCase(currentRole) && !"seller".equalsIgnoreCase(currentRole)) {
            System.out.println("Error: Solo los veterinarios y vendedores pueden consultar las órdenes.");
            return;
        }

        // Si no hay órdenes registradas, mostrar un mensaje
        if (orders.isEmpty()) {
            System.out.println("No hay órdenes registradas en el sistema.");
            return;
        }

        // Mostrar todas las órdenes disponibles
        for (OrderEntity order : orders.values()) {
            System.out.println("\nID Orden: " + order.getOrderId());
            System.out.println("Mascota: " + order.getPet().getName() + " (ID: " + order.getPet().getPetId() + ")");
            System.out.println("Dueño: " + order.getPetOwner().getName() + " (ID: " + order.getPetOwner().getOwnerId() + ")");
            System.out.println("Veterinario: " + order.getVeterinarian().getName() + " (ID: " + order.getVeterinarian().getVetId() + ")");
            System.out.println("Medicamento: " + order.getNameMedication());
            System.out.println("Fecha de Generación: " + order.getTime());
            System.out.println("Estado: " + (order.isCanceled() ? "Anulada" : "Activa"));
            System.out.println("-----------------------------------");
        }

        // Nota adicional para los vendedores
        if ("seller".equalsIgnoreCase(currentRole)) {
            System.out.println("\nNota: Los vendedores solo pueden suministrar medicamentos mediante órdenes activas.");
        }
    }
    
   

   /* private double calculateMedicationPrice(Scanner scanner, String nameMedication, String NameMedication) {
        System.out.println("\n=== Ingresar Precio del Medicamento ===");

        // Solicitar el precio base del medicamento
        System.out.print("Ingrese el precio base del medicamento \"" + nameMedication + "\": ");
        double basePrice;
        try {
            basePrice = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El precio debe ser un número válido.");
            return 0.0;
        }

        // Solicitar el factor de ajuste según la dosis
        System.out.print("Ingrese el factor de ajuste basado en la dosis \"" + NameMedication + "\": ");
        double doseFactor;
        try {
            doseFactor = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: El factor debe ser un número válido.");
            return basePrice; // Devuelve el precio base si hay error
        }

        // Calcular el precio ajustado
        double calculatedPrice = basePrice * doseFactor;
        System.out.println("El precio calculado para el medicamento \"" + nameMedication +  "\" es: $" + calculatedPrice);
        return calculatedPrice;
    }*/

    public void consultPets(Scanner scanner) {
        System.out.println("\n=== Consultar Mascotas por ID del Dueño ===");

        // Solicitar el ID del dueño
        System.out.print("Ingrese el ID del dueño: ");
        String ownerId = scanner.nextLine();

        // Validar si hay mascotas registradas
        if (pets.isEmpty()) {
            System.out.println("No hay mascotas registradas en el sistema.");
            return;
        }

        // Filtrar mascotas por el ID del dueño
        boolean found = false;
        for (PetEntity pet : pets.values()) {
            if (ownerId.equals(pet.getIdpetowner())) {
                // Mostrar información de la mascota
                System.out.println("\nID Mascota: " + pet.getPetId());
                System.out.println("Nombre: " + pet.getName());
                System.out.println("Especie: " + pet.getSpecie());
                System.out.println("Raza: " + pet.getBreed());
                System.out.println("Peso: " + pet.getWeight() + " kg");
                System.out.println("Características: " + pet.getCharacteristics());
                System.out.println("-----------------------------------");
                found = true;
            }
        }

        // Si no se encuentra ninguna mascota para el dueño ingresado
        if (!found) {
            System.out.println("No se encontraron mascotas asociadas con el ID del dueño proporcionado.");
        }
    }
}

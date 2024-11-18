package com.example2;

import javax.persistence.*;
import java.util.List;
import java.util.Scanner;

public class MantenimientoPersona {

    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Inicialización de la EntityManagerFactory
        emf = Persistence.createEntityManagerFactory("objectdb://localhost:6136/mantenimiento-persona.odb");
        em = emf.createEntityManager();

        int opcion;
        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    introducirPersona();
                    break;
                case 2:
                    borrarPersona();
                    break;
                case 3:
                    modificarPersona();
                    break;
                case 4:
                    mostrarPersonas();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        // Cerrar recursos
        em.close();
        emf.close();
    }

    // Mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ ---");
        System.out.println("1. Introducir persona");
        System.out.println("2. Borrar persona");
        System.out.println("3. Modificar persona");
        System.out.println("4. Mostrar todas las personas");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    // Método para introducir una nueva persona
    private static void introducirPersona() {
        System.out.print("Introduzca el nombre: ");
        String nom = scanner.nextLine();
        System.out.print("Introduzca la edad: ");
        int edat = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Introduzca el correo electrónico: ");
        String email = scanner.nextLine();

        Persona persona = new Persona(nom, edat, email);
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
        System.out.println("Persona añadida con éxito.");
    }

    // Método para borrar una persona por nombre
    private static void borrarPersona() {
        System.out.print("Introduzca el nombre de la persona a borrar: ");
        String nom = scanner.nextLine();
        Persona persona = em.find(Persona.class, nom);
        if (persona != null) {
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
            System.out.println("Persona borrada con éxito.");
        } else {
            System.out.println("No se encontró ninguna persona con ese nombre.");
        }
    }

    // Método para modificar una persona
    private static void modificarPersona() {
        System.out.print("Introduzca el nombre de la persona a modificar: ");
        String nom = scanner.nextLine();
        Persona persona = em.find(Persona.class, nom);
        if (persona != null) {
            System.out.print("Nueva edad (dejar en blanco para no modificar): ");
            String edatStr = scanner.nextLine();
            if (!edatStr.isEmpty()) {
                persona.setEdat(Integer.parseInt(edatStr));
            }
            System.out.print("Nuevo correo electrónico (dejar en blanco para no modificar): ");
            String email = scanner.nextLine();
            if (!email.isEmpty()) {
                persona.setEmail(email);
            }

            em.getTransaction().begin();
            em.merge(persona);
            em.getTransaction().commit();
            System.out.println("Persona modificada con éxito.");
        } else {
            System.out.println("No se encontró ninguna persona con ese nombre.");
        }
    }

    // Método para mostrar todas las personas
    private static void mostrarPersonas() {
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p", Persona.class);
        List<Persona> personas = query.getResultList();
        if (personas.isEmpty()) {
            System.out.println("No hay personas registradas.");
        } else {
            for (Persona persona : personas) {
                System.out.println(persona);
            }
        }
    }
}

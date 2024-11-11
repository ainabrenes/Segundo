package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Empleados {

    private static final String URL = "jdbc:sqlite:\\C:\\Users\\alumne-DAM\\Documents\\RepoSegundo\\Segundo\\demo\\src\\main\\java\\com\\example\\empresa.db";

    public static void main(String[] args) {
        createDatabaseAndTable();
        Scanner escaner = new Scanner(System.in);
        int numero;
        do {
            System.out.println("Opciones:");
            System.out.println("1-Introducir datos");
            System.out.println("2-Leer datos");
            System.out.println("3-Salir");
            System.out.print("Selecciona una opción: ");
            numero = escaner.nextInt();

            switch (numero) {
                case 1:
                    introducirDatos(escaner);
                    break;
                case 2:
                    leerDatos();
                    break;
                case 3:
                    System.out.println("Se va a cerrar el programa.");
                    break;
                default:
                    System.out.println("Invalida, prueba de nuevo");
            }
        } while (numero != 3);

        escaner.close();
    }

    private static void createDatabaseAndTable() {
        try (Connection conexion = DriverManager.getConnection(URL)) {
            if (conexion != null) {
                Statement statement = conexion.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS empleados ("
                        + "id INTEGER PRIMARY KEY,"
                        + "nom TEXT,"
                        + "edat INTEGER,"
                        + "correu TEXT)";
                statement.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void introducirDatos(Scanner escaner) {
        try (Connection conexion = DriverManager.getConnection(URL);
            Statement state = conexion.createStatement()) {
            String sql = "INSERT INTO empleados (id, nom, edat, correu) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            String continuar;

            do {
                System.out.print("ID empleado: ");
                int id = escaner.nextInt();
                escaner.nextLine();
                System.out.print("Nombre empleado: ");
                String nom = escaner.nextLine();
                System.out.print("Edad empleado: ");
                int edat = escaner.nextInt();
                escaner.nextLine();
                System.out.print("Correo empleado: ");
                String correu = escaner.nextLine();

                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nom);
                preparedStatement.setInt(3, edat);
                preparedStatement.setString(4, correu);
                preparedStatement.executeUpdate();

                System.out.print("Quieres añadir otro empleado? Si o No: ");
                continuar = escaner.nextLine();
            } while (continuar.equalsIgnoreCase("Si"));

        } catch (SQLException e) {
            System.out.println("Error al insertar los datos: " + e.getMessage());
        }
    }

    private static void leerDatos() {
        try (Connection conexion = DriverManager.getConnection(URL)) {
            String sql = "SELECT * FROM empleados";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Nombre: " + rs.getString("nom")
                        + ", Edad: " + rs.getInt("edat")
                        + ", Correo: " + rs.getString("correu"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }
    }
}

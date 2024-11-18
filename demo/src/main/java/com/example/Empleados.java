import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Empleados {

    // URL de la BBDD
    private static final String URL = "jdbc:sqlite:C:\\Users\\alumne-DAM\\Documents\\RepoSegundo\\Segundo\\demo\\src\\main\\java\\com\\example\\empresa.db";

    public static void main(String[] args) {
        // Crear la base de datos si no existe
        crearBaseDatos();

        // Iniciaz el escaner para leer la eleccion del usuario
        Scanner escaner = new Scanner(System.in);
        int numero;

        // Menu de opciones
        do {
            System.out.println("Opciones:");
            System.out.println("1 - Introducir datos");
            System.out.println("2 - Leer datos");
            System.out.println("3 - Salir");
            System.out.print("Selecciona una opción: ");
            numero = escaner.nextInt();

            // Ejecutar la opcion seleccionada
            switch (numero) {
                case 1:
                    introducirDatos(escaner);  // Introducir datos en la base de datos
                    break;
                case 2:
                    leerDatos();  // Leer y mostrar los datos
                    break;
                case 3:
                    System.out.println("Se va a cerrar el programa.");
                    break;
                default:
                    System.out.println("Opción inválida, prueba de nuevo.");
            }
        } while (numero != 3);  //se repite hasta seleccionar salir

        escaner.close();
    }

    // Crea la base de datos si no existe y crea la tabla de empleados
    private static void crearBaseDatos() {
        // Establecer conexión con la base de datos
        try (Connection conexion = DriverManager.getConnection(URL)) {
            if (conexion != null) {
                // Crear la tabla de empleados
                Statement statement = conexion.createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS empleados ("
                        + "id INTEGER PRIMARY KEY,"
                        + "nom TEXT,"
                        + "edat INTEGER,"
                        + "correu TEXT)";
                statement.execute(sql);  //Crea la tabla
            }
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }

    //Permite introducir los datos de un nuevo empleado en la base de datos.
    private static void introducirDatos(Scanner escaner) {
        // Establecer conexión con la base de datos
        try (Connection conexion = DriverManager.getConnection(URL)) {
            String sql = "INSERT INTO empleados (id, nom, edat, correu) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            String continuar;

            do {
                // Solicitar los datos del empleado al usuario
                System.out.print("ID empleado: ");
                int id = escaner.nextInt();
                escaner.nextLine();  // Limpiar el buffer
                System.out.print("Nombre empleado: ");
                String nom = escaner.nextLine();
                System.out.print("Edad empleado: ");
                int edat = escaner.nextInt();
                escaner.nextLine();
                System.out.print("Correo empleado: ");
                String correu = escaner.nextLine();

                // Asignar los valores a la consulta preparada
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, nom);
                preparedStatement.setInt(3, edat);
                preparedStatement.setString(4, correu);

                //Actualizar la base de datos
                preparedStatement.executeUpdate();

                // Pregunta agregar otro empleado
                System.out.print("¿Quieres añadir otro empleado? (Si/No): ");
                continuar = escaner.nextLine();
            } while (continuar.equalsIgnoreCase("Si"));  // Seguir hasta que el usuario lo decida 

        } catch (SQLException e) {
            System.out.println("Error al insertar los datos: " + e.getMessage());
        }
    }

//Lee y muestra todos los empleados almacenados en la base de datos.
    private static void leerDatos() {
        // Establecer conexión con la base de datos
        try (Connection conexion = DriverManager.getConnection(URL)) {
            String sql = "SELECT * FROM empleados";
            Statement stmt = conexion.createStatement();
            ResultSet rs = stmt.executeQuery(sql);  // Ejecutar la consulta

            // Mostrar los resultados
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id")
                        + ", Nombre: " + rs.getString("nom")
                        + ", Edad: " + rs.getInt("edat")
                        + ", Correo: " + rs.getString("correu"));
            }
        } catch (SQLException e) {
            System.out.println("Error al leer los datos: " + e.getMessage());
        }
    }
}

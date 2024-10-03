package ReadFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Prueba2B {

    public static void main(String[] args) {

        File Original = new File("./Ejemplo1.txt");
        File Copia = new File("./Ejemplo1Copia.txt");

        try {
            if (Original.exists() && Original.getName().endsWith(".txt")) {
                System.out.println("El archivo original es un .txt");

                // Se lee el original
                FileReader fileReader = new FileReader(Original);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Se escribe en el nuevo archivo
                FileWriter fileWriter = new FileWriter(Copia, true);
                
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    fileWriter.write(line); 
                }

                bufferedReader.close();
                fileWriter.close();
                fileReader.close();
                System.out.println("Se creó una copia del archivo.");

                // Se cambian los permisos de la copia
                if (Copia.setWritable(false)) {
                    System.out.println("Se eliminaron los permisos de escritura de la copia.");
                } else {
                    System.out.println("No se pudieron cambiar los permisos de la copia.");
                }

                // Intentar escribir en la copia (debería fallar si los permisos están bien configurados)
                try {
                    FileWriter fileWriter1 = new FileWriter(Copia, true);
                    fileWriter1.write("Intentando escribir después de eliminar permisos."); // Esto debería fallar
                    fileWriter1.close();
                } catch (Exception e) {
                    System.out.println("No se puede escribir en el archivo por restricciones por permisos ");
                }
            } else {
                System.out.println("El archivo original no existe o no es .txt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

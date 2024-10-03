package ReadFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Prueba3B {

    public static void main(String[] args) {
        File originalFile = new File("./Ejemplo2.txt");
        File copiedFile = new File("./Ejemplo2Copia.txt");

        try {
            if (originalFile.exists() && originalFile.getName().endsWith(".txt")) {
                System.out.println("El archivo original es un .txt");

                // Se lee el original
                FileInputStream fileInputStream = new FileInputStream(originalFile);

                // Se escribe en el nuevo archivo
                FileOutputStream fileOutputStream = new FileOutputStream(copiedFile);

                // Buffer de bytes para la transferencia
                byte[] buffer = new byte[1024];
                int bytesRead;

                // Leer y escribir bytes desde el archivo original al archivo de copia
                while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileInputStream.close();
                fileOutputStream.close();
                System.out.println("Se creó una copia del archivo.");

              // Se cambian los permisos de la copia
                if (copiedFile.setWritable(false)) {
                    System.out.println("Se eliminaron los permisos de escritura de la copia.");
                } else {
                    System.out.println("No se pudieron cambiar los permisos de la copia.");
                }

              // Intentar escribir en la copia (debería fallar si los permisos están bien configurados)
                try {
                    FileOutputStream testWrite = new FileOutputStream(copiedFile, true);
                    testWrite.write("Intentando escribir después de eliminar permisos.".getBytes());
                    testWrite.close();
                } catch (IOException e) {
                    System.out.println("No se puede escribir en el archivo por restricciones por permisos.");
                }

            } else {
                System.out.println("El archivo original no existe o no es un archivo .txt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

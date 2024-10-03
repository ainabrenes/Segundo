// package ReadFiles;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.FileWriter;

// public class Prueba2B {

//     public static void main(String[] args) {
//         File fileCopy = new File("./pruebacopia.txt");
//         try {
//             if (fileCopy.getName().endsWith(".txt")) {
//                 System.out.println("El archivo es un .txt");
                
//                 // Lectura del archivo original
//                 FileReader fileReader = new FileReader("./prueba.txt");
//                 BufferedReader bufferedReader = new BufferedReader(fileReader);
//                 if (fileCopy.setWritable(true)){
//                     System.out.println("Se eliminaron los permisos de lectura");
//                     System.out.println("YOU CAN NOT READ FILE");                    
//                 }else{
//                     System.out.println("No se pudieron cambiar los permisos");
//                 }
//                 // Escritura en el nuevo archivo
//                 FileWriter fileWriter = new FileWriter(fileCopy, true);
                
//                 String line;
//                 while ((line = bufferedReader.readLine()) != null) {
//                     fileWriter.write(line); // Escribir cada línea seguida de un salto de línea
//                 }
                
//                 // Cerrar los flujos
//                 bufferedReader.close();
//                 fileWriter.close();
//                 fileReader.close();
//             } else {
//                 System.out.println("El archivo no es .txt");
//             }
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }
// }
package ReadFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Prueba2B {

    public static void main(String[] args) {
        File originalFile = new File("./prueba.txt");
        File fileCopy = new File("./pruebacopia.txt");

        try {
            if (originalFile.exists() && originalFile.getName().endsWith(".txt")) {
                System.out.println("El archivo original es un .txt");

                // Lectura del archivo original
                FileReader fileReader = new FileReader(originalFile);
                BufferedReader bufferedReader = new BufferedReader(fileReader);

                // Escritura en el nuevo archivo
                FileWriter fileWriter = new FileWriter(fileCopy, true);
                
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    fileWriter.write(line + System.lineSeparator()); // Escribir cada línea seguida de un salto de línea
                }
                
                // Cerrar los flujos
                bufferedReader.close();
                fileWriter.close();
                fileReader.close();

                // Cambiar los permisos del archivo original
                if (originalFile.setWritable(false)) {
                    System.out.println("Se eliminaron los permisos de escritura del archivo original.");
                } else {
                    System.out.println("No se pudieron cambiar los permisos del archivo original.");
                }

                // Intentar leer el archivo original (debería fallar si los permisos están correctamente configurados)
                try {
                    FileReader checkReader = new FileReader(originalFile);
                    BufferedReader checkBufferedReader = new BufferedReader(checkReader);
                    while ((line = checkBufferedReader.readLine()) != null) {
                        System.out.println(line);
                    }
                    checkBufferedReader.close();
                } catch (Exception e) {
                    System.out.println("No se puede leer el archivo original debido a permisos: " + e.getMessage());
                }
            } else {
                System.out.println("El archivo original no existe o no es .txt");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

package ActividadAleatoris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class SPU01E02_nom_llinatge {

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("python", "SPU01E02_fill_nom_llinatge.py");
        Process process = null;

        
        try {
            process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            OutputStream outputStream = process.getOutputStream();
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

            String inputLine;

            while (true) {
                System.out.println("Prem Enter per obtenir un nombre aleatori o escriu 'fi' per acabar:");
                inputLine = consoleReader.readLine();

                if ("fi".equalsIgnoreCase(inputLine)) {
                    process.destroy();
                    break;
                }

                outputStream.write("\n".getBytes());
                outputStream.flush();

                String randomNumber = reader.readLine();
                System.out.println("Nombre aleatori: " + randomNumber);
            }

            consoleReader.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }
}

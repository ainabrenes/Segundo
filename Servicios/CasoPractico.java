package Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
public class CasoPractico {


    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);
            
          
            ProcessBuilder process1 = new ProcessBuilder("bash", "-c", "ls -la");
            Process p1 = process1.start();
            
           
            ProcessBuilder process2 = new ProcessBuilder("bash", "-c", "tr 'd' 'D'");
            Process p2 = process2.start();
            
       
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(p1.getInputStream()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        pos.write((line + "\n").getBytes());
                    }
                    pos.close(); // Tancar el pipe
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            
            // Thread per llegir la sortida del pipe i escriure-la a la entrada del segon procés
            new Thread(() -> {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(pis))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        p2.getOutputStream().write((line + "\n").getBytes());
                    }
                    p2.getOutputStream().close(); // Tancar l'output del segon procés
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
            
            // Esperar que els processos acabin
            p1.waitFor();
            p2.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}

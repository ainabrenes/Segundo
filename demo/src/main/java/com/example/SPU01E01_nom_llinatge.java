package com.example;

import java.io.IOException;

public class SPU01E01_nom_llinatge {
    public static void main(String[] args) {
        String command = "cmd.exe"; 
        String[] options = {"/c", "dir"}; 

        String[] commandWithOptions = new String[options.length + 1];
        commandWithOptions[0] = command;
        System.arraycopy(options, 0, commandWithOptions, 1, options.length);
        ProcessBuilder processBuilder = new ProcessBuilder(commandWithOptions);

        try {
            Process process = processBuilder.start(); 
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                System.err.println("S'ha produït un error en executar la comanda. Codi d'error: " + exitCode);
            } else {
                System.out.println("La comanda s'ha executat correctament.");
            }
        } catch (IOException e) {
            System.err.println("Error d'entrada/sortida: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El procés ha estat interromput: " + e.getMessage());
        }
    }
}

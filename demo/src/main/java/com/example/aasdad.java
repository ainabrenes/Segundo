package com.example;

import java.io.IOException;

public class aasdad {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Heu d'especificar una comanda.");
            return;
        }

        String command = args[0];
        String[] options = new String[args.length - 1];
        System.arraycopy(args, 1, options, 0, options.length);

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

package com.ej0;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        
        // Crear un executor amb un pool de 2 fils
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Executar les tasques
        executor.submit(new Task(1));  // Registre d'esdeveniments
        executor.submit(new Task(2));  // Comprovació de l'estat de la xarxa

        // Tancar l'executor
        executor.shutdown();
    }
}
        
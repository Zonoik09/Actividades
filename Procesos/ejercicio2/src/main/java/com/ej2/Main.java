package com.ej2;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Task tasks = new Task();

        String dadesInicials = "Username0";

        // Encadenar las tareas asíncronas
        CompletableFuture<Void> proceso = tasks.validarDatos(dadesInicials)
                .thenApply(dades -> tasks.processarDades(dades))
                .thenAccept(resultat -> tasks.mostrarResposta(resultat));

        // Esperar a que todas las operaciones asíncronas se completen
        proceso.join();
        System.out.println("Proceso completado.");
    }
}
package com.ej2;

import java.util.concurrent.CompletableFuture;

public class Task {
 // Primera tarea: Validación de datos
    public CompletableFuture<String> validarDatos(String datos) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Validando los datos de la solicitud: "+datos);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Datos válidos";
        });
    }

    // Segunda tarea: Procesar los datos
    public String processarDades(String dades) {
        System.out.println("Procesando los datos ...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return dades;
    }

    // Tercera tarea: Mostrar el resultado final
    public void mostrarResposta(String resultat) {
        System.out.println("Resultado: " + resultat);
    }
}

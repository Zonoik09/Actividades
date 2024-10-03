package com.ej1;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main { 
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        ConcurrentHashMap<String, Double> datos = new ConcurrentHashMap<>();

        Runnable tasca1 = Task.task1(datos);
        Runnable tasca2 = Task.task2(datos);
        Callable<Double> tasca3 = Task.task3(datos);

        // Ejecutamos las tascas
        executor.submit(tasca1);
        executor.submit(tasca2);
        Future<Double> resultatFinal = executor.submit(tasca3);

            try {
                System.out.println("Saldo final: " + resultatFinal.get() + " euros");
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        executor.shutdown();
    }
}
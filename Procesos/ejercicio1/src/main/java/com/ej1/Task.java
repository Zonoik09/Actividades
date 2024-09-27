package com.ej1;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;

public class Task {
    public static Runnable task1(ConcurrentHashMap<String, Double> dades) {
        return () -> {
            System.out.println("Tasca 1: Iniciando operación bancaria...");
            dades.put("saldo", 1100.0);
            System.out.println("Saldo inicial introducido: 1100 euros");
        };
    }

    
    public static Runnable task2(ConcurrentHashMap<String, Double> dades) {
        return () -> {
            try {
                Thread.sleep(1000);
                System.out.println("Tasca 2: Calculando nuevo sueldo...");
                Double saldoActual = dades.get("saldo");
                if (saldoActual != null) {
                    Double interessos = saldoActual * 0.05;  
                    dades.put("saldo", saldoActual + interessos);
                    System.out.println("Interes aplicado: 5% -> Saldo actualitzat.");
            }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        };

    }

    public static Callable<Double> task3(ConcurrentHashMap<String, Double> dades) {
        return () -> {
            try {
                Thread.sleep(1500);
                System.out.println("Tasca 3: Llegint el saldo final...");
                return dades.get("saldo");
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        };
    }
}

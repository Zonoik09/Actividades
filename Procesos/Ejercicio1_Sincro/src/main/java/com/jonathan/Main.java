package com.jonathan;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        double[] datos = {10, 12, 23, 23, 16, 23, 21, 16};
        // https://stackoverflow.com/questions/3964211/when-to-use-atomicreference-in-java
        AtomicReference<Double> resultadoFinal = new AtomicReference<>((double) 0);
        AtomicReference<Double> mediaTotal = new AtomicReference<>((double) 0);
        // Creem un CyclicBarrier per a 3 fils
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("Tots els microserveis han acabat. Combinant els resultats...\nResultat: "+resultadoFinal.get());
            }
        });

        // Executor per gestionar els fils
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Tasques que simulen els microserveis
        Runnable sumas = () -> {
            try {
                double suma = 0;
                System.out.println("Procesando datos...Realizando suma...");
                // Simulem un treball
                for (int i = 0; i < datos.length;i++) {
                    suma += datos[i];
                }
                resultadoFinal.set(suma);
                System.out.println("La suma se ha completado.");
                barrier.await(); // Esperem que els altres fils acabin
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Runnable media = () -> {
            try {
                System.out.println("Procesando datos...Realizando media...");
                double operation = resultadoFinal.get()/ datos.length;
                System.out.println(operation);
                mediaTotal.set(operation);
                System.out.println("Media realizada con exito...");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Runnable varianza = () -> {
            try {
                System.out.println("Procesando datos...Realizando desviación standard");
                double sumaDiferencia = 0.0;
                double potenciados = 0;
                double sumaPotenciada = 0;
                for (double dato: datos) {
                    System.out.println(resultadoFinal);
                    sumaDiferencia = 0;
                    potenciados = Math.pow(dato - mediaTotal.get(),2);
                    sumaPotenciada += potenciados;
                }

                resultadoFinal.set(sumaPotenciada);
                System.out.println("Proceso terminado... Desviacion standard terminada.");
                barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        // Executem les tasques
        executor.submit(sumas);
        executor.submit(media);
        executor.submit(varianza);

        // Tanquem l'executor
        executor.shutdown();
    }

}
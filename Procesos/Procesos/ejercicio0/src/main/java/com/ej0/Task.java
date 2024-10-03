package com.ej0;

public class Task implements Runnable {
    private final int taskId;

    public Task(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        try {
            if (taskId == 1) {
                System.out.println("Tasques de registre d'esdeveniments iniciades.");
                Thread.sleep(3000);
                System.out.println("Tasques de registre d'esdeveniments finalitzades.");
            } else if (taskId == 2) {
                System.out.println("Comprovació de l'estat de la xarxa iniciada.");
                Thread.sleep(3000);
                System.out.println("Comprovació de l'estat de la xarxa finalitzada.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


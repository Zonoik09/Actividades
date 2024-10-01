package com.jonathan;

import java.util.concurrent.Semaphore;

public class ParkingLot extends Thread{
    private final Semaphore semaphore;

    public ParkingLot(Semaphore semaphore) { this.semaphore = semaphore; }

    public void start() {
    }
}


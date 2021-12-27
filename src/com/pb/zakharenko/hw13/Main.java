package com.pb.zakharenko.hw13;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;


public class Main {

    static class Producer implements Runnable {
        private final LinkedList <Integer> buffer;

        public Producer(LinkedList<Integer> buffer) {
            this.buffer = buffer;
        }
    @Override
        public void run() {
        String name = Thread.currentThread().getName();
       // System.out.println(name + "Producer is working");
        synchronized (buffer) {
            try {

            if (buffer.size() < 5) {

                System.out.println(name + " try write a message");
                Random rand = new Random();
                int number = rand.nextInt(101);
                buffer.add(number);
                System.out.println("Producer add number "+ number);
                System.out.println("Array:");
                System.out.println(buffer);
                        buffer.notify();
            } else {
                System.out.println(name + " is waiting...");
                buffer.wait(10000);
            }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        }
    }

    static class Subscriber implements Runnable {
        private final LinkedList<Integer> buffer;

        public Subscriber(LinkedList<Integer> buffer) {
            this.buffer = buffer;
        }
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            //System.out.println(name + "Subscriber is working");
            synchronized (buffer) {
                try {

                    if (buffer.size() < 1) {
                        System.out.println(name + " is waiting...");
                        buffer.wait(10000);

                    } else {
                        System.out.println(name + " try read a message");
                        Integer receivedNumber = buffer.pop();
                        System.out.println("Subscriber read number "+ receivedNumber);
                        System.out.println("Array:");
                        System.out.println(buffer);
                        buffer.notify();
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        //LinkedList <Integer> buffer = new LinkedList<>(Arrays.asList(4354,4546,67676,7676,34,65,34)); // Producer is waiting
        LinkedList <Integer> buffer = new LinkedList<>(); // Subscriber is waiting

        Producer producer = new Producer(buffer);
        Subscriber subscriber = new Subscriber(buffer);
for (int i = 0; i < 19; i++) {
    new Thread(producer, "Producer").start();
    new Thread(subscriber, "Subscriber").start();
}
    }

}

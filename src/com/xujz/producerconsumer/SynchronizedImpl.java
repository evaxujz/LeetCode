package com.xujz.producerconsumer;

public class SynchronizedImpl {
    private int[] items = new int[1000];
    private int startIndex = 0, endIndex = 0, count = 0;

    public synchronized void produce(int val) {
        try {
            while(count == 1000) {
                wait();
            }

            items[endIndex] = val;
            count++;
            endIndex = ++endIndex % 1000;
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized int consume() {
        try {
            while(count == 0) {
                wait();
            }

            int val = items[startIndex];
            count--;
            startIndex = ++startIndex % 1000;
            notifyAll();
            return val;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}

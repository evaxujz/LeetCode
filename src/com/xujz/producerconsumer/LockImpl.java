package com.xujz.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LockImpl {
    private int[] items = new int[1000];
    private ReentrantLock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private int startIndex = 0, endIndex = 0, count = 0;

    public void produce(int val) {
        lock.lock();
        try {
            while(count == 1000) {
                notFull.wait();
            }

            items[endIndex] = val;
            count++;
            endIndex = ++endIndex % 1000;
            notEmpty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int consume() {
        lock.lock();
        try {
            while(count == 0) {
                notEmpty.wait();
            }

            int val = items[startIndex];
            count--;
            startIndex = ++startIndex % 1000;
            notFull.signalAll();
            return val;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            lock.unlock();
        }
    }
}

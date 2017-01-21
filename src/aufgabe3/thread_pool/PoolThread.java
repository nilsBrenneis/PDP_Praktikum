/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aufgabe3.thread_pool;

import java.util.concurrent.BlockingQueue;

/**
 * Created by nils on 21.02.13.
 */
class PoolThread extends Thread {

    private BlockingQueue<Runnable> taskQueue = null;
    private boolean isStopped = false;

    public PoolThread(BlockingQueue<Runnable> queue) {
        taskQueue = queue;
    }

    @Override
    public void run() {
        while (!isStopped()) {
            try {
                Runnable runnable = taskQueue.take();
                runnable.run();
            } catch (Exception e) {
                //log or otherwise report exception,
                //but keep pool thread alive.
            }
        }
    }

    public synchronized void halt() {
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }

    private synchronized boolean isStopped() {
        return isStopped;
    }
}

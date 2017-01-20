package aufgabe3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

/**
 * Created by nils on 19.01.17.
 */
public class PrimeResults {
    private final int INIT_PERMITS = 0;
    private final boolean FAIR = true;
    private ConcurrentLinkedQueue<Integer> primesList = new ConcurrentLinkedQueue<>();
    private Semaphore sem = new Semaphore(INIT_PERMITS, FAIR);

    public ConcurrentLinkedQueue<Integer> getPrimesList() {
        return primesList;
    }

    public void addPrime(int p) {
        primesList.add(p);
        sem.release();
    }

    public Iterator<Integer> getNPrimes(int n) throws InterruptedException {
        sem.acquire(n);

        ArrayList<Integer> nPrimes = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            nPrimes.add(primesList.poll());
            primesList.remove(i);
        }

        Iterator itr = nPrimes.iterator();
        return itr;
    }
}

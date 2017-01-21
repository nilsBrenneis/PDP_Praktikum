package aufgabe3;

import aufgabe3.thread_pool.MyThreadPoolExecutor;
import java.util.Iterator;

public class Setup {

	public static void main(String[] args) throws InterruptedException {
		
		// Konstante legen den Wertebereich fest
		final int maxRange = 10000;
		final int segments = 10;
		final int segmentSize = maxRange / segments;
		final int noOfThreads = 4;
		final int maxNoOfTasks = 10;
		final int noOfPrimes = 5;

        MyThreadPoolExecutor mtpe = new MyThreadPoolExecutor(noOfThreads, maxNoOfTasks);
        PrimeResults pr = new PrimeResults();

        // Berechnen der Primzahlen in einzelnen Segmenten
		int startIndex = 0;
		while (startIndex < maxRange) {
			// Teilabschnitt festlegen
			final int endIndex = (startIndex + segmentSize < maxRange) ? startIndex + segmentSize : maxRange;

			// FindPrimeNumbers mit Wertebereich intitialisieren,
			// Primzahlen finden und ausgegeben
			final FindPrimeNumbers pn = new FindPrimeNumbers (startIndex,endIndex, pr);

            //SCHON DA pn.doCalculations();
			//AUFGABE 2 Thread t = new Thread(pn); t.start(); t.join();
			mtpe.execute(pn);

            //SCHON DA System.out.println(pn);
			
			// nächstes Teilsegment in while-Schleife durchlaufen
			startIndex = endIndex;
			
		} // end while

        Iterator<Integer> it = pr.getNPrimes(noOfPrimes);
		while (it.hasNext()) {
		    System.out.println(it.next());
        }
        mtpe.stop();
	}
}

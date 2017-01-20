package aufgabe3;

import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/**
 * 
 * Findet Primzahlen innerhalb eines Wertebereichs
 * zwischen rangeMin und rangeMax 
 *
 */

public class FindPrimeNumbers implements Runnable {

	int rangeMin = 0, rangeMax = 0;
	List<Integer> primes = new LinkedList<Integer>();
    PrimeResults primesResult;
	
	
	public FindPrimeNumbers(int rangeMin, int rangeMax, PrimeResults primesResult) {
		this.rangeMin = rangeMin;
		this.rangeMax = rangeMax;
		this.primesResult = primesResult;
	}

	
	/**
	 *   Berechnet alle Primzahlen zwischen rangeMin und rangeMax
	 *   und speihcert diese in der Liste primes
	 */
	public void doCalculations() {
	
		for (int i = rangeMin; i < rangeMax ; i++) {
			if (isPrime (i)) {
				primes.add( new Integer(i));
                primesResult.addPrime(new Integer(i));
			}
		}
	}

	
	/**
	 * 
	 * @param zahl soll �berpr�ft werden, ob es sich um eine Primzahl handelt
	 * @return true wenn zahl eine Primzahl ist
	 */
	private boolean isPrime (int zahl) {
		 if (zahl < 2) return false; // 2 ist kleinste Primzahl

		 // Prüfe, ob die Zahl durch irgendeine Zahl, die kleiner
		 // ist als diese teilbar ist - keine effiziente Implentierung  ;-)
		 //   
		 int maxTeiler =  (zahl + 2) / 2;
		 for (int potentiellerTeiler = 2; potentiellerTeiler < maxTeiler ; potentiellerTeiler++) {
		    if ((zahl % potentiellerTeiler) == 0) return false;
		   
		 }

		// keinen Teiler gefunden:
		 return true;  
		
		
	}
	
	/*
	 * Gibt alle bislang in primes gespeicherten Zahlen aus.
	 */
	public void printPrimes() {
		Iterator<Integer> i = primes.iterator();
		while (i.hasNext()) { System.out.println(i.next());} 
	}
	
	
	
	public String toString () {
		StringBuffer res = new StringBuffer();
		Iterator<Integer> i = primes.iterator();
		while (i.hasNext()) { res.append(i.next()+",");} 
		if (res.length() > 1) res.deleteCharAt(res.length()-1);
		return res.toString();
	}


	@Override
	public void run() {
		doCalculations();
	}
}

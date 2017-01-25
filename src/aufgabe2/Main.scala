object Main {
    def main(args: Array[String]) {
        val primzahlen = Lst.range(2,100).filter(isPrime)
        println("Die ersten 10 Primzahlen:\t" + primzahlen.takeAsList(10))        
        
        println("\nSumme (foldLeft)  :\t" + primzahlen.foldLeft(0)(_+_))
        var s = 0
        for (x <- primzahlen) {
          s += x
        }
        println("Summe (prozedural):\t" + s)
        
        println("\n\nmap[B] (f: A => B): Lst[B]")
        val incrementedPrimes = primzahlen.map(x => x+1)
        println("..primzahlen + 1:\t\t" + incrementedPrimes.takeAsList(10))
        val doubledPrimes = primzahlen.map(x => 2 * x)
        println("..primzahlen * 2:\t\t" + doubledPrimes.takeAsList(10))

        
        println("\n\nflatMap[B] (f: A => Lst[B]): Lst[B]")
        val flatMapIncrementedPrimes = primzahlen.flatMap(x => Lst(x+1))
        println("..primzahlen + 1:\t\t" + flatMapIncrementedPrimes.takeAsList(10))
        val flatMapDoubledPrimes = primzahlen.flatMap(x => Lst(x*2))
        println("..primzahlen * 2:\t\t" + flatMapDoubledPrimes.takeAsList(10))
        
        
        println("\n\nfilter (p: A => Boolean): Lst[A]")
        val primesGreaterTen = primzahlen.filter(x => x > 10)
        println("..Die ersten Primzahlen größer 10 :\t" + primesGreaterTen.takeAsList(10))
        val primesGreaterFifty = primzahlen.filter(x => x > 50)
        println("..Die ersten Primzahlen größer 50 :\t" + primesGreaterFifty.takeAsList(10))
        
        println("\n\nexists (p: A => Boolean): Boolean")
        println("..Es gibt die Primzahl  5: " + primzahlen.exists(x => x==5))
        println("..Es gibt die Primzahl 19: " + primzahlen.exists(x => x==19))
        println("..Es gibt die Primzahl  6: " + primzahlen.exists(x => x==6))
        println("..Es gibt die Primzahl 20: " + primzahlen.exists(x => x==20))
        
        println("\n\napply (n: Int): A")
        println("..Die dritte Primzahl:  " + primzahlen.apply(3))
        println("..Die achte Primzahl : " + primzahlen.apply(8))
        
        println("\n\n4 Werte:")
        for (i <- 0 until 4) {
          printf("%d: = %3d%n", i, primzahlen(i))
        } 
        
        val products = for { // bei "{" braucht man kein ";"
          x <- Lst.range(3,9,2)
          y <- Lst.range(3,9,2)
          if x*y < 30
        } yield (x,y)
        println();
        for ((x,y) <- products) printf("%2d * %2d < 30%n", x, y)
    }
    
    def isPrime(n: Int): Boolean =
      n == 2 || n % 2 == 1 && Lst.range(3, n-1, 2).forall(n % _ != 0)
}

/**
 * Die Klasse Lst definiert die Methoden der Liste
 */
abstract class Lst[+A] {
  import Lst._
  /*
   * Die Implementierung geschieht durch Knoten vom Typ Option[(A, Lst[A])]
   * a) fuer die leere Liste ist cell = None
   * b) sonst = Some((erstes Element, Restliste))
   * Option ist der gemeinsame Obertyp von None und Some.
   * (x, y) ist ein Tuple, d.h. eine Datenstruktur mit 2 Werten
   */
  /**
   * Ein Listenknoten enthaelt optional ein Tupel (Element, Restliste).
   */
  val cell: Option[(A, Lst[A])]

  def isEmpty: Boolean = cell.isEmpty

  def head: A = cell match {
    case Some((h, t)) => h
    case None         => throw new NoSuchElementException
  }
  def tail: Lst[A] = cell match {
    case Some((h, t)) => t
    case None         => throw new NoSuchElementException
  }

  /**
   * toList wandelt eine Lst in eine "richtige" List um
   * (z.B. fuer die Ausgabe)
   */
  def toList: List[A] = cell match {
    case Some((h, t)) => h :: t.toList
    case None         => Nil
  }

  /**
   * foreach fuehrt die angegebene Aktion (Seiteneffekt!) fuer
   * jedes Element der Liste aus (vgl. for(...)
   */
  def foreach[X](b: A => X): Unit = {
    cell match {
      case Some((h, t)) => b(h); t.foreach(b)
      case None         =>
    }
  }

  /**
   * Erzeugt fuer die ersten n-Elemente eine neue Liste
   * @param n Anzahl
   * @return Liste der ersten n-Elemente
   */
  def takeAsList(n: Int): List[A] = take(n).toList
  
  /**
   * Erzeugt fuer die ersten n-Elemente eine neue Liste
   * @param n Anzahl
   * @return Liste der ersten n-Elemente
   */
  def take(n: Int): Lst[A] = cell match {
    case Some((h, t)) if n > 0 => cons(h, t.take(n - 1))
    case _                     => empty
  }

  /**
   * Beginnend mit z werden alle Elemente der Liste von rechts nach links
   * zusammengefasst.
   * @param z ein 0-Element
   * @param f eine 2-stellige Operation
   * @return Ergebnis der Reduktion aller Elemente
   */
  def foldRight[B](z: => B)(f: (A, B) => B): B =
    cell match {
      case Some((h, t)) => f(h, t.foldRight(z)(f))
      case None         => z
    }

  def append[B >: A](s: Lst[B]): Lst[B] =
    foldRight(s) {
      (a, b) => cons(a, b)
    }

  def forall(p: A => Boolean): Boolean =
    foldRight(true)((a, b) => p(a) && b)
    
  
    
    
    
  /**
   * Eigene Implementierungen
   */
  def foldLeft[B](z: B)(f: (B, A) => B): B =
    cell match {
      case Some((h, t)) => t.foldLeft(f(z, h))(f)
      case None         => z
    }
    
  
  def map[B] (f: A => B): Lst[B] =
    flatMap { x => Lst(f(x)) }
  
    
  def flatMap[B] (f: A => Lst[B]): Lst[B] =
    cell match {
    case Some((h,t)) => f(h).append(t.flatMap(f))
    case None       => empty
    }
  
    
   
  def filter(f: A => Boolean):Lst[A] = 
    foldRight(Lst[A]()){(x, y) => 
      if ( f(x) ) {
        cons(x, y)
      } else {
        y
      }
    }
  
  
  def exists(p: A => Boolean):Boolean =     
    cell match {
      case Some((h,t)) => {
        if (p(h)) {
          true
        } else {
          t.exists(p)
        }
      }
      case None => false
    }
  
  
  def apply (n: Int) : A = 
    cell match {
      case Some((h,t)) => {
        n match {
          case x if x == 0  => h
          case x if x < 0   => throw new IndexOutOfBoundsException
          case _            => t.apply(n-1)
        }
      }
      case None => throw new NoSuchElementException
    }
}



/**
 * Das "Begleiter"-Objekt von Lst
 * Es enthaelt Generator-Funktionen und kann auch beliebige Funktionen
 * enthalten.
 */
object Lst {
  /**
   * Das Objekt der leeren Liste
   * @return leere Liste
   */
  val empty = new Lst[Nothing] { val cell = None } // anonyme Klasse !

  /**
   * Fuegt vor eine Liste ein neues Element:
   * @param hd neues Kopfelement
   * @param tl bestehende Liste
   * @return neue Liste
   */
  def cons[A](hd: A, tl: Lst[A]): Lst[A] =
    new Lst[A] { val cell = Some((hd, tl)) } // anonyme Klasse !

  /**
   * Erzeugt eine Liste mit festgelegten Elementen.
   * (apply-Methoden werden mit Name_des_Objekts(Parameter,..) aufgerufen)
   * Beispiel:
   * <pre>
   * val intLst = Lst(1,2,3)
   * </pre>
   * @param as Listenelemente
   * @return neue Liste
   */
  def apply[A](as: A*): Lst[A] =
    if (as.isEmpty) empty else cons(as.head, apply(as.tail: _*))

  /**
   * Erzeugt eine Liste von ganzen Zahlen
   * @param from Startzahl
   * @param to letzte Zahl
   * @param step Schrittweite (default = 1)
   * @return Zahlenliste
   */
  def range(from: Int, to: Int, step: Int = 1): Lst[Int] =
    if (from <= to) cons(from, range(from + step, to, step)) else empty
}

/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.14.12
 * violet: Intel Core i7 920/2660 MHz, 8 Core(s), 24100 MByte RAM
 **/

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Methoden zur Implementierung mit Pipelines.
 * Der Begriff "einfaches Lambda" bezeichnet Lambda-Ausdruecke ohne Semicolon.
 *
 * @author R. Schiedermeier
 * @version 2018-05-31
 */
public class Loopers {
    /**
     * Zaehlt Strings, die ein bestimmtes Zeichen enthalten.
     * Anforderung: 1 Anweisung; keine Kontrollstrukturen; Einfache Lambdas.
     *
     * @param needleChar Gesuchtes Zeichen.
     * @param collection Sammlung mit Strings. Nicht null, aber Elemente null.
     * @return Anzahl Strings in der Sammlung, in denen das Zeichen vorkommt. Nicht negativ.
     */
    public static long numberWithChar(char needleChar, Collection<String> collection) {

        return collection.stream()
                .peek(x -> System.out.println("before filter " + x))
                .filter(x -> x != null)
                .filter(x -> x.indexOf(needleChar) >= 0)
                .peek(x -> System.out.println("after filter " + x))
                .count();

        //throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Liefert die Primfakoren einer Zahl.
     * Anforderungen: Keine Arrays, keine Collections.
     *
     * @param number Ein Zahl. Nicht negativ.
     * @return Stream der Primfaktoren in aufsteigender Reihenfolge.
     */
    public static Stream<Integer> factorsOf(int number) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Stellt fest, ob alle Strings gleich sind.
     * Anforderung: 1 Anweisung; keine Kontrollstrukturen; Einfache Lambdas.
     *
     * @param strings Strings. Keiner null.
     * @return true wenn der erste und alle weiteren Strings gleich sind; false ansonsten.
     */
    public static boolean allSame(String... strings) {

        return Stream.of(strings)
                .peek(x -> System.out.println("before distinct" + x))
                .distinct()
                .peek(x -> System.out.println("before distinct" + x))
                .count()==1;
    }

    /**
     * Sucht die erste Zahl, die im gegebenen Bereich liegt.
     * Anforderung: 1 Anweisung; keine Kontrollstrukturen; Einfache Lambdas.
     *
     * @param integers Zwei oder mehr Zahlen.
     *                 Die erste legt die Untergrenze des Bereichs fest (inklusive),
     *                 die zweite die Obergrenze (exklusive).
     *                 Die Methode testet alle weitere Zahlen.
     * @return Optional mit der ersten Zahl nach den beiden ersten, die im Bereich liegt.
     * Leeres Optional, wenn es keine gibt.
     */
    public static Optional<Integer> firstInRange(Integer... integers) {

        return Stream.of(integers)
                .filter(x -> x > integers[0])
                .filter(x -> x < integers[1])
                .distinct()
                .findFirst();
//                .filter(x -> x < integers[1]);
    }

    /**
     * Sammelt die unterschiedlichen Primfaktoren von Zahlen und sortiert sie
     * aufsteigend.
     * Anforderung: 1 Anweisung; keine Kontrollstrukturen; Einfache Lambdas.
     *
     * @param stream Zahlen. Keine negativ.
     * @return Stream mit aufsteigenden, unterschiedlichen Primfaktoren.
     */
    public static Stream<Integer> allFactorsAscending(Stream<Integer> stream) {
        throw new UnsupportedOperationException("not implemented yet");
    }

    /**
     * Sucht im gegebenen Bereich die Zahl mit den meisten unterschiedlichen Primfaktoren.
     * Waehlt bei mehreren Kandidaten den kleinsten.
     * Anforderung: 1 Anweisung; keine Kontrollstrukturen; Einfache Lambdas.
     *
     * @param from Untergrenze des Bereichs (inklusive). Nicht negativ.
     * @param upto Obergrenze des Bereichs (exklsuive).
     *             Groesser oder gleich wie die Untergrenze.
     * @return Zahl mit den meisten verschiedenen Primfaktoren.
     */
    public static int mostDifferentFactors(int from, int upto) {
        throw new UnsupportedOperationException("not implemented yet");
    }
}

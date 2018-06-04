/* (C) 2018, R. Schiedermeier, rs@cs.hm.edu
 * Oracle Corporation Java 1.8.0_121, Linux i386 4.14.12
 * violet: Intel Core i7 920/2660 MHz, 8 Core(s), 24100 MByte RAM
 **/
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class LoopersTest {
    @Test public void numberWithCharEmpty() {
        final long want = 0;
        final long have = Loopers.numberWithChar('a', Arrays.asList());
        assertEquals(want, have);
    }

    @Test public void numberWithCharNone() {
        final long want = 0;
        final long have = Loopers.numberWithChar('a', Arrays.asList("xyz", "ijk"));
        assertEquals(want, have);
    }

    @Test public void numberWithCharAll() {
        final long want = 3;
        final long have = Loopers.numberWithChar('a', Arrays.asList("aaa", "a", "fasel"));
        assertEquals(want, have);
    }

    @Test public void numberWithCharSome() {
        final long want = 2;
        final long have = Loopers.numberWithChar('a', Arrays.asList("aaa", "xyz", "fasel"));
        assertEquals(want, have);
    }

    @Test public void numberWithCharNull() {
        final long want = 1;
        final long have = Loopers.numberWithChar('a', Arrays.asList("aaa", "xyz", null));
        assertEquals(want, have);
    }

    //-----------------------------------------------------------------------------------------------
    @Test public void factorsOf1() {
        final Stream<Integer> have = Loopers.factorsOf(1);
        assertElements(have);
    }

    @Test public void factorsOf2() {
        final Stream<Integer> have = Loopers.factorsOf(2);
        assertElements(have, 2);
    }

    @Test public void factorsOf5() {
        final Stream<Integer> have = Loopers.factorsOf(5);
        assertElements(have, 5);
    }

    @Test public void factorsOf6() {
        final Stream<Integer> have = Loopers.factorsOf(6);
        assertElements(have, 2, 3);
    }

    @Test public void factorsOf9() {
        final Stream<Integer> have = Loopers.factorsOf(9);
        assertElements(have, 3, 3);
    }

    //-----------------------------------------------------------------------------------------------
    @Test public void allSameNone() {
        assertFalse(Loopers.allSame());
    }

    @Test public void allSameSingle() {
        assertTrue(Loopers.allSame("blah"));
    }

    @Test public void allSameDifferent() {
        assertFalse(Loopers.allSame("blah", "fasel"));
    }

    @Test public void allSameAllSame() {
        assertTrue(Loopers.allSame("blah", "blah", "blah"));
    }

    @Test public void allSameSomeSame() {
        assertFalse(Loopers.allSame("blah", "fasel", "blah"));
    }

    //-----------------------------------------------------------------------------------------------
    @Test public void firstInRangeNone() {
        final Optional<Integer> want = Optional.empty();
        final Optional<Integer> have = Loopers.firstInRange(10, 20);
        assertEquals(want, have);
    }

    @Test public void firstInRangeEmpty() {
        final Optional<Integer> want = Optional.empty();
        final Optional<Integer> have = Loopers.firstInRange(10, 10, 10);
        assertEquals(want, have);
    }

    @Test public void firstInRangeSingle() {
        final Optional<Integer> want = Optional.of(10);
        final Optional<Integer> have = Loopers.firstInRange(10, 11, 10);
        assertEquals(want, have);
    }

    @Test public void firstInRangeNotFound() {
        final Optional<Integer> want = Optional.empty();
        final Optional<Integer> have = Loopers.firstInRange(10, 20, 21, 22, 8, 9);
        assertEquals(want, have);
    }

    @Test public void firstInRangeFound1() {
        final Optional<Integer> want = Optional.of(11);
        final Optional<Integer> have = Loopers.firstInRange(10, 20, 9, 11, 21);
        assertEquals(want, have);
    }

    @Test public void firstInRangeFoundFirst() {
        final Optional<Integer> want = Optional.of(11);
        final Optional<Integer> have = Loopers.firstInRange(10, 20, 11, 12, 13);
        assertEquals(want, have);
    }

    //-----------------------------------------------------------------------------------------------
    @Test public void allFactorsAscendingNone() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of());
        assertElements(have);
    }

    @Test public void allFactorsAscending1() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(1));
        assertElements(have);
    }

    @Test public void allFactorsAscending2() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(2));
        assertElements(have, 2);
    }

    @Test public void allFactorsAscending2_2() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(2, 2));
        assertElements(have, 2);
    }

    @Test public void allFactorsAscending2_4() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(2, 4));
        assertElements(have, 2);
    }

    @Test public void allFactorsAscending6_2() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(6, 2));
        assertElements(have, 2, 3);
    }

    @Test public void allFactorsAscending6_2_12() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(6, 2, 12));
        assertElements(have, 2, 3);
    }

    @Test public void allFactorsAscending6_2_Some() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(6, 2, 12, 8, 4, 6, 12, 12, 1, 1));
        assertElements(have, 2, 3);
    }

    @Test public void allFactorsAscending6_2_SomeMore() {
        final Stream<Integer> have = Loopers.allFactorsAscending(Stream.of(2 * 3 * 5 * 17, 19 * 23, 7 * 11 * 13));
        assertElements(have, 2, 3, 5, 7, 11, 13, 17, 19, 23);
    }

    //-----------------------------------------------------------------------------------------------
    @Test public void mostDifferentFactors1_2() {
        final long want = 1;
        final long have = Loopers.mostDifferentFactors(1, 2);
        assertEquals(want, have);
    }

    @Test public void mostDifferentFactors1_4() {
        final long want = 2;
        final long have = Loopers.mostDifferentFactors(1, 4);
        assertEquals(want, have);
    }

    @Test public void mostDifferentFactors8_10() {
        final long want = 8;
        final long have = Loopers.mostDifferentFactors(8, 10);
        assertEquals(want, have);
    }

    @Test public void mostDifferentFactors7_30() {
        final long want = 10;
        final long have = Loopers.mostDifferentFactors(7, 30);
        assertEquals(want, have);
    }

    @Test public void mostDifferentFactors100() {
        final long want = 210;
        final long have = Loopers.mostDifferentFactors(100, 500);
        assertEquals(want, have);
    }

    @Test public void mostDifferentFactors1k() {
        final long want = 2310;
        final long have = Loopers.mostDifferentFactors(1000, 5000);
        assertEquals(want, have);
    }

    private static <T> void assertElements(Stream<T> stream, T... elements) {
        assertEquals(Arrays.asList(elements),
                stream.collect(Collectors.toList()));
    }

}

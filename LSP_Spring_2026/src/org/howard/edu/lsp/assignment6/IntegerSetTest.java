package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * JUnit 5 test cases for the IntegerSet class.
 * Tests cover standard behavior and edge cases for all required methods.
 */
public class IntegerSetTest {

    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    // ========== clear() ==========

    @Test
    @DisplayName("clear: removes all elements from a non-empty set")
    void testClear() {
        set1.add(1);
        set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
        assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("clear: calling clear on an already empty set does nothing")
    void testClearOnEmptySet() {
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    // ========== length() ==========

    @Test
    @DisplayName("length: returns 0 for empty set")
    void testLengthEmpty() {
        assertEquals(0, set1.length());
    }

    @Test
    @DisplayName("length: returns correct count after adds")
    void testLengthAfterAdds() {
        set1.add(5);
        set1.add(10);
        set1.add(15);
        assertEquals(3, set1.length());
    }

    @Test
    @DisplayName("length: duplicates do not increase length")
    void testLengthWithDuplicates() {
        set1.add(1);
        set1.add(1);
        set1.add(1);
        assertEquals(1, set1.length());
    }

    // ========== equals() ==========

    @Test
    @DisplayName("equals: identical elements in same order returns true")
    void testEqualsSameOrder() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(1); set2.add(2); set2.add(3);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("equals: identical elements in different order returns true")
    void testEqualsDifferentOrder() {
        set1.add(3); set1.add(1); set1.add(2);
        set2.add(2); set2.add(3); set2.add(1);
        assertTrue(set1.equals(set2));
    }

    @Test
    @DisplayName("equals: different elements returns false")
    void testEqualsDifferentElements() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("equals: different sizes returns false")
    void testEqualsDifferentSizes() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(1); set2.add(2);
        assertFalse(set1.equals(set2));
    }

    @Test
    @DisplayName("equals: two empty sets are equal")
    void testEqualsBothEmpty() {
        assertTrue(set1.equals(set2));
    }

    // ========== contains() ==========

    @Test
    @DisplayName("contains: returns true for existing element")
    void testContainsTrue() {
        set1.add(42);
        assertTrue(set1.contains(42));
    }

    @Test
    @DisplayName("contains: returns false for missing element")
    void testContainsFalse() {
        set1.add(1);
        assertFalse(set1.contains(99));
    }

    @Test
    @DisplayName("contains: returns false on empty set")
    void testContainsEmpty() {
        assertFalse(set1.contains(1));
    }

    // ========== largest() ==========

    @Test
    @DisplayName("largest: returns max from multiple elements")
    void testLargest() {
        set1.add(3); set1.add(7); set1.add(1);
        assertEquals(7, set1.largest());
    }

    @Test
    @DisplayName("largest: works with single element")
    void testLargestSingleElement() {
        set1.add(5);
        assertEquals(5, set1.largest());
    }

    @Test
    @DisplayName("largest: works with negative numbers")
    void testLargestNegatives() {
        set1.add(-10); set1.add(-3); set1.add(-20);
        assertEquals(-3, set1.largest());
    }

    @Test
    @DisplayName("largest: throws on empty set")
    void testLargestEmpty() {
        assertThrows(IllegalStateException.class, () -> set1.largest());
    }

    // ========== smallest() ==========

    @Test
    @DisplayName("smallest: returns min from multiple elements")
    void testSmallest() {
        set1.add(3); set1.add(7); set1.add(1);
        assertEquals(1, set1.smallest());
    }

    @Test
    @DisplayName("smallest: works with single element")
    void testSmallestSingleElement() {
        set1.add(5);
        assertEquals(5, set1.smallest());
    }

    @Test
    @DisplayName("smallest: works with negative numbers")
    void testSmallestNegatives() {
        set1.add(-10); set1.add(-3); set1.add(-20);
        assertEquals(-20, set1.smallest());
    }

    @Test
    @DisplayName("smallest: throws on empty set")
    void testSmallestEmpty() {
        assertThrows(IllegalStateException.class, () -> set1.smallest());
    }

    // ========== add() ==========

    @Test
    @DisplayName("add: element is present after adding")
    void testAdd() {
        set1.add(10);
        assertTrue(set1.contains(10));
    }

    @Test
    @DisplayName("add: duplicate add does not increase size")
    void testAddDuplicate() {
        set1.add(5);
        set1.add(5);
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("add: negative numbers are supported")
    void testAddNegative() {
        set1.add(-7);
        assertTrue(set1.contains(-7));
    }

    // ========== remove() ==========

    @Test
    @DisplayName("remove: element is gone after removal")
    void testRemove() {
        set1.add(1); set1.add(2); set1.add(3);
        set1.remove(2);
        assertFalse(set1.contains(2));
        assertEquals(2, set1.length());
    }

    @Test
    @DisplayName("remove: removing non-existent element does nothing")
    void testRemoveNonExistent() {
        set1.add(1);
        set1.remove(99);
        assertEquals(1, set1.length());
    }

    @Test
    @DisplayName("remove: removing from empty set does nothing")
    void testRemoveFromEmpty() {
        assertDoesNotThrow(() -> set1.remove(1));
    }

    // ========== union() ==========

    @Test
    @DisplayName("union: combines elements from both sets without duplicates")
    void testUnion() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2, 3, 4]", result.toString());
    }

    @Test
    @DisplayName("union: with empty set returns copy of non-empty set")
    void testUnionWithEmpty() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.union(set2);
        assertEquals("[1, 2]", result.toString());
    }

    @Test
    @DisplayName("union: two empty sets returns empty set")
    void testUnionBothEmpty() {
        IntegerSet result = set1.union(set2);
        assertEquals("[]", result.toString());
    }

    @Test
    @DisplayName("union: does not modify original sets")
    void testUnionDoesNotModify() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        set1.union(set2);
        assertEquals("[1, 2]", set1.toString());
        assertEquals("[3, 4]", set2.toString());
    }

    // ========== intersect() ==========

    @Test
    @DisplayName("intersect: returns common elements")
    void testIntersect() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.intersect(set2);
        assertEquals("[2, 3]", result.toString());
    }

    @Test
    @DisplayName("intersect: disjoint sets returns empty")
    void testIntersectDisjoint() {
        set1.add(1); set1.add(2);
        set2.add(3); set2.add(4);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("intersect: with empty set returns empty")
    void testIntersectWithEmpty() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.intersect(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("intersect: does not modify original sets")
    void testIntersectDoesNotModify() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.intersect(set2);
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[2, 3, 4]", set2.toString());
    }

    // ========== diff() ==========

    @Test
    @DisplayName("diff: returns elements in set1 but not set2")
    void testDiff() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.diff(set2);
        assertEquals("[1]", result.toString());
    }

    @Test
    @DisplayName("diff: identical sets returns empty")
    void testDiffIdentical() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2);
        IntegerSet result = set1.diff(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("diff: with empty set returns copy of original")
    void testDiffWithEmpty() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.diff(set2);
        assertEquals("[1, 2]", result.toString());
    }

    @Test
    @DisplayName("diff: does not modify original sets")
    void testDiffDoesNotModify() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.diff(set2);
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[2, 3, 4]", set2.toString());
    }

    // ========== complement() ==========

    @Test
    @DisplayName("complement: returns elements in set2 but not set1")
    void testComplement() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        IntegerSet result = set1.complement(set2);
        assertEquals("[4]", result.toString());
    }

    @Test
    @DisplayName("complement: identical sets returns empty")
    void testComplementIdentical() {
        set1.add(1); set1.add(2);
        set2.add(1); set2.add(2);
        IntegerSet result = set1.complement(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("complement: with empty set2 returns empty")
    void testComplementEmptyB() {
        set1.add(1); set1.add(2);
        IntegerSet result = set1.complement(set2);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("complement: does not modify original sets")
    void testComplementDoesNotModify() {
        set1.add(1); set1.add(2); set1.add(3);
        set2.add(2); set2.add(3); set2.add(4);
        set1.complement(set2);
        assertEquals("[1, 2, 3]", set1.toString());
        assertEquals("[2, 3, 4]", set2.toString());
    }

    // ========== isEmpty() ==========

    @Test
    @DisplayName("isEmpty: new set is empty")
    void testIsEmptyTrue() {
        assertTrue(set1.isEmpty());
    }

    @Test
    @DisplayName("isEmpty: set with elements is not empty")
    void testIsEmptyFalse() {
        set1.add(1);
        assertFalse(set1.isEmpty());
    }

    @Test
    @DisplayName("isEmpty: set is empty after clearing")
    void testIsEmptyAfterClear() {
        set1.add(1); set1.add(2);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    // ========== toString() ==========

    @Test
    @DisplayName("toString: empty set returns []")
    void testToStringEmpty() {
        assertEquals("[]", set1.toString());
    }

    @Test
    @DisplayName("toString: single element")
    void testToStringSingle() {
        set1.add(42);
        assertEquals("[42]", set1.toString());
    }

    @Test
    @DisplayName("toString: elements appear in ascending order")
    void testToStringSorted() {
        set1.add(3); set1.add(1); set1.add(2);
        assertEquals("[1, 2, 3]", set1.toString());
    }

    @Test
    @DisplayName("toString: negative numbers sort correctly")
    void testToStringNegatives() {
        set1.add(2); set1.add(-5); set1.add(0); set1.add(-1);
        assertEquals("[-5, -1, 0, 2]", set1.toString());
    }
}
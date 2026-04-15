package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A class that models a mathematical set of integers.
 * The set does not allow duplicate elements and supports
 * standard set operations such as union, intersection,
 * difference, and complement.
 *
 * @author Rodak
 */
public class IntegerSet {

    /** Internal storage for set elements. */
    private ArrayList<Integer> set;

    /**
     * Constructs an empty IntegerSet.
     */
    public IntegerSet() {
        set = new ArrayList<>();
    }

    /**
     * Removes all elements from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return the size of the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Checks whether two sets contain exactly the same elements,
     * regardless of order.
     *
     * @param b the IntegerSet to compare with
     * @return true if both sets contain the same elements
     */
    public boolean equals(IntegerSet b) {
        if (this.length() != b.length()) {
            return false;
        }

        ArrayList<Integer> sortedThis = new ArrayList<>(this.set);
        ArrayList<Integer> sortedB = new ArrayList<>(b.set);
        Collections.sort(sortedThis);
        Collections.sort(sortedB);

        return sortedThis.equals(sortedB);
    }

    /**
     * Checks whether the set contains a specific value.
     *
     * @param value the integer to search for
     * @return true if the set contains the value
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest element in the set.
     *
     * @return the largest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("The set is empty.");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest element in the set.
     *
     * @return the smallest integer in the set
     * @throws IllegalStateException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IllegalStateException("The set is empty.");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set. If the item is not present,
     * the set is unchanged.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and the given set.
     * Contains all elements that appear in either set.
     * Does not modify the original sets.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the union
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);

        for (int item : intSetb.set) {
            if (!result.set.contains(item)) {
                result.set.add(item);
            }
        }

        return result;
    }

    /**
     * Returns a new set that is the intersection of this set and the given set.
     * Contains only elements common to both sets.
     * Does not modify the original sets.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the intersection
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        result.set.retainAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in the given set.
     * Does not modify the original sets.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the difference (this - b)
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(this.set);
        result.set.removeAll(intSetb.set);
        return result;
    }

    /**
     * Returns a new set containing elements in the given set but not in this set.
     * Does not modify the original sets.
     *
     * @param intSetb the other IntegerSet
     * @return a new IntegerSet representing the complement (b - this)
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();
        result.set.addAll(intSetb.set);
        result.set.removeAll(this.set);
        return result;
    }

    /**
     * Checks whether the set is empty.
     *
     * @return true if the set has no elements
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Format: [1, 2, 3] or [] if empty.
     *
     * @return the string representation of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sorted = new ArrayList<>(set);
        Collections.sort(sorted);
        return sorted.toString();
    }
}
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Furkan Ozev
 * @since 21-12-2020
 * Homework 2 - 161044036
 *
 * This class is used to indicate spiral iterator.
 */
public class SpiralIterator<E> implements Iterator {
    /**
     * Keep integers in the arraylist as spiral way
     */
    protected ArrayList<E> list;
    /**
     * Keep list's iterator to traverse list.
     */
    protected Iterator<E> iterator;

    /**
     * Keep row amount of 2D array.
     */
    protected int row = 0;
    /**
     * Keep column amount of 2D array.
     */
    protected int column = 0;
    /**
     * Current temporary row for traverse array.
     */
    protected int x = 0;
    /**
     * Current temporary column for traverse array.
     */
    protected int y = 0;

    /**
     * Returns true if the iteration has more elements.
     * @return  boolean true or false
     */
    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * Returns the next element in the iteration and advances the iterator.
     * @return  integer next element
     */
    @Override
    public Object next() {
        return iterator.next();
    }
}
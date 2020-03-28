package teme.w07_comparable.ex0_warmup;

import java.util.Iterator;

class SquaresIterableDemo {
    public static void main(String[] args) {

        //TODO: uncomment these when ready
        /*
        //iterable without limit
        System.out.println("\nUsing iterable without limit:");
        for (long l : new SquaresIterable()) {
            if (l > 100_000) {
                break;
            }
            System.out.println(l);
        }
        */

        /*
        //iterable with limit!
        System.out.println("\nUsing iterable with limit:");
        for (long l : new SquaresIterableWithLimit(100_000)) {
            System.out.println(l);
        }
        */
    }
}

/**
 * An iterable for square numbers
 */
class SquaresIterable implements Iterable<Long> {

    /**
     * Produces and returns a new instance of an iterator
     * which can iterate over the square of natural numbers
     */
    @Override
    public Iterator<Long> iterator() {
        return new SquaresIterator();
    }
}

/**
 * The iterator which knows to iterate over the squares of natural numbers
 */
class SquaresIterator implements Iterator<Long> {

    private long i = 0;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Long next() {
        i++;
        return i * i;
    }
}


//--- OPTIONAL ---//

class SquaresIterableWithLimit implements Iterable<Long> {

    private final long maxLimit;

    SquaresIterableWithLimit(long maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public Iterator<Long> iterator() {
        return new SquaresIteratorWithLimit(maxLimit);
    }
}

class SquaresIteratorWithLimit implements Iterator<Long> {

    private long i = 0;
    private final long maxLimit;

    SquaresIteratorWithLimit(long maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean hasNext() {
        //THIS IS THE DIFFERENCE !!
        return i * i < maxLimit;
    }

    @Override
    public Long next() {
        i++;
        return i * i;
    }
}
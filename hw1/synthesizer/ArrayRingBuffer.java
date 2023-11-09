package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {

    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;
        this.rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (this.isFull()) {
            throw new RuntimeException("Ring Buffer Overflow");
        }

        this.rb[last] = x;
        this.fillCount++;
        this.last = (this.last + 1) % this.capacity;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (this.isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        }

        T item = this.rb[this.first];
        this.first = (this.first + 1) % this.capacity;
        this.fillCount--;
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (this.isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return this.rb[this.first];
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> i = new ArrayIterator(this.first);
        return i;
    }

    private class ArrayIterator implements Iterator<T> {

        private int current;

        public ArrayIterator(int first) {
            this.current = first;
        }

        @Override
        public boolean hasNext() {
            return this.current - first < fillCount;
        }

        @Override
        public T next() {
            T item = rb[this.current];
            this.current++;
            return item;
        }
    }
}

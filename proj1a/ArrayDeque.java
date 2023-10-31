public class ArrayDeque<T> {

    private T[] array;
    private int size; // different from capacity
    private int cap;
    private int front, rear; // index of the front and the one after rear

    /** constructor of class ArrayDeque */
    public ArrayDeque() {
        this.array = (T[]) new Object[8];
        this.size = 0;
        this.cap = 8; // original capacity to 8
        this.front = 0;
        this.rear = 0;
    }

    /** copy `this.array` to `newArray`, with new index starting from 0 */
    private void copyArray(T[] newArray) {
        int current = this.front;
        for (int i = 0; i < size; i++, current = (current + 1) % this.cap) {
            newArray[i] = this.array[current];
        }
    }

    /** helper method for resizing array */
    private void doubleArrayCap() {
        T[] newArray = (T[]) new Object[this.cap * 2];
        this.copyArray(newArray);

        this.array = newArray;
        this.cap *= 2;
        this.front = 0;
        this.rear = this.size;
    }

    /** helper method for resizing array */
    private void halveArrayCap() throws ArrayIndexOutOfBoundsException {
        if (size > this.cap / 2) {
            throw new ArrayIndexOutOfBoundsException("cannot halve array");
        }

        T[] newArray = (T[]) new Object[this.cap / 2];
        this.copyArray(newArray);

        this.array = newArray;
        this.cap /= 2;
        this.front = 0;
        this.rear = this.size;
    }

    public void addFirst(T item) {
        if (this.size + 1 >= this.cap * 3 / 4) {
            doubleArrayCap();
        }

        this.front = (this.front + this.cap - 1) % this.cap;
        this.array[this.front] = item;
        this.size++;
    }

    public void addLast(T item) {
        if (this.size + 1 >= this.cap * 3 / 4) {
            doubleArrayCap();
        }

        this.array[this.rear] = item;
        this.rear = (this.rear + 1) % this.cap;
        this.size++;
    }

    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        for (int i = this.front; i != this.rear; i = (i + 1) % this.cap) {
            System.out.print(this.array[i] + " ");
        }
    }

    public T removeFirst() {
        if (this.size == 0) {
            return null;
        }

        T item = this.array[this.front];
        this.front = (this.front + 1) % this.cap;
        this.size--;

        if (this.cap >= 16 && this.size <= this.cap / 4) {
            halveArrayCap();
        }
        
        return item;
    }

    public T removeLast() {
        if (this.size == 0) {
            return null;
        }

        this.rear = (this.rear + this.cap - 1) % this.cap;
        T item = this.array[this.rear];
        this.size--;

        if (this.cap >= 16 && this.size <= this.cap / 4) {
            halveArrayCap();
        }

        return item;
    }

    public T get(int index) {
        int actualIndex = (this.front + index) % this.cap;
        return this.array[actualIndex];
    }
}

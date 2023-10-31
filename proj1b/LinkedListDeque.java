public class LinkedListDeque<T> implements Deque<T> {

    private class Node {

        private T item;
        private Node prev, next;

        private Node(T item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }

        private T getRecursiveHelper(int count) {
            if (count == 0) {
                return this.item;
            } else {
                return this.next.getRecursiveHelper(count - 1);
            }
        }
    }

    private Node sentinel; // use circular sentinel topology
    private int size;

    /** constructor of public class LinkedListDeque */
    public LinkedListDeque() {
        Node n = new Node(null);
        n.prev = n;
        n.next = n;

        this.sentinel = n;
        this.size = 0;
    }
    
    /** add an item to the front end of the list */
    @Override
    public void addFirst(T item) {
        Node n = new Node(item);
        
        this.sentinel.next.prev = n;
        n.next = this.sentinel.next;
        this.sentinel.next = n;
        n.prev = this.sentinel;

        this.size++;
    }

    /** add an item to the rear end of the list */
    @Override
    public void addLast(T item) {
        Node n = new Node(item);

        n.next = this.sentinel;
        n.prev = this.sentinel.prev;
        this.sentinel.prev.next = n;
        this.sentinel.prev = n;

        this.size++;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0 ? true : false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void printDeque() {
        for (Node i = this.sentinel.next; i != this.sentinel; i = i.next) {
            System.out.print(i.item.toString() + " ");
        }
    }

    /** remove the item at the front end of the list */
    @Override
    public T removeFirst() {
        if (this.isEmpty()) {
            return null;
        }

        Node first = this.sentinel.next;
        T item = first.item;

        this.sentinel.next = first.next;
        this.sentinel.next.prev = first.prev;

        this.size--;
        return item;
    }

    /** remove the item at the rear end of the list */
    @Override
    public T removeLast() {
        if (this.isEmpty()) {
            return null;
        }

        Node last = this.sentinel.prev;
        T item = last.item;

        this.sentinel.prev = last.prev;
        this.sentinel.prev.next = last.next;

        this.size--;
        return item;
    }

    /** get the item at given index, where 0 is front, using iteration */
    @Override
    public T get(int index) {
        if (index < 0 || this.size() <= index) {
            return null;
        }

        Node target = this.sentinel.next;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }

        return target.item;
    }

    /** get the item at given index, where 0 is front, using recursion */
    public T getRecursive(int index) {
        if (index < 0 || this.size() <= index) {
            return null;
        }

        return this.sentinel.next.getRecursiveHelper(index);
    }
}

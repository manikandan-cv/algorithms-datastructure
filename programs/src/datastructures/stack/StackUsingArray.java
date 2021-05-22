package datastructures.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack can be implemented using Array ( with resizing )
 */
public class StackUsingArray<Item> implements Iterable{
    private static final int INITIAL_CAPACITY = 10;

    Item[] items = null;
    int n; // As array of fixed size , n holds the recently added items position

    public StackUsingArray() {
        items = (Item[]) new Object[INITIAL_CAPACITY];
        n = 0;
    }

    public boolean isEmpty() {
        return n==0;
    }

    public int size() {
        return n;
    }

    public Item pop() {
        if ( isEmpty() ) throw new NoSuchElementException();
        Item item = items[n-1];
        items[n-1]=null;
        n--;
        if( n > 0 && n == items.length / 4) resize(n/2);
        return item;
    }

    public Item peek() {
        if ( isEmpty()) throw new NoSuchElementException();
        return items[n-1];
    }

    public void push(Item item) {
        if( n == items.length ) {
            resize(n*2);
        }
        items[n++] = item;
        printStack();
    }

    public void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int i = 0; i < n; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    private void printStack() {
        for (int i = 0; i < n; i++) {
            System.out.print(items[i]+" , ");
        }
        System.out.println();
    }

    class ReverseArrayIterator implements Iterator {

        int i ;

        ReverseArrayIterator() {
            i = n-1;
        }

        @Override
        public boolean hasNext() {
            return i>=0;
        }

        @Override
        public Object next() {
            return items[i--];
        }
    }

    @Override
    public Iterator iterator() {
        return new ReverseArrayIterator();
    }

    public static void main(String arg[]) {
        StackUsingArray<Integer> stackUsingArray = new StackUsingArray<>();
        stackUsingArray.push(1);
        stackUsingArray.push(2);
        System.out.println(stackUsingArray.peek());
    }
}

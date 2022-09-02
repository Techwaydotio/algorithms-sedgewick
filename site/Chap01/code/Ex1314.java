package Chap01.code;

import java.util.Iterator;
import java.util.Objects;

public class Ex1314 {
    static class ResizingArrayQueueOfStrings<String> implements Iterable<String> {
        private String[] a;
        private int N = 0;

        ResizingArrayQueueOfStrings() {
            a =  (String[])new Object[1];
        }

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        private void resize(int max) { // Move stack to a new array of size max.
            String[] temp = (String[])new Object[max];
            for (int i = 0; i < N; i++)
                temp[i] = a[i];
            a = temp;
        }

        public void enqueue(String item) { // Add item to the end of the queue.
            if (N == a.length) resize(2 * a.length);
            a[N++] = item;
        }

        public String pop() { // Remove item from the front of queue.
            String item = a[0];
            for (int i = 1; i < N; i++) {
                a[i - 1] = a[i];
            }
            if (N > 0 && N == a.length / 4) resize(a.length / 2);
            return item;
        }

        @Override
        public Iterator<String> iterator() {
            return new ResizingArrayQueueOfStringsIterator();
        }

        private class ResizingArrayQueueOfStringsIterator implements Iterator<String> { // Support FIFO iteration.
            private int i = 0;

            public boolean hasNext() {
                return i < N;
            }

            public String next() {
                return a[i++];
            }

            public void remove() {
            }
        }
    }

    public static void main(String[] args) {
        ResizingArrayQueueOfStrings q = new ResizingArrayQueueOfStrings();
        q.enqueue("Hello");
        q.enqueue("World");
        q.enqueue("!");
        q.enqueue("123");
        q.enqueue("456");
        Iterator<String> it = q.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

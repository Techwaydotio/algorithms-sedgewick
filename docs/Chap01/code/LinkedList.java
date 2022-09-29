package Chap01.code;

import java.util.Iterator;

public class LinkedList<Item> implements Iterable<Item> {
    private Node first; // first node in list

    private class Node {
        Item item;
        Node next;
    }

    public void add(Item item) { // same as push() in Stack
        Node new_node = new Node();
        new_node.next = first;
        new_node.item = item;
        first = new_node;
    }
     // 1.3.20
    public Node delete(int k) {
        if (first == null)
            return null;
       
        Node prev = first;
        if (k==0 && first.next == null) {
            first = first.next;
            return prev;
        }
        for (int i = 0; prev != null && i < k - 1;
             i++)
             prev = prev.next;

        if (prev == null || prev.next == null)
            return null;
        var temp = prev.next;
        prev.next = prev.next.next;
        return temp;
    }
    // 1.3.19
    public Node deleteLast() {
        if (first == null)
            return null;
 
        if (first.next == null) {
            return null;
        }
        // Find the second last node
        Node prev = first;
        while (prev.next.next != null)
            prev = prev.next;
 
        // Change next of second last
        prev.next = null;
 
        return first;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
        }

        public Item next() {
            current = current.next;
            return current.item;
        }
    }
    public static void main(String[] args)
    {
        var llist = new LinkedList<Integer>();
  
        llist.add(7);
        llist.add(1);
        llist.add(3);
        llist.add(2);
        llist.add(8);
  
        System.out.println("\nCreated Linked list is: ");
    
        llist.delete(4); // Delete node at position 4
  
        System.out.println(
            "\nLinked List after Deletion at position 4: ");
        llist.printList();
    }

    public void printList()
    {
        Node tnode = first;
        while (tnode != null) {
            System.out.print(tnode.item + " ");
            tnode = tnode.next;
        }
    }
}

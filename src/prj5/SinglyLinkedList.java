package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * A singly linked list of nodes
 * @author hsabbott
 * @version 2022.11.13
 */
public class SinglyLinkedList<E> implements ListInterface<E>, Iterable<E> {

    private int size;
    private Node firstNode;
    
    /**
     * creates a new linked list object with no entries in it
     */
    public SinglyLinkedList() {
        size = 0;
        firstNode = null;
    }

    /**
     * Tells whether or not the list is empty
     * @return 
     *     true if the list is empty, false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adds a new entry to the end of the linked list
     * @param newEntry 
     *     the entry being added
     * @throws IllegalArugmentException
     *     when newEntry is null
     */
    @Override
    public void add(E newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException();
        }
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        }
        else
        {
            newNode.setNext(firstNode);
            firstNode = newNode;
        }
        size++;
    }

    /**
     * adds a new node to the list at the given index
     * @param index
     *     the spot in the list where the node is being added (starting at 0)
     * @param newEntry
     *     the data being added to the list
     * @throws IllegalArgumentException
     *     if newEntry is null
     * @throws IndexOutOfBoundsException
     *     if the index is not in the range of the list
     */
    @Override
    public void add(int index, E newEntry) {
        if ((index < 0) || (index > size)) {
            throw new IndexOutOfBoundsException();
        }
        
        if (newEntry == null) {
            throw new IllegalArgumentException();
        }
        
        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            firstNode = new Node(newEntry);
        }
        else {
            if (index == 0) {
                newNode.setNext(firstNode);
                firstNode = newNode;
                
            }
            else {
                Node curr = firstNode;
                int currIndex = 0;
                while (curr != null) {
                    if (currIndex + 1 == index) {
                        Node newNext = curr.getNext();
                        curr.setNext(newNode);
                        newNode.setNext(newNext);
                        
                    }
                    curr = curr.getNext();
                    currIndex++;
                }
            }
        }
        size++;
    }

    /**
     * completely clears the list of all entries
     */
    @Override
    public void clear() {
        firstNode = null;
        size = 0;
    }

    /**
     * checks whether or not the list has a node containing the given data
     * @param entry
     *     the data being searched for
     * @return 
     *     true if the data is in the list, false ifnot
     */
    @Override
    public boolean contains(E entry) {
        Node curr = firstNode;
        while (curr != null) {
            if (curr.getData().equals(entry)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }
    
    /**
     * gets the data at a given index in the list
     * @param index
     *     the position in the list (starting at 0)
     * @return 
     *     the data at index
     * @throws IndexOutOfBoundsException
     *     when the index is not in the list
     */
    @Override
    public E getEntry(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
        
        Node curr = firstNode;
        int currIndex = 0;
        while ((currIndex != index) && (curr != null)) {
            currIndex++;
            curr = curr.getNext();
        }
        return curr.getData();
    }

    /**
     * gets the current size of the list
     * @return
     *     the number of entries in the list
     */
    @Override
    public int getLength() {
        return size;
    }

    /**
     * removes the node at the given index from the list
     * @param index
     *     the position of the node in the list being removed (starting at 0)
     * @return 
     *     the data in the removed node
     * @throws IndexOutOfBoundsException
     *     if the index is negative or longer than the list
     */
    @Override
    public E remove(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0) {
            E removedData = firstNode.getData();
            firstNode = firstNode.getNext();
            size--;
            return removedData;
        }
        
        Node curr = firstNode;
        Node prev = null;
        int currIndex = 0;
        while ((currIndex != index) && (curr != null)) {
            currIndex++;
            prev = curr;
            curr = curr.getNext();
        }
        E removedData = curr.getData();
        Node newNext = curr.getNext();
        prev.setNext(newNext);
        size--;
        return removedData;
        
    }

    /**
     * replaces the data at a given index
     * @param index
     *     the position that is being replace (starts at 0)
     * @param newEntry
     *     the new data at index
     * @return 
     *     the old data at index
     * @throws IllegalArgumentException
     *     when newEntry is null
     * @throws IndexOutOfBoundsException
     *     when index is not in the range of the list
     */
    @Override
    public E replace(int index, E newEntry) {
        if (newEntry == null) {
            throw new IllegalArgumentException();
        }
        
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }
        
        Node curr = firstNode; 
        int currIndex = 0;
        while ((curr != null) && (currIndex != index)) {
            curr = curr.getNext();
            currIndex++;
        }
        
        E oldData = curr.getData();
        curr.setData(newEntry);
        return oldData;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        E[] displayList = (E[]) new Object[size];
        Node curr = firstNode;
        int currIndex = 0;
        while (curr != null) {
            displayList[currIndex] = curr.getData();
            curr = curr.getNext();
            currIndex++;
        }
        return displayList;
    }
    
    @Override
    public Iterator<E> iterator() {
        return new SLListIterator<E>();
    }

    private class SLListIterator<A> implements Iterator<E> {

        private Node next;
        private boolean calledNext;
        
        public SLListIterator() {
            next = firstNode;
            calledNext = false;
        }
        
        /**
         * checks if there is another entry in the list
         * @return 
         *     true if there is another entry, false if not
         */
        @Override
        public boolean hasNext() {
            return (next != null);
        }

        /**
         * moves the iterator one spot down 
         * @return 
         *     the next value
         * @throws NoSuchElementException
         *     when there is no element to iterate over
         */
        @Override
        public E next() {
            if (next == null) {
                throw new NoSuchElementException();
            }
            E data = next.getData();
            next = next.getNext();
            calledNext = true;
            return data;
        }
        
    }
    
    /**
     * A node object for building the linked list
     * @author hsabbott
     * @version 2022.11.13
     */
    private class Node {
        
        private E data;
        private Node next;
        
        /**
         * creates a new node object with data but no next node
         * @param entry
         *     the data that the node is holding
         */
        public Node(E entry) {
            data = entry;
        }
        
        /**
         * creates a new node object with both data and a next node
         * @param entry
         *     the data that the node is holding
         * @param nextNode
         *     the next node
         */
        public Node(E entry, Node nextNode) {
            this(entry);
            this.setNext(nextNode);
        }
        
        /**
         * sets the next node
         * @param nextNode
         *     the next node
         */
        public void setNext(Node nextNode) {
            next = nextNode;
        }
        
        /**
         * sets the data field
         * @param newData
         *     the new data
         */
        public void setData(E newData) {
            data = newData;
        }
        
        /**
         * gets the next node
         * @return
         *     the next node
         */
        public Node getNext() {
            return next;
        }
        
        /**
         * gets the data in the node
         * @return
         *     the data 
         */
        public E getData() {
            return data;
        }
    }
}

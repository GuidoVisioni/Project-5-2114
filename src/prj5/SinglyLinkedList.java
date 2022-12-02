package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import list.ListInterface;

/**
 * A singly linked list implementation
 * 
 * @author rama04, hsabbott, gjvisioni25
 * @version 11/13/2022
 * @param <E>
 *            the type the list is holding
 */
public class SinglyLinkedList<E> implements ListInterface<E>, Iterable<E> {

    private int size;
    private Node firstNode;

    /**
     * Constructor. Creates empty list
     */
    public SinglyLinkedList() {
        size = 0;
        firstNode = null;
    }


    /**
     * Checks if the list is empty
     * 
     * @return
     *         true if the list is empty, false if not
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Adds a new entry to the end of the linked list
     * 
     * @param newEntry
     *            the entry being added
     * @throws IllegalArgumentException
     *             when newEntry is null
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
        else {
            newNode.setNext(firstNode);
            firstNode = newNode;
        }
        size++;
    }


    /**
     * Adds a new node to the list at the given index
     * 
     * @param index
     *            index where the new node is to be added
     * @param newEntry
     *            the data being added to the list
     * @throws IllegalArgumentException
     *             if newEntry is null
     * @throws IndexOutOfBoundsException
     *             if the index is not in the range of the list of the list
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
     * Completely clears the list of all entries. List will be empty.
     */
    @Override
    public void clear() {
        firstNode = null;
        size = 0;
    }


    /**
     * Checks whether or not the list has a node containing the given data
     * 
     * @param entry
     *            the data being searched for
     * @return
     *         true if the data is in the list, false if not
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
     * Gets the data at a given index in the list
     * 
     * @param index
     *            index in the list
     * @return
     *         the data at index
     * @throws IndexOutOfBoundsException
     *             when the index is not in the range of the list
     */
    @Override
    public E getEntry(int index) {
        if ((index < 0) || (index >= size)) {
            throw new IndexOutOfBoundsException();
        }

        Node curr = firstNode;
        int currIndex = 0;
        while (currIndex != index) {
            currIndex++;
            curr = curr.getNext();
        }
        return curr.getData();
    }


    /**
     * Gets the current size of the list
     * 
     * @return
     *         size (number of entries in the list)
     */
    @Override
    public int getLength() {
        return size;
    }


    /**
     * Removes the node at the given index from the list
     * 
     * @param index
     *            index where the node is to be removed
     * @return
     *         the data in the removed node
     * @throws IndexOutOfBoundsException
     *             when the index is not in the range of the list
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
        while (currIndex != index) {
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
     * Replaces the data at a given index
     * 
     * @param index
     *            index that is being replace
     * @param newEntry
     *            the new data be be added
     * @return
     *         the old data at index
     * @throws IllegalArgumentException
     *             when newEntry is null
     * @throws IndexOutOfBoundsException
     *             when the index is not in the range of the list
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
        while (currIndex != index) {
            curr = curr.getNext();
            currIndex++;
        }

        E oldData = curr.getData();
        curr.setData(newEntry);
        return oldData;
    }


    /**
     * Turns the linked list into an array
     * 
     * @return
     *         An array containing the same data as the original list at the
     *         same indices
     */
    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        E[] displayList = (E[])new Object[size];
        Node curr = firstNode;
        int currIndex = 0;
        while (curr != null) {
            displayList[currIndex] = curr.getData();
            curr = curr.getNext();
            currIndex++;
        }
        return displayList;
    }


    /**
     * Iterator
     * 
     * @return
     *         Return the iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new SLListIterator<E>();
    }

    private class SLListIterator<A> implements Iterator<E> {

        private Node next;
        private boolean calledNext;

        /**
         * Constructor. Creates iterator
         */
        public SLListIterator() {
            next = firstNode;
            calledNext = false;
        }


        /**
         * Checks if there is another entry in the list
         * 
         * @return
         *         true if there is another entry, false if not
         */
        @Override
        public boolean hasNext() {
            return (next != null);
        }


        /**
         * Moves the iterator one node forward
         * 
         * @return
         *         the value within the node it passes over
         * @throws NoSuchElementException
         *             when there is no node to iterate over
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


    private class Node {

        private E data;
        private Node next;

        /**
         * Creates a new node object with data but no next node
         * 
         * @param entry
         *            the data that the node is holding
         */
        public Node(E entry) {
            data = entry;
        }


        /**
         * Sets the next node
         * 
         * @param nextNode
         *            the next node
         */
        public void setNext(Node nextNode) {
            next = nextNode;
        }


        /**
         * sets the data field
         * 
         * @param newData
         *            the new data
         */
        public void setData(E newData) {
            data = newData;
        }


        /**
         * gets the next node
         * 
         * @return
         *         the next node
         */
        public Node getNext() {
            return next;
        }


        /**
         * gets the data in the node
         * 
         * @return
         *         the data
         */
        public E getData() {
            return data;
        }
    }
}

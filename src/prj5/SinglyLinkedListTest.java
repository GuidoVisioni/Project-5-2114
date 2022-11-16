package prj5;

import java.util.Arrays;
import java.util.EmptyStackException;
import student.TestCase;

/**
 * tests the methods for the SinglyLinkedList class
 * @author hsabbott
 * @version 2022.11.14
 */
public class SinglyLinkedListTest extends TestCase {

    private SinglyLinkedList<String> list;
    
    /**
     * sets up
     */
    public void setUp() {
        list = new SinglyLinkedList<String>();
    }
    
    public void testAdd() {
        assertTrue(list.isEmpty());
        list.add("meow");
        assertEquals(list.getLength(), 1);
        assertFalse(list.isEmpty());
        list.add("woof");
        assertEquals(list.getLength(), 2);
        list.add(":3");
        assertEquals(list.getLength(), 3);
        list.add(0, "door");
        assertEquals(list.getLength(), 4);
        list.add(3, "moon");
        assertEquals(list.getLength(), 5);
        list.add(5, "nier");
        assertEquals(list.getLength(), 6);
    }
    
    public void testAddException() {
        // for null parameter on add(T newEntry)
        Exception exception = null;
        try {
            list.add(null);
            fail("add(T newEntry) failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add(T newEntry) is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
        
        // for null parameter on add(int index, T newEntry)
        Exception exception2 = null;
        try {
            list.add(0, null);
            fail("int index, T newEntry) failed to throw an exception "
                + "when it should");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertTrue("add(int index, T newEntry) is throwing the wrong "
            + "type of exceptions",
            exception2 instanceof IllegalArgumentException);
        
        // for negative index on add(int index, T newEntry)
        Exception exception3 = null;
        try {
            list.add(-1, "meow");
            fail("add(int index, T newEntry) failed to throw an exception"
                + " when it should");
        }
        catch (Exception e) {
            exception3 = e;
        }
        assertTrue("add(int index, T newEntry) is throwing the wrong "
            + "type of exceptions",
            exception3 instanceof IndexOutOfBoundsException);
        
        // for too large index on add(int index, T newEntry)
        Exception exception4 = null;
        try {
            list.add(49, "meow");
            fail("add(int index, T newEntry) failed to throw an exception "
                + "when it should");
        }
        catch (Exception e) {
            exception4 = e;
        }
        assertTrue("add(int index, T newEntry) is throwing the wrong "
            + "type of exceptions",
            exception4 instanceof IndexOutOfBoundsException);
    }
    
    public void testContains() {
        list.add("meow");
        assertTrue(list.contains("meow"));
        assertFalse(list.contains("woof"));
        list.add(":3");
        list.add("door");
        assertEquals(list.getLength(), 3);
        assertTrue(list.contains("meow"));
        assertTrue(list.contains(":3"));
        assertTrue(list.contains("door"));
        assertFalse(list.contains("bug"));
    }
    
    public void testGetEntry() {
        list.add("meow");
        list.add("woof");
        list.add("moon");
        assertEquals(list.getLength(), 3);
        assertEquals(list.getEntry(0), "meow");
        assertEquals(list.getEntry(1), "woof");
        assertEquals(list.getEntry(2), "moon");
        assertEquals(list.getLength(), 3);
        list.clear();
        assertTrue(list.isEmpty());
        list.add("meow");
        assertEquals(list.getEntry(0), "meow");
    }
    
    public void testGetEntryExceptions() {
        // tests for negative index
        Exception exception = null;
        try {
            list.getEntry(-1);
            fail("getEntry() failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("getEntry() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
        
     // tests for too large index
        Exception exception2 = null;
        try {
            list.getEntry(0);
            fail("getEntry() failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertTrue("getEntry() is throwing the wrong type of exceptions",
            exception2 instanceof IndexOutOfBoundsException);
    }
    
    public void testRemove() {
        list.add("meow");
        list.add("woof");
        list.add(":3");
        assertEquals(list.getLength(), 3);
        assertEquals(list.remove(0), "meow");
        assertEquals(list.getLength(), 2);
        assertFalse(list.contains("meow"));
        assertTrue(list.contains("woof"));
        assertTrue(list.contains(":3"));    
        assertEquals(list.getEntry(0), "woof");
        list.add("door");
        list.add("bug");
        assertEquals(list.getLength(), 4);
        assertEquals(list.remove(1), ":3");
        assertEquals(list.getLength(), 3);
        assertFalse(list.contains(":3"));
        assertEquals(list.getEntry(0), "woof");
        assertEquals(list.remove(2), "bug");
        assertEquals(list.getLength(), 2);
        assertFalse(list.contains("bug"));
        assertEquals(list.getEntry(0), "woof");
        assertEquals(list.getEntry(1), "door");
    }
    
    public void testRemoveException() {
        // tests for negative index
        Exception exception = null;
        try {
            list.remove(-1);
            fail("remove() failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
        
     // tests for too large index
        Exception exception2 = null;
        try {
            list.remove(0);
            fail("remove() failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception2 instanceof IndexOutOfBoundsException);
    }
    
    public void testReplace() {
        list.add("meow");
        list.add("woof");
        list.add(":3");
        assertEquals(list.getLength(), 3);
        assertEquals(list.replace(0, "bug"), "meow");
        assertEquals(list.getEntry(0), "bug");
        assertFalse(list.contains("meow"));
        assertEquals(list.getLength(), 3);
        assertEquals(list.replace(1, "bird"), "woof");
        assertEquals(list.getEntry(1), "bird");
        assertFalse(list.contains("woof"));
        assertEquals(list.getLength(), 3);
        assertEquals(list.replace(2, "plant"), ":3");
        assertEquals(list.getEntry(2), "plant");
        assertFalse(list.contains(":3"));
        assertEquals(list.getLength(), 3);
    }
    
    public void testReplaceException() {
        list.add("meow");
        // tests for negative index
        Exception exception = null;
        try {
            list.replace(-1, "woof");
            fail("replace() failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("replace() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
        
        //tests for too large index
        Exception exception2 = null;
        try {
            list.replace(3, "woof");
            fail("replace() failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertTrue("replace() is throwing the wrong type of exceptions",
            exception2 instanceof IndexOutOfBoundsException);
        
      //tests for null data
        Exception exception3 = null;
        try {
            list.replace(0, null);
            fail("replace() failed to throw an exception when it should");
        }
        catch (Exception e) {
            exception3 = e;
        }
        assertTrue("replace() is throwing the wrong type of exceptions",
            exception3 instanceof IllegalArgumentException);
    }
    
    public void testToArray() {
        // for empty list
        Object[] empty = {};
        assertTrue(Arrays.equals(list.toArray(), empty));
        
        //for 1 element list
        Object[] one = {"meow"};
        Object[] falseOne = {"how"};
        list.add("meow");
        assertTrue(Arrays.equals(list.toArray(), one));
        assertFalse(Arrays.equals(list.toArray(), falseOne));
        
        // multiple elements
        Object[] multiple = {"meow", "woof", ":3"};
        Object[] size1 = {"meow", "woof"};
        Object[] size2 = {"meow", "woof", ":3", "door"};
        Object[] wrong = {"moon", "bug", "bird"};
        list.add("woof");
        list.add(":3");
        assertTrue(Arrays.equals(list.toArray(), multiple));
        assertFalse(Arrays.equals(list.toArray(), size1));
        assertFalse(Arrays.equals(list.toArray(), size2));
        assertFalse(Arrays.equals(list.toArray(), wrong));
    }
}

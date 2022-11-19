package prj5;

import java.util.Arrays;
import student.TestCase;

/**
 * tests the methods for the influencer calculator class
 * @author hsabbott
 * @version 2022.11.18
 */
public class InfluencerCalculatorTest extends TestCase {
    
    private InfluencerCalculator calc;
    private SinglyLinkedList<Influencer> list;
    private ComparatorAlphabetical compareA;
    private Influencer infl1;
    private Influencer infl2;
    private Influencer infl3;
    private Influencer infl4;
    private Influencer infl5;
    
    
    /**
     * sets up
     */
    public void setUp() {
        compareA = new ComparatorAlphabetical();
        infl1 = new Influencer("january", "bob", "aaaaaaaa", "US",
            "food", 1776, 88, 10000, 150, 70);
        infl2 = new Influencer("january", "bob", "bob", "US",
            "food", 164, 88, 1007, 12, 100);
        infl3 = new Influencer("january", "bob", "croatia", "US",
            "food", 176, 88, 106, 12, 73);
        infl4 = new Influencer("january", "bob", "swindon", "US",
            "food", 1, 8, 10, 15, 7);
        infl5 = new Influencer("january", "bob", "zzzzzzzz", "US",
            "food", 19976, 8328, 15600, 1115, 7000);
        list = new SinglyLinkedList<Influencer>();
        list.add(infl1);
        list.add(infl3);
        list.add(infl5);
        list.add(infl4);
        list.add(infl2);
        //list currently [infl2, infl4, infl5, infl3, infl1]
        calc = new InfluencerCalculator(list);
    }
    
    /**
     * tests the sort method for alphabetical order by channel name (third
     * parameter)
     */
    public void testSortAlphabetical() {
        
        calc.sort(list, compareA);
        Object[] listArray = list.toArray();
        Object[] arrayComp = new Object[] {infl1, infl2, infl3, infl4, infl5};
        assertEquals(listArray[1], arrayComp[1]);
        assertTrue(Arrays.equals(listArray, arrayComp));
    }
    
}

package prj5;

import java.util.Arrays;
import student.TestCase;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import student.testingsupport.annotations.Hint;

/**
 * tests the methods for the influencer calculator class
 * 
 * Utilizes provided test class to help test the coverage
 * 
 * @author rama04, hsabbott, gjvisioni25
 * @version 11/18/2022
 */
public class InfluencerCalculatorTest extends TestCase {

    private InfluencerCalculator calc;
    private SinglyLinkedList<Influencer> list;
    private ComparatorAlphabetical compareA;
    private ComparatorER compareER;
    private Influencer infl1;
    private Influencer infl2;
    private Influencer infl3;
    private Influencer infl4;
    private Influencer infl5;
    private Influencer infl6;
    private Influencer infl7;
    private Influencer infl8;
    private String fileName;
    private Scanner fileData;

    /**
     * sets up any needed variables for test methods
     */

    /**
     * sets up
     */
    public void setUp() {
        compareA = new ComparatorAlphabetical();
        compareER = new ComparatorER();
        infl1 = new Influencer("january", "bob", "ArtAllDay", "US", "food",
            1776, 88, 10000, 150, 70);
        infl2 = new Influencer("january", "bob", "ArtAllDay", "US", "food", 164,
            88, 1007, 12, 100);
        infl3 = new Influencer("january", "bob", "australian_wildlife", "US",
            "food", 176, 88, 106, 12, 73);
        infl4 = new Influencer("january", "bob", "australian_wildlife", "US",
            "food", 1, 8, 10, 15, 7);
        infl5 = new Influencer("january", "bob", "JustBeatz", "US", "food",
            19976, 8328, 15600, 1115, 7000);
        infl6 = new Influencer("january", "bob", "JustBeatz", "US", "food", 1,
            8, 10, 15, 7);
        infl7 = new Influencer("january", "bob", "wizardHighSchool", "US",
            "food", 1776, 88, 10000, 150, 70);
        infl8 = new Influencer("january", "bob", "wizardHighSchool", "US",
            "food", 164, 88, 1007, 12, 100);
        list = new SinglyLinkedList<Influencer>();
        list.add(infl1);
        list.add(infl3);
        list.add(infl5);
        list.add(infl4);
        list.add(infl2);
        list.add(infl8);
        list.add(infl7);
        list.add(infl6);
        // list currently [infl2, infl4, infl5, infl3, infl1]
        // [bob, croatia, swindon, zzzzzzzz, aaaaaaaa]
        calc = new InfluencerCalculator(list);
        fileData = null;
    }


    /**
     * tests the sort method for alphabetical order by channel name (third
     * parameter)
     */
    public void testSortAlphabetical() {

        calc.sort(compareA);
        Object[] listArray = list.toArray();
        Object[] arrayComp = new Object[] { infl2, infl1, infl4, infl3, infl6,
            infl5, infl7, infl8 };
        assertTrue(Arrays.equals(listArray, arrayComp));
    }


    /**
     * tests the sort method for the engagement rate
     */
    public void testSortEngagementRate() {
        calc.sort(compareER);
        Object[] listArray = list.toArray();
        Object[] arrayComp = new Object[] { infl5, infl7, infl8, infl2, infl3,
            infl1, infl6, infl4 };
        assertTrue(Arrays.equals(listArray, arrayComp));
    }
}

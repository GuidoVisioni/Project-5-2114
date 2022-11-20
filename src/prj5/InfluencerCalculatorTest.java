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
 * @author hsabbott
 * @version 2022.11.18
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

        calc.sort(list, compareA);
        Object[] listArray = list.toArray();
        Object[] arrayComp = new Object[] { infl2, infl1, infl4, infl3, infl6,
            infl5, infl7, infl8 };
        assertTrue(Arrays.equals(listArray, arrayComp));
    }


    /**
     * tests the sort method for the engagement rate
     */
    public void testSortEngagementRate() {
        calc.sort(list, compareER);
        Object[] listArray = list.toArray();
        Object[] arrayComp = new Object[] { infl5, infl7, infl8, infl2, infl3,
            infl1, infl6, infl4 };
        assertTrue(Arrays.equals(listArray, arrayComp));
    }


    /**
     * Test the program with randomly generated data that have NA fields.
     * Gathers the output from StdOut and compares it to
     * the expect output (stored in influencerOutput2)
     * 
     * @throws ParseException
     *
     */
    @Hint("The main method is not working properly with input file - "
        + "SampleInput1_2022.csv")
    public void testMain01() throws java.io.IOException, ParseException {

        Input.main(new String[] { "SampleInput1_2022.csv" });

        fileName = "SampleOutput1_2022.txt";

        String influencerOutput2 = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            influencerOutput2 += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for other input files "
            + ".csv", influencerOutput2, systemOut().getHistory());

    }


    /**
     * Test the program with randomly generated data that have NA fields.
     * Gathers the output from StdOut and compares it to
     * the expect output (stored in influencerOutput2)
     * 
     * @throws ParseException
     *
     */
    @Hint("The main method is not working properly with input file - "
        + "SampleInput2_2022.csv")
    public void testMain02() throws java.io.IOException, ParseException {

        Input.main(new String[] { "SampleInput2_2022.csv" });

        fileName = "SampleOutput2_2022.txt";

        String influencerOutput2 = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            influencerOutput2 += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for other input files "
            + ".csv", influencerOutput2, systemOut().getHistory());

    }


    /**
     * Test the program with randomly generated data that have NA fields.
     * Gathers the output from StdOut and compares it to
     * the expect output (stored in influencerOutput2).
     * Same as earlier test except with more detailed feedback.
     * 
     * @throws ParseException
     *
     */
    @Hint("The main method is not working properly with input file - "
        + "SampleInput2_2022.csv")
    public void testMain03() throws java.io.IOException, ParseException {

        Input.main(new String[] { "SampleInput2_2022.csv" });

        fileName = "SampleOutput2_2022.txt";

        String expectedOutput = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            expectedOutput += fileData.nextLine() + "\n";
        }

        String testOutput = systemOut().getHistory();
        String[] outputDividedOnNewline = testOutput.split("\n");
        String[] expectedDividedOnNewline = expectedOutput.split("\n");
        if (outputDividedOnNewline.length != expectedDividedOnNewline.length) {
            fail("Output was the wrong number of lines!  Expected: "
                + expectedDividedOnNewline.length + " but got "
                + outputDividedOnNewline.length);
        }
        // to mark when we shift from traditional calculation to reach
        boolean isTraditional = true;
        for (int i = 0; i < expectedDividedOnNewline.length; i++) {
            String expected = expectedDividedOnNewline[i];
            String testResult = outputDividedOnNewline[i];
            // to indicate we're on to the reach calculations
            if (expected.equals("**********")) {
                isTraditional = false;
            }
            if (!(expected.equals(testResult))) {
                // clear explanation if there's a mismatch on dividing lines
                if (expected.equals("==========")) {
                    fail("Malformed line to divide channels.  "
                        + "Should be: ========== (10 '=' signs)");
                }
                else if (expected.equals("**********")) {
                    fail("Malformed line to divide calculations.  "
                        + "Should be ********** (10 '*' signs)\"))");

                    // feedback about math errors vs
                    // malformed strings
                }
                else if (expected.contains(":")) {
                    String[] expectedSplit = expected.split(":", 2);
                    String[] testResultSplit = testResult.split(":", 2);
                    if (!expectedSplit[0].equals(testResultSplit[0])) {
                        fail("Incorrect label!  Expected the word: "
                            + expectedSplit[0] + " but got "
                            + testResultSplit[0]
                            + "make sure there's also a ': ' between "
                            + "label and number");
                    }
                    if (!expectedSplit[1].equals(testResultSplit[1])) {
                        System.out.println("Expected: " + expectedSplit[1]
                            + " but got " + testResultSplit[1]);
                        fail("Math error for a calculation on "
                            + expectedSplit[0]);

                    }

                } // end of ifs about a line with a colon
                if (isTraditional) {
                    fail("expected " + expected + " but got " + testResult
                        + " in traditional reporting");
                }
                else {
                    fail("expected " + expected + " but got " + testResult
                        + " in reach reporting");
                }
            }
        }
    }
}

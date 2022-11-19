package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
import student.testingsupport.annotations.Hint;

/**
 * Test text output for Social Media Visualization Project
 *
 * @author margaretellis
 * @version 11-12-2015
 * @author Molly Hickman
 * @version 10-10-2020
 * @author Molly Domino
 * @author Michael Peters
 * @author Derek Haqq
 * @version 11-10-2022
 * 
 */
public class Input2022FReferenceTest extends student.TestCase {
    private String fileName;
    private Scanner fileData;


    /**
     * sets up any needed variables for test methods
     */
    public void setUp() {

        fileData = null;
    }


    /**
     * Test the program with randomly generated data that have NA fields.
     * Gathers the output from StdOut and compares it to
     * the expect output (stored in InfluencerOutput_2)
     * @throws ParseException 
     *
     */
    @Hint("The main method is not working properly with input file - "
        + "SampleInput1_2022.csv")
    public void testMain01() throws java.io.IOException, ParseException {

        Input.main(new String[] { "SampleInput1_2022.csv" });

        fileName = "SampleOutput1_2022.txt";

        String InfluencerOutput_2 = "";
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
            InfluencerOutput_2 += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for other input files "
            + ".csv", InfluencerOutput_2, systemOut().getHistory());

    }


    /**
     * Test the program with randomly generated data that have NA fields.
     * Gathers the output from StdOut and compares it to
     * the expect output (stored in InfluencerOutput_2)
     * @throws ParseException 
     *
     */
    @Hint("The main method is not working properly with input file - "
        + "SampleInput2_2022.csv")
    public void testMain02() throws java.io.IOException, ParseException {

        Input.main(new String[] { "SampleInput2_2022.csv" });

        fileName = "SampleOutput2_2022.txt";

        String InfluencerOutput_2 = "";
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
            InfluencerOutput_2 += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for other input files "
            + ".csv", InfluencerOutput_2, systemOut().getHistory());

    }


    /**
     * Test the program with randomly generated data that have NA fields.
     * Gathers the output from StdOut and compares it to
     * the expect output (stored in InfluencerOutput_2).
     * Same as earlier test except with more detailed feedback.
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
                    fail(
                        "Malformed line to divide channels.  Should be: ========== (10 '=' signs)");
                }
                else if (expected.equals("**********")) {
                    fail(
                        "Malformed line to divide calculations.  Should be ********** (10 '*' signs)\"))");

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
                            + "make sure there's also a ': ' between label and number");
                    }
                    if (!expectedSplit[1].equals(testResultSplit[1])) {
                        System.out.println("Expected: " + expectedSplit[1]
                            + " but got " + testResultSplit[1]);
                        fail("Math error for a calculation on "
                            + expectedSplit[0]);

                    }

                } // end of ifs about a line with a colon
                if (isTraditional == true) {
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

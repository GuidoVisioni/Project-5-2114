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
     * 
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

}

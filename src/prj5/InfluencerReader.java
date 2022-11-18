package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * ColonyReader class
 * 
 * @author Guido Visioni (gjvisioni25)
 * @version 11/08/2022
 */
public class InfluencerReader {
    private SinglyLinkedList<Influencer> influencers;

    /**
     * Constructor
     * 
     * @param inputFileName
     *            Applicant File
     * @throws java.text.ParseException
     *             Exception
     * @throws FileNotFoundException
     *             Exception
     * @throws SpaceColonyDataException
     *             Exception
     */
    public InfluencerReader(String inputFileName)
        throws java.text.ParseException,
        FileNotFoundException {
        // Initialize influencer list
        influencers = readInfluencerInput(inputFileName);
        // Create an influencer calculator
        InfluencerCalculator calc = new InfluencerCalculator(influencers);
        // In the colony code they also created a window here. Not sure if we
        // need to do that
        GUIWindow window = new GUIWindow(calc);
    }


    /**
     * Reads input from an influencer file
     * 
     * @param fileName
     *            Name of file
     * @return
     *         Influencer linkedList
     * @throws ParseException
     *             Exception
     * @throws FileNotFoundException
     *             Exception
     */
    private SinglyLinkedList<Influencer> readInfluencerInput(String fileName)
        throws FileNotFoundException,
        java.text.ParseException {

        // Creates influencer linked list to be populated
        influencers = new SinglyLinkedList<Influencer>();
        // Creates scanner inside the input file
        Scanner file = new Scanner(new File(fileName));
        // Holds the next line
        String read = file.nextLine();
        // Loops until the file is out of new lines
        while (file.hasNextLine()) {
            // Move to the line after the headers
            read = file.nextLine();
            // Gets the data on the current line
            Scanner currLine = new Scanner(read).useDelimiter(",");
            // Initialize the array of tokens (each individual element)
            String tokens[] = new String[10];
            // Initialize how many tokens are in the array
            int tokenCount = 0;
            // While the current line has another token and tokens are less then
            // 10
            while (currLine.hasNext() && tokenCount < 10) {
                // Add the token to the tokens array
                // Should grab the tokens by whitespace by default
                tokens[tokenCount++] = currLine.next();
            }
            // Exit the current line
            currLine.close();
            // If successfully gathered 10 tokens and the month is valid
            if (tokenCount == 10) {

                // Create a new influencer using the 10 tokens
                Influencer influencerToAdd = new Influencer(tokens[0],
                    tokens[1], tokens[2], tokens[3], tokens[4], Integer.valueOf(
                        tokens[5]), Integer.valueOf(tokens[6]), Integer.valueOf(
                            tokens[7]), Integer.valueOf(tokens[8]), Integer
                                .valueOf(tokens[9]));
                // Add that influencer to the list
                influencers.add(influencerToAdd);

            }
            // If there are more or less than 10 tokens throw exception
            else {
                throw new java.text.ParseException("parse exception",
                    tokenCount);
            }
        }
        // Close the file
        file.close();
        // Return list of influencers
        return influencers;
    }
}

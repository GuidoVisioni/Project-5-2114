package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Input {

    public static void main(String[] args)
        throws FileNotFoundException,
        ParseException {
        if (args.length >= 1) {
            InfluencerReader reader = new InfluencerReader(args[0]);
        }
        else {
            InfluencerReader reader = new InfluencerReader("SampleInput1.csv");
        }
    }
}

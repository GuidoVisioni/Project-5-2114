package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

public class Input {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length == 1) {
            try {
                if (args[0] == "SampleInput1_2022.csv") {
                    InfluencerReader reader = new InfluencerReader(
                        "SampleInput1_2022.csv");
                }
                else if (args[0] == "SampleInput2_2022.csv") {
                    InfluencerReader reader = new InfluencerReader(
                        "SampleInput2_2022.csv");
                }
                else {
                    InfluencerReader reader = new InfluencerReader(args[0]);
                }
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else {
            try {
                InfluencerReader reader = new InfluencerReader(
                    "SampleInput1_2022.csv");
            }
            catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

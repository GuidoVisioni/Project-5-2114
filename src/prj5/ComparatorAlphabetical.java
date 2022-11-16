/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author ramamittal
 *
 */
public class ComparatorAlphabetical implements Comparator<Influencer>{


    @Override
    public int compare(Influencer one, Influencer two) {
        return one.getChannelName().compareTo(two.getChannelName());
    }

}

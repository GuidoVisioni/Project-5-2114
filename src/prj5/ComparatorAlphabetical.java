/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * @author ramamittal
 * @version 11/18/2022
 *
 */
public class ComparatorAlphabetical implements Comparator<Influencer> {

    @Override
    public int compare(Influencer one, Influencer two) {
        return one.getChannelName().toLowerCase().compareTo(two.getChannelName().toLowerCase());
    }

}

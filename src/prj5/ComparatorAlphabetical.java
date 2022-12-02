/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * Comparator for alphabetical
 * 
 * @author rama04, hsabbott, gjvisioni25
 * @version 11/18/2022
 *
 */
public class ComparatorAlphabetical implements Comparator<Influencer> {

    /**
     * Compares the two influencers alphabetically
     * 
     * @return
     *         -1, 0, or 1
     */
    @Override
    public int compare(Influencer one, Influencer two) {
        return one.getChannelName().toLowerCase().compareTo(two.getChannelName()
            .toLowerCase());
    }

}

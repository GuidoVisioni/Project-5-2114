/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * Comparator for engagement reach
 * 
 * @author rama04, hsabbott, gjvisioni25
 * @version 11/15/2022
 *
 */
public class ComparatorER implements Comparator<Influencer> {

    /**
     * Compares the two influencers by reach engagement rate
     * 
     * @return
     *         -1, 0, or 1
     */
    @Override
    public int compare(Influencer one, Influencer two) {
        if (one.getPosts() < two.getPosts()) {
            return 1;
        }

        else if (one.getPosts() > two.getPosts()) {
            return -1;
        }

        else {
            return 0;
        }
    }

}

/**
 * 
 */
package prj5;

import java.util.Comparator;

/**
 * Comparator EngagementReach
 * 
 * @author ramamittal
 * @version 11/15/2022
 *
 */
public class ComparatorER implements Comparator<Influencer> {

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

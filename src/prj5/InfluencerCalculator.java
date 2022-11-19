package prj5;

import java.text.DecimalFormat;
import java.util.Comparator;

/**
 * Influencer Calculator Class
 * 
 * @author Guido Visioni (gjvisioni25)
 *
 */
public class InfluencerCalculator {

    private SinglyLinkedList<Influencer> influencers;

    /**
     * Constructor
     * 
     * @param influencerList
     *            List of influencers
     */
    public InfluencerCalculator(SinglyLinkedList<Influencer> influencerList) {
        if (influencerList == null) {
            throw new IllegalArgumentException();
        }
        this.influencers = influencerList;
    }


    public void sort(
        SinglyLinkedList<Influencer> influencers,
        Comparator<Influencer> c) {
        for (int i = 0; i < influencers.getLength(); i++) {
            insertInOrder(influencers.getEntry(i), influencers, i - 1, c);
        }

    }


    private void insertInOrder(
        Influencer entry,
        SinglyLinkedList<Influencer> influencers,
        int end,
        Comparator<Influencer> c) {
        int index = end;

        while ((index >= 0) && (c.compare(entry, influencers.getEntry(
            index)) < 0)) {
            influencers.replace(index + 1, influencers.getEntry(index));
            index--;
        }

        influencers.replace(index + 1, entry);
    }
    
    /**
     * Get the traditional engagement for an influencer
     * 
     * @return
     *         Traditional Engagement
     */
    public double getEngagementTraditional(SinglyLinkedList<Influencer> influencers, String channelName) {
        ComparatorAlphabetical compareAlpha = new ComparatorAlphabetical();
        sort(influencers, compareAlpha);
        if(this.getFollowerCount() == 0)
        {
            return -1;
        }
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((this.getTotalEngagement() / this.getFollowerCount())
            * 100));
    }


    /**
     * Get the engagement by reach for an influencer
     * 
     * @return
     *         Reach Engagement
     */
    public double getEngagementReach(SinglyLinkedList<Influencer> influencers, String channelName) {
        ComparatorAlphabetical compareAlpha = new ComparatorAlphabetical();
        sort(influencers, compareAlpha);
        if(this.getReach() == 0)
        {
            return -1;
        }
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((this.getTotalEngagement() / this.getReach()) * 100));
    }

    public void output() {
        ComparatorAlphabetical compareAlpha = new ComparatorAlphabetical();
        sort(influencers, compareAlpha);
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (builder.length() > 1) {
                builder.append("==========" + "\n");
            }
            builder.append(influencers.getEntry(i).getChannelName() + "\n");
            builder.append("traditional: " + getEngagementTraditional(influencers) + "\n");
        }
        
        ComparatorER compareER = new ComparatorER();
        sort(influencers, compareER);
        StringBuilder builder2 = new StringBuilder();
        builder2.append("**********" + "\n");
        builder2.append("**********" + "\n");
        for (int j = 0; j < 4; j ++)
        {
            if(builder2.length() > 1)
            {
                builder2.append("==========" + "\n");
            }
            builder2.append(influencers.getEntry(j).getChannelName() + "\n");
            builder2.append("reach: " + influencers.getEntry(j).getEngagementReach() + "\n");
        }
        String builderString = builder.toString();
        String builder2String = builder2.toString();
        System.out.print(builderString + builder2String);
    }
}

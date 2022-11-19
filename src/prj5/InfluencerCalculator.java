package prj5;

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
            influencers.replace(index, influencers.getEntry(index));
            index--;
        }

        influencers.replace(index + 1, entry);
    }
    
   

    public String output() {
        ComparatorAlphabetical compareAlpha = new ComparatorAlphabetical();
        sort(influencers, compareAlpha);
        
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < influencers.getLength(); i++) {
            if (builder.length() > 1) {
                builder.append("==========");
            }
            builder.append(influencers.getEntry(i).getChannelName() + "\n");
            builder.append("traditional: " + influencers.getEntry(i).getEngagementTraditional());
            builder.append("==========");
        }
        
        StringBuilder builder2 = new StringBuilder();
        builder2.append("**********");
        builder2.append("**********");
        for (int j = 0; j < influencers.getLength(); j ++)
        {
            if(builder2.length() > 1)
            {
                builder2.append("==========");
            }
            builder2.append(influencers.getEntry(j).getChannelName() + "\n");
            builder2.append("reach: " + influencers.getEntry(j).getEngagementReach());
        }
        String builderString = builder.toString();
        String builder2String = builder2.toString();
        return builderString + builder2String;
    }
}

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
    
    public void sort(SinglyLinkedList<Influencer> influencers, Comparator<Influencer> c) {
        for (int i = 0; i < influencers.getLength(); i++) {
            insertInOrder(influencers.getEntry(i), influencers, i - 1, c);
        }

    }
    
    private void insertInOrder(Influencer entry, SinglyLinkedList<Influencer> influencers,
        int end, Comparator<Influencer> c) {
        int index = end;
        
        while ((index >= 0) && (c.compare(entry, influencers.getEntry(index)) < 0)) {
            influencers.replace(index, influencers.getEntry(index));
            index--;
        }
        
        influencers.replace(index + 1, entry);
    }
    

}

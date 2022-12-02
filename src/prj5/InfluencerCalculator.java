package prj5;

import java.text.DecimalFormat;
import java.util.Comparator;

/**
 * Influencer Calculator Class
 * 
 * @author rama04, hsabbott, gjvisioni25
 * @version 11/18/2022
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


    /**
     * Gets influencer list
     * 
     * @return
     *         list of influencers
     */
    public SinglyLinkedList<Influencer> getInfluencers() {
        return influencers;
    }


    /**
     * Sorts the linked list
     * 
     * @param c
     *            comparator
     */
    public void sort(Comparator<Influencer> c) {
        for (int i = 0; i < influencers.getLength(); i++) {

            insertInOrderSortHelper(influencers.getEntry(i), influencers, i - 1,
                c);
        }
    }


    private void insertInOrderSortHelper(
        Influencer entry,
        SinglyLinkedList<Influencer> influencer,
        int end,
        Comparator<Influencer> c) {

        while ((end >= 0) && (c.compare(entry, influencer.getEntry(end)) < 0)) {
            influencer.replace(end + 1, influencer.getEntry(end));
            end--;
        }
        influencer.replace(end + 1, entry);
    }

    /**
     * Gets the quarterly traditional engagement rate (Jan, Feb, March)
     * 
     * @param channelName
     *            channelName
     * @return
     *         Quarterly traditional engagement rate formatted "#.#"
     */
    public double getTradEngageForQuart(String channelName) {
        double tradER = 0;
        Influencer marchMan = influencers.getEntry(0);
        String[] firstQuarter = { "january", "february", "march" };
        for (int i = 0; i < influencers.getLength(); i++) {
            if (influencers.getEntry(i).getChannelName().toLowerCase().equals(
                channelName)) {
                for (int j = 0; j < firstQuarter.length; j++) {
                    if (influencers.getEntry(i).getMonth().toLowerCase().equals(
                        firstQuarter[2])) {
                        marchMan = influencers.getEntry(i);
                    }
                    if (influencers.getEntry(i).getMonth().toLowerCase().equals(
                        firstQuarter[j])) {
                        tradER += influencers.getEntry(i).getTotalEngagement();
                    }
                    else {
                        tradER += 0;
                    }
                }
            }
        }
        if (marchMan.getFollowers() == 0) {
            return -1;
        }
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((tradER / marchMan.getFollowers())
            * 100));
    }


    /**
     * Engage Reach Quarter
     * 
     * @param channelName
     *            channelName
     * @return
     *         double
     */
    public double getEngageReachForQuart(String channelName) {
        double totalEngage = 0;
        double totalViews = 0;

        String[] firstQuarter = { "january", "february", "march" };
        for (int i = 0; i < influencers.getLength(); i++) {
            if (influencers.getEntry(i).getChannelName().toLowerCase().equals(
                channelName)) {
                for (int j = 0; j < firstQuarter.length; j++) {
                    if (influencers.getEntry(i).getMonth().toLowerCase().equals(
                        firstQuarter[j])) {
                        totalEngage += influencers.getEntry(i)
                            .getTotalEngagement();
                        totalViews += influencers.getEntry(i).getViews();
                    }
                    else {
                        totalEngage += 0;
                        totalViews += 0;
                    }
                }
            }
        }
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((totalEngage / totalViews) * 100));
    }
}

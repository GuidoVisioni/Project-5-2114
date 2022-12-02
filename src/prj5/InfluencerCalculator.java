package prj5;

import java.text.DecimalFormat;
import java.util.Comparator;

/**
 * Influencer Calculator Class
 * 
 * @author Guido Visioni (gjvisioni25)
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
     * 
     * @param influencer
     *            influencer
     * @param c
     *            comparator
     */
    public void sort(
        SinglyLinkedList<Influencer> influencer,
        Comparator<Influencer> c) {
        for (int i = 0; i < influencer.getLength(); i++) {

            insertInOrder(influencer.getEntry(i), influencer, i - 1, c);
        }

    }


    private void insertInOrder(
        Influencer entry,
        SinglyLinkedList<Influencer> influencer,
        int end,
        Comparator<Influencer> c) {
        int index = end;

        while ((index >= 0) && (c.compare(entry, influencer.getEntry(
            index)) < 0)) {
            influencer.replace(index + 1, influencer.getEntry(index));
            index--;
        }

        influencer.replace(index + 1, entry);
    }


    /**
     * Traditional Engagement
     * 
     * @param channelName
     *            channelName
     * @return
     *         double
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
                        tradER += influencers.getEntry(i)
                            .getEngagementTraditionalNoDiv();
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

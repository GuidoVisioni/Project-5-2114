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
    private SinglyLinkedList<Influencer> janInfluencers;
    private SinglyLinkedList<Influencer> febInfluencers;
    private SinglyLinkedList<Influencer> marInfluencers;

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
        this.janInfluencers = createMonthList("january");
        this.febInfluencers = createMonthList("february");
        this.marInfluencers = createMonthList("march");
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
     * Gets influencer list for january
     * 
     * @return
     *         list of influencers for january
     */
    public SinglyLinkedList<Influencer> getJanInfluencers() {
        return janInfluencers;
    }


    /**
     * Gets influencer list for february
     * 
     * @return
     *         list of influencers for february
     */
    public SinglyLinkedList<Influencer> getFebInfluencers() {
        return febInfluencers;
    }


    /**
     * Gets influencer list for march
     * 
     * @return
     *         list of influencers for march
     */
    public SinglyLinkedList<Influencer> getMarInfluencers() {
        return marInfluencers;
    }


    /**
     * Sorts the linked list
     * 
     * @param c
     *            comparator
     */
    public void sort(Comparator<Influencer> c) {
        for (int i = 0; i < janInfluencers.getLength(); i++) {

            insertInOrderSortHelper(janInfluencers.getEntry(i), janInfluencers,
                i - 1, c);
        }
        for (int j = 0; j < febInfluencers.getLength(); j++) {

            insertInOrderSortHelper(febInfluencers.getEntry(j), febInfluencers,
                j - 1, c);

        }
        for (int k = 0; k < marInfluencers.getLength(); k++) {

            insertInOrderSortHelper(marInfluencers.getEntry(k), marInfluencers,
                k - 1, c);
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
    public double[] getTradEngageForQuart() {
        double tradER = 0;
        double[] engageRates = null;
        Influencer janMan = null;
        Influencer febMan = null;
        Influencer marMan = null;

        for (int i = 0; i < janInfluencers.getLength(); i++) {
            String name = janInfluencers.getEntry(i).getChannelName()
                .toLowerCase();
            janMan = janInfluencers.getEntry(i);

            for (int j = 0; j < febInfluencers.getLength(); j++) {
                if (febInfluencers.getEntry(j).getChannelName().toLowerCase()
                    .equals(name))
                    ;
                febMan = febInfluencers.getEntry(j);
            }
            for (int k = 0; k < marInfluencers.getLength(); k++) {
                if (marInfluencers.getEntry(k).getChannelName().toLowerCase()
                    .equals(name))
                    ;
                marMan = marInfluencers.getEntry(k);
            }
            if (marMan.getFollowers() == 0) {
                engageRates[i] = -1;
            }
            else {
                tradER = janMan.getTotalEngagement() + febMan
                    .getTotalEngagement() + marMan.getTotalEngagement();
                DecimalFormat format = new DecimalFormat("#.#");
                double formattedTradER = Double.valueOf(format.format((tradER
                    / marMan.getFollowers()) * 100));
                engageRates[i] = formattedTradER;
            }
        }
        return engageRates;
    }


    private SinglyLinkedList<Influencer> createMonthList(String timePeriod) {
        SinglyLinkedList<Influencer> monthList =
            new SinglyLinkedList<Influencer>();
        String time = timePeriod.toLowerCase();
        for (int i = 0; i < influencers.getLength(); i++) {
            Influencer curr = influencers.getEntry(i);
            if (curr.getMonth().toLowerCase().equals(time)) {
                monthList.add(curr);
            }
        }
        return monthList;
    }


    /**
     * Gets the quarterly reach engagement rate (Jan, Feb, March)
     * 
     * @param channelName
     *            channelName
     * @return
     *         Quarterly reach engagement rate formatted "#.#"
     */
    public double[] getEngageReachForQuart() {
        double totalEngage = 0;
        double totalViews = 0;
        double[] engageRates = null;
        Influencer janMan = null;
        Influencer febMan = null;
        Influencer marMan = null;

        for (int i = 0; i < janInfluencers.getLength(); i++) {
            String name = janInfluencers.getEntry(i).getChannelName()
                .toLowerCase();
            janMan = janInfluencers.getEntry(i);

            for (int j = 0; j < febInfluencers.getLength(); j++) {
                if (febInfluencers.getEntry(j).getChannelName().toLowerCase()
                    .equals(name))
                    ;
                febMan = febInfluencers.getEntry(j);
            }
            for (int k = 0; k < marInfluencers.getLength(); k++) {
                if (marInfluencers.getEntry(k).getChannelName().toLowerCase()
                    .equals(name))
                    ;
                marMan = marInfluencers.getEntry(k);
            }
            totalEngage = janMan.getTotalEngagement() + febMan
                .getTotalEngagement() + marMan.getTotalEngagement();
            totalViews = janMan.getViews() + febMan.getViews() + marMan
                .getViews();
            if(totalViews == 0)
            {
                engageRates[i] = -1;
            }
            else
            {
            DecimalFormat format = new DecimalFormat("#.#");
            double reachEngage = Double.valueOf(format.format((totalEngage / totalViews) * 100));
            engageRates[i]  = reachEngage;
            }
        }
        return engageRates;
    }
}
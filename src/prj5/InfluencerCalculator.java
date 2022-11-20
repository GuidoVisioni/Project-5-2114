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


    /**
     * Output
     */
    public void output() {
        ComparatorAlphabetical compareAlpha = new ComparatorAlphabetical();
        sort(influencers, compareAlpha);

        StringBuilder builder = new StringBuilder();
        String channelName = influencers.getEntry(0).getChannelName();
        builder.append(influencers.getEntry(0).getChannelName() + "\n");
        if (getTradEngageForQuart(channelName.toLowerCase()) != -1) {
            builder.append("traditional: " + getTradEngageForQuart(channelName
                .toLowerCase()) + "\n");
        }
        else {
            builder.append("traditional: " + "N/A" + "\n");
        }
        for (int i = 0; i < influencers.getLength(); i++) {
            if (!(channelName.equals(influencers.getEntry(i)
                .getChannelName()))) {

                builder.append("==========" + "\n");

                channelName = influencers.getEntry(i).getChannelName();

                builder.append(channelName + "\n");
                if (getTradEngageForQuart(channelName.toLowerCase()) != -1) {
                    builder.append("traditional: " + getTradEngageForQuart(
                        channelName.toLowerCase()) + "\n");
                }
                else {
                    builder.append("traditional: " + "N/A" + "\n");
                }
            }
        }
        builder.append("==========" + "\n");

        SinglyLinkedList<String> foundNames = new SinglyLinkedList<String>();
        foundNames.add(influencers.getEntry(0).getChannelName());
        String channelName2 = influencers.getEntry(0).getChannelName();
        for (int j = 0; j < influencers.getLength(); j++) {
            if (!(channelName2.equals(influencers.getEntry(j)
                .getChannelName()))) {
                channelName2 = influencers.getEntry(j).getChannelName();
                foundNames.add(channelName2);
            }
        }

        SinglyLinkedList<Influencer> influencerDisplay =
            new SinglyLinkedList<Influencer>();
        for (int l = 0; l < foundNames.getLength(); l++) {
            channelName2 = foundNames.getEntry(l);
            Influencer newInfluencer = new Influencer("1", "2", foundNames
                .getEntry(l), "4", "5", 0, getEngageReachForQuart(channelName2
                    .toLowerCase()), 0, 0, 1);
            influencerDisplay.add(newInfluencer);
        }

        ComparatorER compareER = new ComparatorER();
        sort(influencerDisplay, compareER);
        builder.append("**********" + "\n" + "**********" + "\n");
        for (int m = 0; m < influencerDisplay.getLength(); m++) {
            if (m > 0) {
                builder.append("==========" + "\n");
            }
            builder.append(influencerDisplay.getEntry(m).getChannelName()
                + "\n");
            builder.append("reach: " + influencerDisplay.getEntry(m).getPosts()
                + "\n");
        }
        builder.append("==========");
        System.out.print(builder.toString());
    }
}

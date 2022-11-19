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


    public double getTradEngageForQuart(
        SinglyLinkedList<Influencer> influencers,
        String channelName) {
        double tradER = 0;
        Influencer marchMan = influencers.getEntry(0);
        String firstQuarter[] = { "january", "february", "march" };
        for (int i = 0; i < influencers.getLength(); i++) {
            if (influencers.getEntry(i).getChannelName().toLowerCase().equals(
                channelName)) {
                for (int j = 0; j < firstQuarter.length; j++) {
                    if (influencers.getEntry(i).getMonth().toLowerCase().equals(
                        firstQuarter[2])) {
                        marchMan = influencers.getEntry(j);
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
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((tradER / marchMan.getFollowers())
            * 100));
    }


    public double getEngageReachForQuart(
        SinglyLinkedList<Influencer> influencers,
        String channelName) {
        double totalEngage = 0;
        double totalViews = 0;

        String firstQuarter[] = { "january", "february", "march" };
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


    public void output() {
        ComparatorAlphabetical compareAlpha = new ComparatorAlphabetical();
        sort(influencers, compareAlpha);

        StringBuilder builder = new StringBuilder();
        String channelName = influencers.getEntry(0).getChannelName();
        builder.append(influencers.getEntry(0).getChannelName() + "\n");
        builder.append("traditional: " + getTradEngageForQuart(influencers,
            channelName.toLowerCase()) + "\n");
        for (int i = 0; i < influencers.getLength(); i++) {
            if (!(channelName.equals(influencers.getEntry(i)
                .getChannelName()))) {
                builder.append("==========" + "\n");
                channelName = influencers.getEntry(i).getChannelName();
                builder.append(channelName + "\n");
                builder.append("traditional: " + getTradEngageForQuart(
                    influencers, channelName.toLowerCase()) + "\n");
            }
        }
        builder.append("==========" + "\n");

        SinglyLinkedList<String> foundNames = new SinglyLinkedList<String>();
        String channelName2 = influencers.getEntry(0).getChannelName();
        for (int j = 0; j < influencers.getLength(); j++) {
            if (!(channelName2.equals(influencers.getEntry(j)
                .getChannelName()))) {
                channelName2 = influencers.getEntry(j).getChannelName();
                for (int k = 0; k < foundNames.getLength(); k++) {
                    if (!(channelName2.equals(foundNames.getEntry(k)))) {
                        foundNames.add(channelName2);
                    }
                }
            }
        }

        SinglyLinkedList<Influencer> influencerDisplay =
            new SinglyLinkedList<Influencer>();
        for (int l = 0; l < foundNames.getLength(); l++) {
            channelName2 = foundNames.getEntry(l);
            Influencer newInfluencer = new Influencer("1", "2", "3", "4", "5",
                0, getEngageReachForQuart(influencers, channelName2.toLowerCase()), 0, 0, 1);
            influencerDisplay.add(newInfluencer);
        }

        ComparatorER compareER = new ComparatorER();
        sort(influencerDisplay, compareER);
        StringBuilder builder2 = new StringBuilder();

        builder2.append("**********" + "\n");
        builder2.append("**********" + "\n");
        for (int m = 0; m < influencerDisplay.getLength(); m++) {
            builder2.append("==========" + "\n");
            builder2.append(influencerDisplay.getEntry(m).getChannelName()
                + "\n");
            builder2.append("reach: " + influencerDisplay.getEntry(m).getPosts()
                + "\n");
        }
        builder2.append("==========" + "\n");
        String builderString = builder.toString();
        String builder2String = builder2.toString();
        System.out.print(builderString + builder2String);
    }
}

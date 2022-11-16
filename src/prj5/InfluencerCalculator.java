package prj5;

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


    private int getTotalEngagement(Influencer influencer) {
        return influencer.getLikes() + influencer.getComments();
    }


    private int getReach(Influencer influencer) {
        return influencer.getViews();
    }


    private int getFollowers(Influencer influencer) {
        return influencer.getFollowers();
    }


    /**
     * Get the traditional engagement for an influencer
     * 
     * @return
     *         Traditional Engagement
     */
    public double getEngagementTraditional(Influencer influencer) {
        return (getTotalEngagement(influencer) / getFollowers(influencer))
            * 100;
    }


    /**
     * Get the engagement by reach for an influencer
     * 
     * @return
     *         Reach Engagement
     */
    public double getEngagementReach(Influencer influencer) {
        return (getTotalEngagement(influencer) / getReach(influencer)) * 100;
    }

}

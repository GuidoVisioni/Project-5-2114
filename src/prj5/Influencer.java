package prj5;

/**
 * Influencer Object Class
 * 
 * @author ramamittal
 * @version 11/15/2022
 *
 */
public class Influencer {

    private String month;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    /**
     * Constructor
     * 
     * @param month
     *            Month
     * @param username
     *            username
     * @param channelName
     *            ChannelName
     * @param country
     *            Country
     * @param mainTopic
     *            mainTopic
     * @param likes
     *            likes
     * @param posts
     *            posts
     * @param followers
     *            followers
     * @param comments
     *            comments
     * @param views
     *            views
     */
    public Influencer(
        String month,
        String username,
        String channelName,
        String country,
        String mainTopic,
        int likes,
        int posts,
        int followers,
        int comments,
        int views) {

        this.month = month;
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.mainTopic = mainTopic;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }


    /**
     * Gets month
     * 
     * @return
     *         month
     */
    public String getMonth() {
        return month;
    }


    /**
     * Gets username
     * 
     * @return
     *         username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Get channel name
     * 
     * @return
     *         channelName
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Get country
     * 
     * @return
     *         country
     */
    public String getCountry() {
        return country;
    }


    /**
     * Get main topic
     * 
     * @return
     *         mainTopic
     */
    public String getMainTopic() {
        return mainTopic;
    }


    /**
     * Get likes
     * 
     * @return
     *         likes
     */
    public int getLikes() {
        return likes;
    }


    /**
     * Get posts
     * 
     * @return
     *         posts
     */
    public int getPosts() {
        return posts;
    }


    /**
     * Get followers
     * 
     * @return
     *         followers
     */
    public int getFollowers() {
        return followers;
    }


    /**
     * Get comments
     * 
     * @return
     *         comments
     */
    public int getComments() {
        return comments;
    }


    /**
     * Get views
     * 
     * @return
     *         views
     */
    public int getViews() {
        return views;
    }


    private int getTotalEngagement() {
        return this.getLikes() + this.getComments();
    }


    private int getReach() {
        return this.getViews();
    }


    private int getFollowerCount() {
        return this.getFollowers();
    }


    /**
     * Get the traditional engagement for an influencer
     * 
     * @return
     *         Traditional Engagement
     */
    public double getEngagementTraditional() {
        return (this.getTotalEngagement() / this.getFollowerCount())
            * 100;
    }


    /**
     * Get the engagement by reach for an influencer
     * 
     * @return
     *         Reach Engagement
     */
    public double getEngagementReach() {
        return (this.getTotalEngagement() / this.getReach()) * 100;
    }

}

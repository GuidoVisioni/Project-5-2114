package prj5;

import java.text.DecimalFormat;

/**
 * Influencer object class. Responsible for creating influencers
 * 
 * @author rama04, hsabbott, gjvisioni25
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
    private double posts;
    private int followers;
    private int comments;
    private int views;

    /**
     * Constructor
     * 
     * @param month
     *            Month data corresponds to
     * @param username
     *            username of influencer
     * @param channelName
     *            Channel name of influencer
     * @param country
     *            Country of influencer
     * @param mainTopic
     *            Main topic of channel
     * @param likes
     *            Likes in the month
     * @param posts
     *            Posts in the month
     * @param followers
     *            Followers in the month
     * @param comments
     *            Comments in the month
     * @param views
     *            Views in the month
     */
    public Influencer(
        String month,
        String username,
        String channelName,
        String country,
        String mainTopic,
        int likes,
        double posts,
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
     * Gets the month
     * 
     * @return
     *         month
     */
    public String getMonth() {
        return month;
    }


    /**
     * Gets the username
     * 
     * @return
     *         username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Get the channel name
     * 
     * @return
     *         channelName
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Get the country
     * 
     * @return
     *         country
     */
    public String getCountry() {
        return country;
    }


    /**
     * Get the main topic
     * 
     * @return
     *         mainTopic
     */
    public String getMainTopic() {
        return mainTopic;
    }


    /**
     * Get the likes
     * 
     * @return
     *         likes
     */
    public int getLikes() {
        return likes;
    }


    /**
     * Get the posts
     * 
     * @return
     *         posts
     */
    public double getPosts() {
        return posts;
    }


    /**
     * Get the followers
     * 
     * @return
     *         followers
     */
    public int getFollowers() {
        return followers;
    }


    /**
     * Get the comments
     * 
     * @return
     *         comments
     */
    public int getComments() {
        return comments;
    }


    /**
     * Get the views
     * 
     * @return
     *         views
     */
    public int getViews() {
        return views;
    }


    /**
     * Gets the total engagement for the month
     * 
     * @return
     *         likes + comments
     */
    public int getTotalEngagement() {
        return this.getLikes() + this.getComments();
    }


    /**
     * Get the traditional engagement for an influencer for the month
     * 
     * @return
     *         Traditional Engagement Rate
     */
    public double getEngagementTraditional() {
        if (this.getFollowers() == 0) {
            return -1;
        }
        double total = Double.valueOf(this.getTotalEngagement());
        double follower = Double.valueOf(this.getFollowers());
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((total / follower) * 100));
    }

    /**
     * gets the traditional engagement without dividing
     * 
     * @return
     *         the traditional engagement without dividing
     */
    public double getEngagementTraditionalNoDiv() {
        if (this.getFollowers() == 0) {
            return -1;
        }
        double total = Double.valueOf(this.getTotalEngagement());
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((total)));
    }


    /**
     * Get the engagement by reach for an influencer
     * 
     * @return
     *         Reach Engagement
     */
    public double getEngagementReach() {
        if (this.getViews() == 0) {
            return -1;
        }
        double total = Double.valueOf(this.getTotalEngagement());
        double reach = Double.valueOf(this.getViews());
        DecimalFormat format = new DecimalFormat("#.#");
        return Double.valueOf(format.format((total / reach) * 100));
    }

}

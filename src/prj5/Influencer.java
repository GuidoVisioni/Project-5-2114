package prj5;

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
    
    public Influencer(String month, String username, 
        String channelName, String country, 
        String mainTopic, int likes, int posts, 
        int followers, int comments, int views) {
        
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
    
    public String getMonth() {
        return month;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getChannelName() {
        return channelName;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String getMainTopic() {
        return mainTopic;
    }
    
    public int getLikes() {
        return likes;
    }
    
    public int getPosts() {
        return posts;
    }
    
    public int getFollowers() {
        return followers;
    }
    
    public int getComments() {
        return comments;
    }
    
    public int getViews() {
        return views;
    }
    

}

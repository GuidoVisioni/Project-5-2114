package prj5;

import student.TestCase;
/**
 * tests the methods for the influencer class
 * @author ramamittal
 * @version 2022.11.18
 */
public class InfluencerTest extends TestCase {

    private Influencer one;
    private Influencer two;
    
    /**
     * sets up
     */
    public void setUp() {
        one = new Influencer("January", "sushi123", 
            "foodies", "Japan", "Food", 303, 20, 
            3000, 40, 430);
        
        two = new Influencer("March", "jade", 
            "geektechlife", "US", "Tech", 8442643, 
            184, 3345517, 392, 107240);
    }
    
    /**
     * tests get month
     */
    public void testGetMonth() {
        assertEquals(one.getMonth(), "January");
        assertEquals(two.getMonth(), "March");
        
    }
    
    /** 
     * tests get username
     */
    public void testGetUsername() {
        assertEquals(one.getUsername(), "sushi123");
        assertEquals(two.getUsername(), "jade");

    }
    
    /**
     * tests get channel name
     */
    public void testGetChannelName() {
        assertEquals(one.getChannelName(), "foodies");
        assertEquals(two.getChannelName(), "geektechlife");
    }
    
    /**
     * tests get country
     */
    public void testGetCountry() {
        assertEquals(one.getCountry(), "Japan");
        assertEquals(two.getCountry(), "US");
    }
    
    /**
     * tests get main topic
     */
    public void testGetMainTopic() {
        assertEquals(one.getMainTopic(), "Food");
        assertEquals(two.getMainTopic(), "Tech");

    }
    
    /**
     * tests get likes
     */
    public void testGetLikes() {
        assertEquals(one.getLikes(), 303);
        assertEquals(two.getLikes(), 8442643);

    }
    
    /**
     * tests get posts
     */
    public void testGetPosts() {
        assertEquals(one.getPosts(), 20.0, 0.0001);
        assertEquals(two.getPosts(), 184.0, 0.0001);

    }
    
    /**
     * tests get followers
     */
    public void testGetFollowers() {
        assertEquals(one.getFollowers(), 3000);
        assertEquals(two.getFollowers(), 3345517);

    }
    
    /**
     * tests get comments
     */
    public void testGetComments() {
        assertEquals(one.getComments(), 40);
        assertEquals(two.getComments(), 392);
    }
    
    /**
     * tests get views
     */
    public void testGetViews() {
        assertEquals(one.getViews(), 430);
        assertEquals(two.getViews(), 107240);
    }

    /**
     * tests get engagement traditional
     */
    public void testGetEngagementTraditional() {
        assertEquals(one.getEngagementTraditional(), 11.4, 0.001);
        assertEquals(two.getEngagementTraditional(), 252.4, 0.001);
        System.out.println(one.getEngagementTraditional());
        System.out.println(two.getEngagementTraditional());
    }
    
    /**
     * tests get engagement reach
     */
    public void testGetEngagementReach() {
        assertEquals(one.getEngagementReach(), 79.8, 0.001);
        assertEquals(two.getEngagementReach(), 7873.0, 0.001);
        System.out.println(one.getEngagementReach());
        System.out.println(two.getEngagementReach());
    }
}
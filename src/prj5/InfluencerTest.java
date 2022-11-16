package prj5;

import student.TestCase;
/**
 * @author ramamittal
 *
 */
public class InfluencerTest extends TestCase {

    private Influencer one;
    private Influencer two;
    /**
     * 
     */
    public void setUp() {
        one = new Influencer("January", "sushi123", 
            "foodies", "Japan", "Food", 303, 20, 
            3000, 40, 430);
        
        two = new Influencer("March", "jade", 
            "geektechlife", "US", "Tech", 8442643, 
            184, 3345517, 392, 107240);
    }
    
    public void testGetMonth() {
        assertEquals(one.getMonth(), "January");
        assertEquals(two.getMonth(), "March");
        
    }
    
    public void testGetUsername() {
        assertEquals(one.getUsername(), "sushi123");
        assertEquals(two.getUsername(), "jade");

    }
    
    public void testGetChannelName() {
        assertEquals(one.getChannelName(), "foodies");
        assertEquals(two.getChannelName(), "geektechlife");
    }
    
    public void testGetCountry() {
        assertEquals(one.getCountry(), "Japan");
        assertEquals(two.getCountry(), "US");
    }
    
    public void testGetMainTopic() {
        assertEquals(one.getMainTopic(), "Food");
        assertEquals(two.getMainTopic(), "Tech");

    }
    
    public void testGetLikes() {
        assertEquals(one.getLikes(), 303);
        assertEquals(two.getLikes(), 8442643);

    }
    
    public void testGetPosts() {
        assertEquals(one.getPosts(), 20);
        assertEquals(two.getPosts(), 184);

    }
    
    public void testGetFollowers() {
        assertEquals(one.getFollowers(), 3000);
        assertEquals(two.getFollowers(), 3345517);

    }
    
    public void testGetComments() {
        assertEquals(one.getComments(), 40);
        assertEquals(two.getComments(), 392);
    }
    
    public void testGetViews() {
        assertEquals(one.getViews(), 430);
        assertEquals(two.getViews(), 107240);
    }

}

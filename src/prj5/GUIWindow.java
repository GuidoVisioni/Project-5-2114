package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import list.AList;

public class GUIWindow {
    
    private Window window;
    private Button sortByName;
    private Button sortByEngagementRate;
    private Button quit;
    private Button traditionalEngage;
    private Button reachEngage;
    private Button janButton;
    private Button febButton;
    private Button marchButton;
    private Button quarterButton;
    private TextShape timeFrame;
    private TextShape engagementType;
    private TextShape sortingLabel;
    private AList<Shape> influencerBars;
    private AList<TextShape> barLabels;
    private InfluencerCalculator data;
    
    /**
     * creates a new GUIWindow object
     * @param calculator
     *     the InfluencerCalculator being used to format the data
     */
    public GUIWindow(InfluencerCalculator calculator) {
        window = new Window();
        window.setTitle("hsabbott, rama04, gjvisioni25");
        data = calculator;
        
        //initialize buttons
        sortByName = new Button("Sort by Name");
        sortByName.onClick("clickedSortName");
        window.addButton(sortByName, WindowSide.NORTH);
        
        sortByEngagementRate = new Button("Sort by Engagement Rate");
        sortByEngagementRate.onClick("clickedSortEngagement");
        window.addButton(sortByEngagementRate, WindowSide.NORTH);
        
        quit = new Button("Quit");
        quit.onClick("clickedQuit");
        window.addButton(quit, WindowSide.NORTH);
        
        traditionalEngage = new Button("Traditional Engagement Rate");
        traditionalEngage.onClick("clickedTradEngage");
        window.addButton(traditionalEngage, WindowSide.WEST);
        
        reachEngage = new Button("Reach Engagement");
        reachEngage.onClick("clickedReachEngage");
        window.addButton(reachEngage, WindowSide.WEST);
        
        janButton = new Button("January");
        janButton.onClick("clickedMonth");
        window.addButton(janButton, WindowSide.SOUTH);
        
        febButton = new Button("February");
        febButton.onClick("clickedMonth");
        window.addButton(febButton, WindowSide.SOUTH);
        
        marchButton = new Button("March");
        marchButton.onClick("clickedMonth");
        window.addButton(marchButton, WindowSide.SOUTH);
        
        quarterButton = new Button("First Quarter");
        quarterButton.onClick("clickedQuarter");
        window.addButton(quarterButton, WindowSide.SOUTH);
        
        
        
    }
    
    public void clickedSortName(Button button) {
        
    }
    
    public void clickedSortEngagement(Button button) {
        
    }
    
    public void clickedQuit(Button button) {
        
    }
    
    public void clickedTradEngage(Button button) {
        
    }
    
    public void clickedReachEngage(Button button) {
        
    }
    
    public void clickedMonth(Button button) {
        
    }
    
    public void clickedQuarter(Button button) {
        
    }
    
    private String[] clickedDifferentMonths() {
        return null;
    }
    
    private SinglyLinkedList<Influencer> getDataForMonth(String month) {
        return null;
    }
}

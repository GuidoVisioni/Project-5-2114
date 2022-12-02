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
    private Shape rect1;
    private Shape rect2;
    private Shape rect3;
    private Shape rect4;
    
    /**
     * creates a new GUIWindow object
     * 
     * @param calculator
     *            the InfluencerCalculator being used to format the data
     */
    public GUIWindow(InfluencerCalculator calculator) {
        window = new Window();
        window.setTitle("hsabbott, rama04, gjvisioni25");
        data = calculator;

        // initialize buttons
        sortByName = new Button("Sort by Channel Name");
        sortByName.onClick(this, "clickedSortName");
        window.addButton(sortByName, WindowSide.NORTH);

        sortByEngagementRate = new Button("Sort by Engagement Rate");
        sortByEngagementRate.onClick(this, "clickedSortEngagement");
        window.addButton(sortByEngagementRate, WindowSide.NORTH);

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        window.addButton(quit, WindowSide.NORTH);

        traditionalEngage = new Button("Traditional Engagement Rate");
        traditionalEngage.onClick(this, "clickedTradEngage");
        window.addButton(traditionalEngage, WindowSide.WEST);

        reachEngage = new Button("Reach Engagement");
        reachEngage.onClick(this, "clickedReachEngage");
        window.addButton(reachEngage, WindowSide.WEST);

        janButton = new Button("January");
        janButton.onClick(this, "clickedMonth");
        window.addButton(janButton, WindowSide.SOUTH);

        febButton = new Button("February");
        febButton.onClick(this, "clickedMonth");
        window.addButton(febButton, WindowSide.SOUTH);

        marchButton = new Button("March");
        marchButton.onClick(this, "clickedMonth");
        window.addButton(marchButton, WindowSide.SOUTH);

        quarterButton = new Button("First Quarter (Jan - March)");
        quarterButton.onClick(this, "clickedQuarter");
        window.addButton(quarterButton, WindowSide.SOUTH);
        
        timeFrame = new TextShape(1, 1, "January");
        window.addShape(timeFrame);

        engagementType = new TextShape(1, 21, "Traditional Engagement Rate");
        window.addShape(engagementType);
        
        sortingLabel = new TextShape(1, 41, "Sorting by Engagement Rate");
        window.addShape(sortingLabel);
        
        
        window.addShape(new Shape(100, 100, 10, 10));
    }

    // If traditional engagement rate or reach engagement rate from the
    // influencer class return -1 then depict N/A for those values on the GUI


    public void clickedSortName(Button button) {
        sortingLabel.setText("Sorting by Channel Name");
        ComparatorAlphabetical c = new ComparatorAlphabetical();
        data.sort(c);
    }


    public void clickedSortEngagement(Button button) {
        sortingLabel.setText("Sorting by Engagement Rate");
        ComparatorER c = new ComparatorER();
        data.sort(c);
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public void clickedTradEngage(Button button) {
        engagementType.setText("Traditional Engagement Rate");
    }


    public void clickedReachEngage(Button button) {
        engagementType.setText("Reach Engagement Rate");
    }

    
    public void clickedMonth(Button button) {
        String month = button.getTitle().toLowerCase();
        if (month.equals("january")) {
            timeFrame.setText("January");
        }
        else if (month.equals("february")) {
            timeFrame.setText("February");
        }
        else {
            timeFrame.setText("March");
        }
    }


    public void clickedQuarter(Button button) {
        timeFrame.setText("First Quarter (Jan - March)");
    }


    private String[] clickedDifferentMonths() {
        return null;
    }


    private SinglyLinkedList<Influencer> getDataForMonth(String month) {
        return null;
    }
}

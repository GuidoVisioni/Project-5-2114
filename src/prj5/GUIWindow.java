package prj5;

import static org.junit.Assert.assertArrayEquals;
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
    private InfluencerCalculator data;
    private String timePeriod;
    private Shape rect1;
    private Shape rect2;
    private Shape rect3;
    private Shape rect4;
    private TextShape rectLabel1;
    private TextShape rectLabel2;
    private TextShape rectLabel3;
    private TextShape rectLabel4;
    private AList<Shape> bars;
    private AList<TextShape> barLabels;
    
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
        
        rect1 = new Shape(0,0);
        rect2 = new Shape(0,0);
        rect3 = new Shape(0,0);
        rect4 = new Shape(0,0);
        
        rectLabel1 = new TextShape(0,0, "");
        rectLabel2 = new TextShape(0,0, "");
        rectLabel3 = new TextShape(0,0, "");
        rectLabel4 = new TextShape(0,0, "");
        
        bars = new AList<Shape>();
        bars.add(rect1);
        bars.add(rect2);
        bars.add(rect3);
        bars.add(rect4);
        
        barLabels = new AList<TextShape>();
        barLabels.add(rectLabel1);
        barLabels.add(rectLabel2);
        barLabels.add(rectLabel3);
        barLabels.add(rectLabel4);
    }

    // If traditional engagement rate or reach engagement rate from the
    // influencer class return -1 then depict N/A for those values on the GUI

    public void clickedSortName(Button button) {
        sortingLabel.setText("Sorting by Channel Name");
        ComparatorAlphabetical c = new ComparatorAlphabetical();
        data.sortTraditional(c);
        if (timePeriod.equals("january")) {
            updateBars(data.getJanInfluencers());
        }
        else if (timePeriod.equals("february")) {
            updateBars(data.getFebInfluencers());
        }
        else if (timePeriod.equals("march")) {
            updateBars(data.getMarInfluencers());
        }
    }


    public void clickedSortEngagement(Button button) {
        sortingLabel.setText("Sorting by Engagement Rate");
        if (timePeriod.equals("january")) {
            updateBars(data.getJanInfluencers());
        }
        else if (timePeriod.equals("february")) {
            updateBars(data.getFebInfluencers());
        }
        else if (timePeriod.equals("march")) {
            updateBars(data.getMarInfluencers());
        }
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public void clickedTradEngage(Button button) {
        engagementType.setText("Traditional Engagement Rate");
        ComparatorER c = new ComparatorER();
        data.sortTraditional(c);
        if (timePeriod.equals("january")) {
            updateBars(data.getJanInfluencers());
        }
        else if (timePeriod.equals("february")) {
            updateBars(data.getFebInfluencers());
        }
        else if (timePeriod.equals("march")) {
            updateBars(data.getMarInfluencers());
        }
    }


    public void clickedReachEngage(Button button) {
        engagementType.setText("Reach Engagement Rate");
        ComparatorER c = new ComparatorER();
        data.sortReach(c);
        if (timePeriod.equals("january")) {
            updateBars(data.getJanInfluencers());
        }
        else if (timePeriod.equals("february")) {
            updateBars(data.getFebInfluencers());
        }
        else if (timePeriod.equals("march")) {
            updateBars(data.getMarInfluencers());
        }
    }

    
    public void clickedMonth(Button button) {
        String month = button.getTitle().toLowerCase();
        if (month.equals("january")) {
            timeFrame.setText("January");
            timePeriod = "january";
            updateBars(data.getJanInfluencers());
        }
        else if (month.equals("february")) {
            timeFrame.setText("February");
            timePeriod = "february";
            updateBars(data.getFebInfluencers());
        }
        else {
            timeFrame.setText("March");
            timePeriod = "march";
            updateBars(data.getMarInfluencers());
        }
    }


    public void clickedQuarter(Button button) {
        timeFrame.setText("First Quarter (Jan - March)");
        timePeriod = "quarter";
        
//        SinglyLinkedList<Influencer> firstQInf =
//            new SinglyLinkedList<Influencer>();
//        int entry = 0;
//        while (entry != data.getInfluencers().getLength()) {
//            String time = data.getInfluencers().getEntry(entry).getMonth()
//                .toLowerCase();
//            if (time.equals("january") || time.equals("february") || time
//                .equals("march")) {
//                firstQInf.add(data.getInfluencers().getEntry(entry));
//            }
//            entry++;
//        }

    }


    private String[] clickedDifferentMonths() {
        return null;
    }


    private SinglyLinkedList<Influencer> getDataForMonth(String month) {
        return null;
    }
    
    private void updateBars(SinglyLinkedList<Influencer> list) {
        for (int k = 0; k < 4; k++) {
            window.removeShape(bars.getEntry(k));
            window.removeShape(barLabels.getEntry(k));
        }
        for (int i = 0; i < list.getLength(); i++) {
            String barName = list.getEntry(i).getChannelName();
            double engage = list.getEntry(i).getPosts();
            System.out.println(engage);
            int height = (int)Math.round(engage);
            Shape rect = new Shape(70 * (i+1), 200 - height, 30, height);
            bars.replace(i, rect);
            TextShape rectLabel = new 
                TextShape(70 * (i + 1), 200 - height, barName + engage);
            barLabels.replace(i, rectLabel);
        }
        for (int j = 0; j < 4; j++) {
            window.addShape(bars.getEntry(j));
            window.addShape(barLabels.getEntry(j));
        }
    }
}
package prj5;

import static org.junit.Assert.assertArrayEquals;
import java.util.Comparator;
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

        rect1 = new Shape(0, 0);
        rect2 = new Shape(0, 0);
        rect3 = new Shape(0, 0);
        rect4 = new Shape(0, 0);

        rectLabel1 = new TextShape(0, 0, "");
        rectLabel2 = new TextShape(0, 0, "");
        rectLabel3 = new TextShape(0, 0, "");
        rectLabel4 = new TextShape(0, 0, "");

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

        ComparatorER c = new ComparatorER();
        data.sortTraditional(c);
        updateBars(data.getJanInfluencers());
        timePeriod = "january";
    }

    // If traditional engagement rate or reach engagement rate from the
    // influencer class return -1 then depict N/A for those values on the GUI


    public void clickedSortName(Button button) {
        sortingLabel.setText("Sorting by Channel Name");
        ComparatorAlphabetical c = new ComparatorAlphabetical();

        if (timePeriod.equals("quarter")) {
            if (engagementType.getText().contains("Traditional")) {
                data.sortTraditionalQuart(c);
                updateBars(data.getFebInfluencers());
            }
            else {
                data.sortReachQuart(c);
                updateBars(data.getFebInfluencers());
            }
        }
        else if (engagementType.getText().contains("Traditional")) {
            data.sortTraditional(c);
        }
        else {
            data.sortReach(c);
        }
        
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
        ComparatorER c = new ComparatorER();
        
        if (timePeriod.equals("quarter")) {
            if (engagementType.getText().contains("Traditional")) {
                data.sortTraditionalQuart(c);
                updateBars(data.getFebInfluencers());
            }
            else {
                data.sortReachQuart(c);
                updateBars(data.getFebInfluencers());
            }
        }
        else if (engagementType.getText().contains("Traditional")) {
            data.sortTraditional(c);
        }
        else {
            data.sortReach(c);
        }
        if (timePeriod.equals("january")) {
            updateBars(data.getJanInfluencers());
        }
        else if (timePeriod.equals("february")) {
            updateBars(data.getFebInfluencers());
        }
        else if (timePeriod.equals("march")) {
            updateBars(data.getMarInfluencers());
        }
        else if (timePeriod.equals("quarter")) {
            if (engagementType.getText().contains("Traditional")) {
                data.getTradEngageForQuart();
                updateBars(data.getFebInfluencers());
            }
            else {
                data.getEngageReachForQuart();
                updateBars(data.getFebInfluencers());
            }
        }
    }


    public void clickedQuit(Button button) {
        System.exit(0);
    }


    public void clickedTradEngage(Button button) {
        engagementType.setText("Traditional Engagement Rate");
        Comparator<Influencer> c;
        if (sortingLabel.getText().contains("Channel")) {
            c = new ComparatorAlphabetical();
        }
        else {
            c = new ComparatorER();
        }
        if (timePeriod.equals("january")) {
            data.sortTraditional(c);
            updateBars(data.getJanInfluencers());
        }
        else if (timePeriod.equals("february")) {
            data.sortTraditional(c);
            updateBars(data.getFebInfluencers());
        }
        else if (timePeriod.equals("march")) {
            data.sortTraditional(c);
            updateBars(data.getMarInfluencers());
        }
        else if (timePeriod.equals("quarter")) {
            data.getTradEngageForQuart();
            data.sortTraditionalQuart(c);
            updateBars(data.getFebInfluencers());
        }
    }


    public void clickedReachEngage(Button button) {
        engagementType.setText("Reach Engagement Rate");
        Comparator<Influencer> c;
        if (sortingLabel.getText().contains("Channel")) {
            c = new ComparatorAlphabetical();
        }
        else {
            c = new ComparatorER();
        }
        if (timePeriod.equals("january")) {
            data.sortReach(c);
            updateBars(data.getJanInfluencers());
        }
        else if (timePeriod.equals("february")) {
            data.sortReach(c);
            updateBars(data.getFebInfluencers());
        }
        else if (timePeriod.equals("march")) {
            data.sortReach(c);
            updateBars(data.getMarInfluencers());
        }
        else if (timePeriod.equals("quarter")) {
            data.getEngageReachForQuart();
            data.sortReachQuart(c);
            updateBars(data.getFebInfluencers());
        }
    }


    public void clickedMonth(Button button) {
        String month = button.getTitle().toLowerCase();
        if (month.equals("january")) {
            timeFrame.setText("January");
            timePeriod = "january";
            Comparator<Influencer> c;
            if (sortingLabel.getText().contains("Channel")) {
                c = new ComparatorAlphabetical();
                if (engagementType.getText().contains("Traditional")) {
                    data.sortTraditional(c);
                }
                else {
                    data.sortReach(c);
                }
            }
            else {
                c = new ComparatorER();
                if (engagementType.getText().contains("Traditional")) {
                    data.sortTraditional(c);
                }
                else {
                    data.sortReach(c);
                }
            }
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
        Comparator<Influencer> c;
        if (sortingLabel.getText().contains("Channel")) {
            c = new ComparatorAlphabetical();
            if (engagementType.getText().contains("Traditional")) {
                data.getTradEngageForQuart();
                data.sortTraditionalQuart(c);
                updateBars(data.getFebInfluencers());
            }
            else {
                data.getEngageReachForQuart();
                data.sortReachQuart(c);
                updateBars(data.getFebInfluencers());
            }
        }
        else {
            c = new ComparatorER();
            if (engagementType.getText().contains("Traditional")) {
                data.getTradEngageForQuart();
                data.sortTraditionalQuart(c);
                updateBars(data.getFebInfluencers());
            }
            else {
                data.getEngageReachForQuart();
                data.sortReachQuart(c);
                updateBars(data.getFebInfluencers());
            }
        }
    }


    private void updateBars(SinglyLinkedList<Influencer> list) {
        for (int k = 0; k < 4; k++) {
            window.removeShape(bars.getEntry(k));
            window.removeShape(barLabels.getEntry(k));
        }
        for (int i = 0; i < list.getLength(); i++) {
            String barName = list.getEntry(i).getChannelName();
            double engage = list.getEntry(i).getPosts();
            int height = (int)Math.round(engage);
            Shape rect = new Shape(180 * (i + 1), 300 - height, 30, height);
            bars.replace(i, rect);
            TextShape rectLabel;
            if (engage == -1.0) {
                rectLabel = new TextShape(180 * (i + 1), 300, barName + "  "
                    + "N/A");
            }
            else {
                rectLabel = new TextShape(180 * (i + 1), 300, barName + "  "
                    + engage);
            }
            barLabels.replace(i, rectLabel);
        }
        for (int j = 0; j < 4; j++) {
            window.addShape(bars.getEntry(j));
            window.addShape(barLabels.getEntry(j));
        }
    }
}

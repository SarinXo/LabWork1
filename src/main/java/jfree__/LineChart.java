package jfree__;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.chart.ui.UIUtils;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends ApplicationFrame {

    public static void showChart(ApplicationFrame chart) {
        chart.pack( );
       // UIUtils RefineryUtilities = null;
        chart.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        UIUtils.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
    public LineChart(DefaultCategoryDataset dataset,
                     String applicationTitle ,
                     String chartTitle,
                     String categoryAxisLabel,
                     String categoryAyisLabel,
                     int width, int height) {

        super(applicationTitle);
        JFreeChart Chart = chartType(chartTitle, categoryAxisLabel, categoryAyisLabel, dataset);
        ChartPanel chartPanel = new ChartPanel( Chart );
        chartPanel.setPreferredSize( new java.awt.Dimension( width , height ) );
        setContentPane( chartPanel );
    }


    public JFreeChart chartType(String chartTitle,
                                String categoryAxisLabel,
                                String categoryAyisLabel,
                                DefaultCategoryDataset dataset) {

        return ChartFactory.createLineChart(
                chartTitle,
                categoryAxisLabel,
                categoryAyisLabel,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
        );

    }
}

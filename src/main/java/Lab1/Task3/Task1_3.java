package Lab1.Task3;

import Lab1.Task2.Task1_2;
import jfree__.BarChart;
import jfree__.LineChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class Task1_3 extends Task1_2 {
    private final List<Double[]> Data  =  addValuesData();

    public Task1_3(List<Float> row) {
        super(row);
    }

    private DefaultCategoryDataset createDataset(int indexValueData) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        Double[] str = new Double[7];
        for(var row : Data) {
            int i =0;
            for(var variable : row){
                str[i] = variable;
                i++;
            }
            dataset.addValue( str[indexValueData] , " ", str[2] );
        }
        return dataset;
    }

    private LineChart[] createPolygons(){
        return new LineChart[]{
                new LineChart(              //frequencyPolygon
                        createDataset(4),
                        "Linechart",
                        "Полигон частот",
                        "Интервалы",
                        "Кол-во чисел в интервале",
                        500, 400
                ),
                new LineChart(              //frequencyCountPolygon
                        createDataset(5),
                        "Linechart",
                        "Полигон накопленных частот",
                        "Интервалы",
                        "Кол-во чисел",
                        500, 400
                ),
                new LineChart(              //frequencyPolygon
                        createDataset(6),
                        "Linechart",
                        "Полигон относительных частот",
                        "Интервалы",
                        "Процент",
                        500, 400
                ),
                new LineChart(              //frequencyPolygon
                        createDataset(6),
                        "Linechart",
                        "Относительная накопленная частота",
                        "Интервалы",
                        "Процент",
                        500, 400
                )
        };

    }

    private BarChart[] createHistogram(){
        return new BarChart[]{
                new BarChart(              //frequencyPolygon
                        createDataset(4),
                        "BarChart",
                        "Полигон частот",
                        "Интервалы",
                        "Кол-во чисел в интервале",
                        500, 400
                ),
                new BarChart(              //frequencyCountPolygon
                        createDataset(5),
                        "BarChart",
                        "Полигон накопленных частот",
                        "Интервалы",
                        "Кол-во чисел",
                        500, 400
                ),
                new BarChart(              //frequencyPolygon
                        createDataset(6),
                        "BarChart",
                        "Полигон относительных частот",
                        "Интервалы",
                        "Процент",
                        500, 400
                ),
                new BarChart(              //frequencyPolygon
                        createDataset(6),
                        "BarChart",
                        "Относительная накопленная частота",
                        "Интервалы",
                        "Процент",
                        500, 400
                )
        };
    }

    public void Task3(){
        LineChart[] Lch = createPolygons();
        for(var i : Lch)
            LineChart.showChart(i);

        BarChart[] Bch = createHistogram();
        for(var i : Bch)
            BarChart.showChart(i);
    }
}

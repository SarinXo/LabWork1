package Lab1.Task2;

import inputData.inputData;
import jfree__.simpleGui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Task1_2 extends inputData {
    private final int k = (int) Math.round(1 + 3.32 * Math.log10(row_sort.size()));
    private final double h = ((double) (row_sort.get(row_sort.size() - 1) - row_sort.get(0)) / k);

    protected List<Double[]>  addValuesData() {

        List<Double[]> data = new ArrayList<>();
        //Object[][] data = new Object[k][8];
        DecimalFormat decimalFormat = new DecimalFormat("0.0000");
        double minRange = row_sort.get(0);
        double frequency = 0.0;
        double cumulativeFrequency = 0.0;
        double relativeFrequency = 0.0;
        double cumulativeRelativeFrequency = 0.0;
        int j = 0;
        for (int i = 0; i < row_sort.size(); ) {

            while (i < row_sort.size()) {
                if (row_sort.get(i) <= minRange + h) {
                    frequency++;
                    i++;
                } else {
                    break;
                }
            }
//            data[j][0] = decimalFormat.format(j + 1);
//            data[j][1] = decimalFormat.format(minRange);
//            data[j][2] = decimalFormat.format(minRange + h);
//            data[j][3] = decimalFormat.format((minRange * 2 + h) / 2);
//            data[j][4] = decimalFormat.format(frequency);
            cumulativeFrequency += frequency;
//            data[j][5] = decimalFormat.format(cumulativeFrequency);
            relativeFrequency = frequency / row_sort.size();
//            data[j][6] = decimalFormat.format(relativeFrequency);
            cumulativeRelativeFrequency += relativeFrequency;
//            data[j][7] = decimalFormat.format(cumulativeRelativeFrequency);
            data.add(new Double[]{minRange,(minRange + h),(((minRange * 2) + h) / 2),frequency,cumulativeFrequency,relativeFrequency,cumulativeRelativeFrequency});
            j++;
            minRange += h;
            frequency = 0.0;
        }

        return data;
    }

    private void Table() {
        JFrame frame = simpleGui.frameDefault("Задание 2", 1000, 200);
        String[] columns = {"№", "Нижняя граница", "Верхняя граница", "Середина", "Частота", "Накопленная частота", "Относительная частота", "Относительная накопленная частота"};

        //Object[][] data = addValuesData();

        List<Double[]> Data= addValuesData();
         Object[] str = new Object[8];
         int numbering = 1;
         DefaultTableModel TModel = new DefaultTableModel(columns,0);

        for(var row : Data) {
           int i = 1;
            str[0] = numbering;
            for(var varaible : row){
                str[i] = new DecimalFormat("#0.0000").format(varaible);
                i++;
            }
            numbering++;
            TModel.addRow(str);
        }

        simpleGui.scrollDefault(new JTable(TModel), frame, 900, 150);

    }

    public void Task2() {
        Table();
    }
}

package inputData;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public  class inputData {
    protected List<Float> row_sort = new ArrayList<>();

    public inputData() {
        List<Float> row;
        readFile read = new readFile();
        File file = new File("src/row");
        try {
            row = new ArrayList<>(read.readFileIntoList(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        row_sort.addAll(row);
        row_sort.sort(Comparator.naturalOrder());
    }

}


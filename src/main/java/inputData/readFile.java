package inputData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class readFile {
    public ArrayList<Float> readFileIntoList(File file) throws FileNotFoundException {
        ArrayList<Float> result = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        String line = scanner.nextLine();
        String[] numbersString = line.split(" ");
        for (String number : numbersString) {
            result.add(Float.parseFloat(number));
        }
        return result;
    }
}

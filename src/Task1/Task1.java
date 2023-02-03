package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    private final ArrayList<Float> readFileIntoList(File file) throws FileNotFoundException {
        ArrayList<Float> result = new ArrayList<Float>();
        Scanner scanner=new Scanner(file);
        String line=scanner.nextLine();
        String[]numbersString=line.split(" ");
        int i=0;
        for (String number:numbersString) {
            result.add(Float.parseFloat(number));
        }
        return result;
    }
    public void Task_1() throws FileNotFoundException {
    ArrayList<Float>length_of_the_esophagus= new ArrayList<Float>();
    File file=new File("src/row");
    length_of_the_esophagus.addAll(readFileIntoList(file));
    

    System.out.println(length_of_the_esophagus);
} }

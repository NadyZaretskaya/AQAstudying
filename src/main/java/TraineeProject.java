import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static java.lang.Math.abs;

public class TraineeProject {
    public static void main (String[] args) {
        WorkWithFile workWithFile = new WorkWithFile();
        ArrayList<Integer> ints = workWithFile.getIntegerListFromFile(new File("numbers.csv"));
        ArrayList<Integer> newInts = createAbsList(ints);
        workWithFile.writeToFile(newInts, new File("newNumbers.csv"));
        List<String> newStrList = workWithFile.getStringListFromFile(new File("stringFile.txt"));
        workWithFile.writeToFileWithExclusion(newStrList, "nullable", new File("stringFileWithExclusion.txt"));
    }

    public static ArrayList<Integer> createAbsList (List list) {
        Iterator<Integer> iter = list.iterator();
        ArrayList<Integer> newList = new ArrayList<>();
             while (iter.hasNext()) {
                newList.add(abs(iter.next()));
             }
        return newList;
    }

}

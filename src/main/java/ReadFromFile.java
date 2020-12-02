import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    public ArrayList<Integer> readFromFile(File file) {
        ArrayList<Integer> numberList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while (reader.ready()){
                String [] str = reader.readLine().split(", ");
                for (String s: str) {
                    Integer i = Integer.parseInt(s);
                    numberList.add(i);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberList;
    }

}

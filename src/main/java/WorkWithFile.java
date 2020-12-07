import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkWithFile {
    final static Logger logger =
            LogManager.getLogger(WorkWithFile.class.getName());

    public ArrayList<Integer> getIntegerListFromFile(File file) {
        ArrayList<Integer> numberList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            while (reader.ready()){
                String [] str = reader.readLine().split(", ");
                for (String s: str) {
                    try {
                        Integer i = Integer.parseInt(s);
                        numberList.add(i);
                    }
                    catch (NumberFormatException e) {
                        logger.info("Trying to read not a number.", e);
                    }
                }
            }
        } catch (IOException e) {
            logger.fatal("Unable to open file.", e);
        }
        return numberList;
    }

    public List<String> getStringListFromFile(File file) {
        List<String> myStingList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while (br.ready()) {
                myStingList.add(br.readLine());
            }
        } catch (IOException e) {
            logger.fatal("Unable to open file.", e);
        }
        return myStingList;
    }



    public <T> void writeToFile (List<T> list, File file){
        try{
            FileWriter writer = new FileWriter(file);
            for(T line : list)
            {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.close();
        }catch (IOException ex)
        {
            logger.fatal(ex);
        }

    }

    public <T> void writeToFileWithExclusion(List <T> list, T value, File file) {
        try{
            List <T> listWithExclusion = list.stream().
                    filter(x -> !x.equals(value)).
                    collect(Collectors.toList());
            FileWriter writer = new FileWriter(file);
            for(T line : listWithExclusion)
            {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
            }
            writer.close();
        }catch (IOException ex)
        {
            logger.fatal(ex);
        }
    }

    public <T> List<T> getListFromArray (T[] arr){
        List <T> myList = new ArrayList<>();
        for(int i = 0; i<arr.length; i++){
              myList.add(arr[i]);
        }
        return myList;
    }

}

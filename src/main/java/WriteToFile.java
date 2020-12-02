import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class WriteToFile {

    public void writeToFile (ArrayList list, File file){

//        try{
//            FileOutputStream fileOut = new FileOutputStream(file);
//            ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
//
//            objOut.writeObject(list);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        try{
            FileWriter writer = new FileWriter(file);

            for(Object line : list)
            {
                writer.write((Integer) line);
                writer.write(System.getProperty("line.separator"));
            }

            writer.close();
        }catch (IOException ex)
        {
            ex.printStackTrace();
        }


    }

}

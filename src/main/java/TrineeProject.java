import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.lang.Math.*;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class TrineeProject {
    public static void main (String[] args) {
        ReadFromFile read = new ReadFromFile();
        WriteToFile write = new WriteToFile();
        ArrayList<Integer> ints = read.readFromFile(new File("numbers.csv"));
        ArrayList<Integer> newInts = createAbsList(ints);
        write.writeToFile(newInts, new File("newNumbers.csv"));
        for (int i: newInts) {
            System.out.println(i);
        }

    }


        public static ArrayList<Integer> createAbsList (ArrayList list) {
            Iterator<Integer> iter = list.iterator();
            ArrayList<Integer> newList = new ArrayList<>();
            while (iter.hasNext()) {
                newList.add(abs(iter.next()));
            }

//            ArrayList<Integer> newList = list.stream()
//                    .map(Math::abs)
//                    .collect(Collectors.toList());
//            System.out.println(newList);
            return newList;
        }



//    public <T> List<T> getListFromArray (T[] arr){
//        List <T> myList = new ArrayList<T>();
//        for(int i = 0; i<arr.length; i++){
//              myList.add(arr[i]);
//        }
//        return myList;
//    }
}

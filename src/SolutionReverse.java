import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

/*
Read in from inputReverse.txt
Each line contains a number. Hint: read into a list of type List<Integer>
Write numbers to outputReverse.txt from lowest to highest
 */
public class SolutionReverse {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("inputReverse.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("outputReverse.txt");
        String line = reader.readLine();
        String[] split = line.split(" ");
        List<String> list = Arrays.asList(split);
//        List<String> list = new ArrayList(Arrays.asList(split));

        Arrays.sort(split);
        Collections.reverse(list);

        for (String s : split) {
            System.out.println("s = " + s);
        }

        reader.close();
        fileWriter.close();

    }
}

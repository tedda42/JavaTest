import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SolutionTriple {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("tripin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("tripout.txt");

        int n = Integer.parseInt(reader.readLine());
        int num;
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(reader.readLine());
            if (num % 3 == 0) {
                list.add(i);
            }
        }
        if (list.isEmpty()) {
            fileWriter.write("Nothing here!");
        } else {
            fileWriter.write(list.size() + "\n");
            for (Integer integer : list) {
                fileWriter.write(integer + " ");
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}

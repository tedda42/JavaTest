import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class SolutionTriple {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("tripin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("tripout.txt");

        int n = Integer.parseInt(reader.readLine());
        int num;
        int[] list = new int[n];
        int count = 0;
        for (int i = 1; i <= n; i++) {
            num = Integer.parseInt(reader.readLine());
            if (num % 3 == 0) {
                list[count++] = i;
            }
        }
        if (count == 0) {
            fileWriter.write("Nothing here!");
        } else {
            fileWriter.write(count + "\n");
            for (int i = 0; i < count; i++) {
                fileWriter.write(list[i] + " ");

            }
        }

        fileReader.close();
        fileWriter.close();
    }
}

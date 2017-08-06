import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws Exception {
        int numBacteria = getNumBacteria();
        int b = numBacteria;
        int d = 0;
        while (b % 2 == 0) {
            b = b/2;
            d++;
        }
        System.out.println(numBacteria);
        writeAnswer(b, d);
    }

    private static void writeAnswer(int b, int d) throws IOException {
        FileWriter fileWriter = new FileWriter("output.txt");
        fileWriter.write( b + " " + d);
        fileWriter.close();
    }

    private static int getNumBacteria() throws IOException {
        FileReader fileReader = new FileReader("input.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        reader.close();
        return Integer.parseInt(line);
    }
}

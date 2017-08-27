import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class SolutionSculptureII {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("artin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("artout.txt");
        String line = reader.readLine();
        int numBlocks = Integer.parseInt(line);
        int[] t = new int[numBlocks];
//        int[] w = new int[numBlocks];
        int[] h = new int[numBlocks];
        int[] H = new int[numBlocks];
        int[] W = new int[numBlocks];//Width from furthest right point of structure
        for (int i = 0; i < numBlocks; i++) {
            String block = reader.readLine();
            String[] split = block.split(" ");
            t[i] = Integer.parseInt(split[0]);
//            w[i] = Integer.parseInt(split[1]);
            h[i] = Integer.parseInt(split[2]);
            W[i] = Integer.parseInt(split[1]) + t[i];
        }
        int maxHeight = 0;
        for (int i = 0; i < t.length; i++) {
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {//Search for block to land on
                if (W[j] > t[i]) {
                    H[i] = h[i] + H[j];
                    if (H[i] > maxHeight) {
                        maxHeight = H[i];
                    }
                    found = true;
                    break;
                }
            }
            if (!found) {
                H[i] = h[i];//default to current height of block
                if (H[i] > maxHeight) {
                    maxHeight = H[i];
                }
            }
        }
        fileWriter.write("" + maxHeight);
        fileReader.close();
        fileWriter.close();
    }
}
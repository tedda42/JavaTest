import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SolutionFarmerDrama {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("farmin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
//        String[] split = line.split(" ");
        int numPlots = Integer.parseInt(line);
        String s = reader.readLine();
        fileReader.close();
        String[] split = s.split(" ");
        int[] farmList = new int[split.length];
        for (int i = 0; i < numPlots; i++) {
            farmList[i] = Integer.parseInt(split[i]);
        }
//        System.out.println("farmList = " + farmList);
        int knockedDown = 0;
        int positionLeft = 0;
        int positionRight = farmList.length - 1;
        int prevSizeLeft = 0;
        int prevSizeRight = 0;
        while (positionLeft < positionRight) {
            int currSizeLeft = prevSizeLeft + farmList[positionLeft];
            int currSizeRight = prevSizeRight + farmList[positionRight];
            if (currSizeLeft == currSizeRight) {
                positionLeft++;
                positionRight--;
                prevSizeLeft = 0;
                prevSizeRight = 0;
            } else if (currSizeLeft < currSizeRight) {
                knockedDown++;
                positionLeft++;
                prevSizeLeft = currSizeLeft;
            } else {
                knockedDown++;
                positionRight--;
                prevSizeRight = currSizeRight;
            }
        }
        //System.out.println("farmList = " + farmList);
        FileWriter fileWriter = new FileWriter("farmout.txt");
        fileWriter.write("" + knockedDown);
        fileWriter.close();
    }
}
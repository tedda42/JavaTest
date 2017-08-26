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
        List<Integer> farmList = new ArrayList<Integer>();
        String s = reader.readLine();
        fileReader.close();
        String[] split = s.split(" ");
        for (int i = 0; i < numPlots; i++) {
            farmList.add(Integer.parseInt(split[i]));
        }
//        System.out.println("farmList = " + farmList);
        boolean changed = true;
        int knockedDown = 0;
        while (changed) {
            changed = false;
            for (int j = 0; j < farmList.size() / 2; ) {
                int left = farmList.get(j);
                int right = farmList.get(farmList.size() - j - 1);
                if (left == right) {
                    j++;
                    continue;
                } else if (left < right) {
                    int left1 = farmList.get(j + 1);
                    farmList.set(j + 1, left + left1);
                    farmList.remove(j);
                    changed = true;
                    knockedDown++;
                    break;
                } else if (left > right) {
                    int right1 = farmList.get(farmList.size() - j - 2);
                    farmList.set(farmList.size() - j - 2, right + right1);
                    farmList.remove(farmList.size() - j - 1);
                    changed = true;
                    knockedDown++;
                    break;
                }
            }
        }
        //System.out.println("farmList = " + farmList);
        FileWriter fileWriter = new FileWriter("farmout.txt");
        fileWriter.write("" + knockedDown);
        fileWriter.close();
    }
}
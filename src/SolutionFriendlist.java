import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
//import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SolutionFriendlist {

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("listin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("listout.txt");
        String line = reader.readLine();
        int numCon = Integer.parseInt(line);
        int maxFriendCount = 0;
        SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

        for (int i = 0; i < numCon; i++) {
//            System.out.println("line = " + line);
            line = reader.readLine();
            String[] split = line.split(" ");
            maxFriendCount = getMaxFriendCount(maxFriendCount, map, Integer.parseInt(split[0]));
            maxFriendCount = getMaxFriendCount(maxFriendCount, map, Integer.parseInt(split[1]));
        }
        for (Map.Entry<Integer, Integer> user : map.entrySet()) {
            if (user.getValue().intValue() == maxFriendCount) {
//                System.out.println("user.getKey() = " + user.getKey());
                fileWriter.write("" + user.getKey() + "\n");
            }
        }
        fileReader.close();
        fileWriter.close();
    }

    private static int getMaxFriendCount(int maxFriendCount, Map<Integer, Integer> map, Integer key) {
        if (map.containsKey(key)) {
            Integer friendCount = map.get(key);
            friendCount++;
            if (friendCount > maxFriendCount) {
                maxFriendCount = friendCount;
            }
            map.put(key, friendCount);
        } else {
            map.put(key, 1);
        }
        return maxFriendCount;
    }
}

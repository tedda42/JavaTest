import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

class SolutionMagicSquares {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("magicin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("magicout.txt");

        int[][] grid = new int[3][3];

        String line = reader.readLine();
        String[] split = line.split(" ");
        grid[0][0] = Integer.parseInt(split[0]);
        grid[0][1] = Integer.parseInt(split[1]);
        grid[1][0] = Integer.parseInt(split[2]);

        boolean found = false;
        for (int i = 1; i <= 20 && !found; i++) {
            int magic = grid[0][0] + grid[0][1] + i;
            grid[0][2] = i;
            grid[2][0] = magic - grid[0][0] - grid[1][0];
            if (grid[2][0] <= 0) {
                continue;
            }
            for (int j = 1; j <= 20 && !found; j++) {
                grid[1][1] = j;
                grid[1][2] = magic - j - grid[1][0];
                if (grid[1][2] <= 0) {
                    continue;
                }
                grid[2][1] = magic - j - grid[0][1];
                if (grid[2][1] <= 0) {
                    continue;
                }
                grid[2][2] = magic - grid[1][2] - grid[0][2];
                if (grid[2][2] <= 0) {
                    continue;
                }
                if (grid[2][0] + grid[2][1] + grid[2][2] == magic) {
                    found = true;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            for (int j = 0; j < row.length; j++) {
                int num = row[j];
                fileWriter.write(num + " ");
            }
            fileWriter.write("\n");
        }

        fileReader.close();
        fileWriter.close();
    }
}

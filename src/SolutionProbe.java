import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SolutionProbe {
    static final int E = 0;
    static final int W = 1;
    static final int L = 2;
    static final int M = 3;
    static final int Wn = -1;
    static final int Ln = -2;
    static final int Mn = -3;

    static final String[] NAMES = {"EMPTY\n", "WATER\n", "LAVA\n", "MOUNTAINS\n"};


    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("probein.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("probeout.txt");
        String line = reader.readLine();

        String[] split = line.split(" ");

        int R = Integer.parseInt(split[0]);
        int C = Integer.parseInt(split[1]);
        int rp = Integer.parseInt(split[2]) - 1;
        int cp = Integer.parseInt(split[3]) - 1;
        int rf = Integer.parseInt(split[4]) - 1;
        int cf = Integer.parseInt(split[5]) - 1;

        int[][] grid = new int[R][C];

        grid[rp][cp] = W;
        grid[rf][cf] = L;

        List<int[]> altered = new ArrayList<int[]>();
        boolean changed = true;
        while (changed) {
            altered.clear();
            changed = false;
//            System.out.println("-------------------------------");
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    System.out.print(grid[i][j] + " ");
//                }
//                System.out.println();
//            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (grid[i][j] == E) {
                        boolean sideWater = false;
                        boolean sideLava = false;
                        //Right
                        if (i < R - 1) {
                            if (grid[i + 1][j] == L) {
                                sideLava = true;
                            } else if (grid[i + 1][j] == W) {
                                sideWater = true;
                            }
                        }
                        //Left
                        if (i > 0) {
                            if (grid[i - 1][j] == L) {
                                sideLava = true;
                            } else if (grid[i - 1][j] == W) {
                                sideWater = true;
                            }
                        }
                        //Above
                        if (j < C - 1) {
                            if (grid[i][j + 1] == L) {
                                sideLava = true;
                            } else if (grid[i][j + 1] == W) {
                                sideWater = true;
                            }
                        }
                        //Below
                        if (j > 0) {
                            if (grid[i][j - 1] == L) {
                                sideLava = true;
                            } else if (grid[i][j - 1] == W) {
                                sideWater = true;
                            }
                        }
                        if (sideLava && sideWater) {
                            grid[i][j] = Mn;
                            altered.add(new int[]{i,j});
                            changed = true;
                        } else if (sideLava) {
                            grid[i][j] = Ln;
                            changed = true;
                            altered.add(new int[]{i,j});
                        } else if (sideWater) {
                            grid[i][j] = Wn;
                            changed = true;
                            altered.add(new int[]{i,j});
                        }
                    }
                }
            }
            for (int[] ints : altered) {
                grid[ints[0]][ints[1]] = -grid[ints[0]][ints[1]];
            }
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    if (grid[i][j] < 0) {
//                        grid[i][j] = -grid[i][j];
//                    }
//                }
//            }
        }

        String ques = reader.readLine();
        int Q = Integer.parseInt(ques);
        int rq;
        int cq;
        String[] coords;
        for (int i = 0; i < Q; i++) {
            String s = reader.readLine();
            coords = s.split(" ");
            rq = Integer.parseInt(coords[0]) - 1;
            cq = Integer.parseInt(coords[1]) - 1;
            int value = grid[rq][cq];
            fileWriter.write(NAMES[value]);
        }


        fileReader.close();
        fileWriter.close();
    }
}
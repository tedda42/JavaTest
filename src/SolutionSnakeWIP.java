import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class SolutionSnakeWIP {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("snakein.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("snakeout.txt");

        String line = reader.readLine();
        String[] coords = line.split(" ");
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        System.out.println("line = " + line);
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        String ans = "";

        int xd = x;
        int yd = y;
        int face = 1;

        if (y < 0) {
            if (x < 0){
                ans = "LL";
            } else {
                ans = "RR";
            }
            xd--;
            yd--;
            face = 3;
        }

        int min = Math.min(Math.abs(xd), Math.abs(yd));
        if (min > 0) {//Keep moving until in line with one coordinate
            String wig;
            int xdir;
            int ydir;
            if (x > 0 && y > 0) {
                wig = "RL";
                xdir = 1;
                ydir = 1;
            } else if (x < 0 && y > 0) {
                wig = "LR";
                xdir = -1;
                ydir = 1;
            } else if (x > 0 && y < 0) {
                wig = "LR";
                xdir = 1;
                ydir = -1;
            } else {//if (x < 0 && y < 0) {
                wig = "RL";
                xdir = -1;
                ydir = -1;
            }
            for (int i = 0; i < min; i++) {
                ans = ans + wig;
                xd = xd - xdir;
                yd = yd - ydir;
            }
        }


//        if (x == y) {
//            if (x > 0)
//            for (int i = 0; i < x; i++) {
//                ans = ans + "RL";
//                System.out.println("i = " + i);
//                System.out.println("ans = " + ans);
//            }
//        }

        fileWriter.write(ans);

        fileReader.close();
        fileWriter.close();
    }
}

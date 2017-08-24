import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class SolutionSquare {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Rectangle {
        Point p1;
        Point p2;

        int getArea() {
            return (p2.x - p1.x) * (p2.y - p1.y);
        }

        public Rectangle(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }

        public Rectangle(String line) {
            String[] split = line.split(" ");
            p1 = new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
            p2 = new Point(Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        }
    }

    public static void main1(String[] args) throws Exception {
        assertEqual(getAtot("1 1 3 4", "2 3 6 7"), 21);
        assertEqual(getAtot("1 1 3 3", "0 0 2 2"), 7);//Bottom left
        assertEqual(getAtot("0 0 2 2", "1 1 3 3"), 7);//Top right
        assertEqual(getAtot("1 0 3 2", "0 1 2 3"), 7);//Top left
        assertEqual(getAtot("0 1 2 3", "1 0 3 2"), 7);//Bottom right
        assertEqual(getAtot("1 1 2 2", "0 0 3 3"), 9);//sq1 contained
        assertEqual(getAtot("0 0 3 3", "1 1 2 2"), 9);//sq2 contained
        assertEqual(getAtot("0 0 3 3", "0 0 3 3"), 9);//sq1 = sq2
        assertEqual(getAtot("0 0 3 3", "6 6 9 9"), 18);//No overlap
        assertEqual(getAtot("6 6 9 9", "0 0 3 3"), 18);//No overlap 2
        assertEqual(getAtot("0 0 1 1", "1 1 2 2"), 2);//No overlap but touching at a point
        assertEqual(getAtot("0 0 1 1", "0 1 1 2"), 2);//No overlap but touching at a line
        assertEqual(getAtot("0 1 4 4", "1 0 3 2"), 14);//Middle bottom

        assertEqual(getAtot("1 0 2 3", "0 1 3 2"), 5);//Middle intercept
        assertEqual(getAtot("0 1 3 2", "1 0 2 3"), 5);//Middle intercept
    }

    private static void assertEqual(int actual, int expected) {
        if (actual != expected)
            throw new RuntimeException("Actual:" + actual + " Expected:" + expected);
    }

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("bendin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("bendout.txt");
        String line = reader.readLine();
        String line2 = reader.readLine();

        int atot = getAtot(line, line2);

        fileWriter.write("" + atot);

        reader.close();
        fileWriter.close();
    }

    private static int getAtot(String line, String line2) {
        Rectangle s1 = new Rectangle(line);
        Rectangle s2 = new Rectangle(line2);

        int atot = s1.getArea() + s2.getArea();

        //Now check for intersections
        int x1 = Math.max(s1.p1.x, s2.p1.x);
        int y1 = Math.max(s1.p1.y, s2.p1.y);
        int x2 = Math.min(s1.p2.x, s2.p2.x);
        int y2 = Math.min(s1.p2.y, s2.p2.y);
        Rectangle overlap = null;
        if (x1 < x2 && y1 < y2) {
            overlap = new Rectangle(new Point(x1, y1), new Point(x2, y2));
        }
        if (overlap != null) {
            System.out.println("overlap = " + overlap.getArea());
            atot = atot - overlap.getArea();
        }
        System.out.println("atot = " + atot);
        return atot;
    }
}

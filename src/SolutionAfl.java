import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SolutionAfl {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("inputAfl.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter("outputAfl.txt");

        boolean[] row = getSeatsInitialState(reader);
//        int nextSeat = getNextSeat(row);
        int numBookings = getLineAsNum(reader);
        for (int i = 1; i <= numBookings; i++) {
            int bookingSize = getLineAsNum(reader);
            int leftMostSeat = makeBooking(bookingSize, row);
            fileWriter.write(leftMostSeat + "\n");
            System.out.println("bookingSize = " + bookingSize);
        }
        reader.close();
        fileWriter.close();
    }

    private static int makeBooking(int bookingSize, boolean[] row) {
        int nextSeatIndex = getNextSeatIndex(row);
        for (int i = 0; i < bookingSize; i++) {
            row[nextSeatIndex + i] = true;
        }
        return nextSeatIndex + 1;
    }

    private static int getNextSeatIndex(boolean[] row) {
        int nextSeatIndex = -1;
        int currSeatIndex = -1;
        int maxNumFree = 0;
        int currNumFree = 0;
        for (int i = 0; i < row.length; i++) {
            if (!row[i]) {
                if (currNumFree == 0) {
                    currSeatIndex = i;
                }
                currNumFree++;
            } else {
                if (currNumFree > maxNumFree) {
                    maxNumFree = currNumFree;
                    nextSeatIndex = currSeatIndex;
                }
                currNumFree = 0;
            }
        }
        return nextSeatIndex;
    }

    private static boolean[] getSeatsInitialState(BufferedReader reader) throws IOException {
        int seats = getLineAsNum(reader);
        int numTaken = getLineAsNum(reader);
        boolean row[] = new boolean[seats];
        for (int i = 1; i <= numTaken; i++) {
            int seatTaken = getLineAsNum(reader);
            row[seatTaken - 1] = true;
        }
        return row;
    }

    private static int getLineAsNum(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return Integer.parseInt(line);
    }
}

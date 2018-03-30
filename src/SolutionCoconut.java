import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

public class SolutionCoconut {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("cocoin.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("cocoout.txt");

        String line;
        String[] s;
        int ix = 0;
        int iy = 0;
        int id = 0;
        int cx = 0;
        int cy = 0;
        int cd = 0;

        for (int i = 0; i < 2; i++) {
            line = reader.readLine();
            s = line.split(" ");
                if (i == 0) {
                    ix = Integer.parseInt(s[0]);
                    iy = Integer.parseInt(s[1]);
                    id = Integer.parseInt(s[2]);
                } else {
                    cx = Integer.parseInt(s[0]);
                    cy = Integer.parseInt(s[1]);
                    cd = Integer.parseInt(s[2]);
                }
        }
        System.out.println("cd = " + cd);
        System.out.println("id = " + id);
        double icd = Math.sqrt((ix-cx)*(ix-cx) + (iy-cy)*(iy-cy));
        System.out.println("icd = " + icd);

        if (icd > (id + cd)) {
            fileWriter.write("no");
            System.out.println("no");
        } else if (icd >= cd && icd >= id) {//points not inside other circle
            fileWriter.write("yes");
            System.out.println("yes");
        } else if ((icd + id) < cd) {
            fileWriter.write("no");
            System.out.println("no");
        } else if ((icd + cd) < id){
            fileWriter.write("no");
            System.out.println("no");
        } else {
            fileWriter.write("yes");
        }

//        System.out.println("Arrays.asList(s) = " + Arrays.asList(s));


        fileReader.close();
        fileWriter.close();

    }
}

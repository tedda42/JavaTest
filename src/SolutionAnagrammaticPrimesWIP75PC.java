import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class SolutionAnagrammaticPrimesWIP75PC {
    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader("primes.in");
        BufferedReader reader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter("primes.out");

        String line = reader.readLine();
        int num = Integer.parseInt(line);
        int powTen = num * 10;
        for (int i = num + 1; i < powTen; i++) {
            if (isPrime(i) && isAnagramPrime(i)) {
                fileWriter.write("" + i);
                break;
            }
        }

        fileReader.close();
        fileWriter.close();
//        testPrime(1, false);
//        testPrime(2, false);
//        testPrime(3, true);
//        testPrime(7, true);
//        testPrime(11, true);
//        testPrime(13, true);
    }

    private static boolean isAnagramPrime(int i) {
        List<Integer> anagrams = getAnagrams(i);
        for (Integer anagram : anagrams) {
            if (!isPrime(anagram)) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> getAnagrams(int i) {
        List<Integer> digits = getDigits(i);
        List<List<Integer>> listOfDigits = combinationR(digits);
        List<Integer> listOfNums = new ArrayList<Integer>();
        for (List<Integer> combination : listOfDigits) {
            String num = "";
            for (int i1 : combination) {
                num += i1;
            }
            listOfNums.add(Integer.parseInt(num));
        }
        return listOfNums;
    }

    private static List<Integer> getDigits(int num) {
        String line = "" + num;
        List<Integer> digits = new ArrayList<Integer>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            Integer digit = Integer.parseInt("" + c);
            digits.add(digit);
        }
        return digits;
    }

    private static void testPrime(int num, boolean isPrime) {
        if (isPrime(num) != isPrime) {
            System.err.println("num = " + num);
        }
    }

    private static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }
        if (num == 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }

        }
        return true;
    }



    public static <T> List<List<T>> combinationR(List<T> subset) {
        List<List<T>> result = new ArrayList<List<T>>();
        if (subset.size() == 1) {
            result.add(subset);
        }
        for (int i = 0; i < subset.size(); i++) {
            List<T> copy = new ArrayList<T>(subset);
            T item = copy.remove(i);
            List<List<T>> lists = combinationR(copy);
            result.addAll(lists);
            for (List<T> list : lists) {
                list.add(0, item);
            }
        }
        return result;
    }
}

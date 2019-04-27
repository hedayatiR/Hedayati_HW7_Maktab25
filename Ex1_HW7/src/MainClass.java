import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Reference string:");
        String str1 = input.next();

        System.out.println("Enter second string to compare:");
        String str2 = input.next();

        StringPermutation sp=new StringPermutation();
        ArrayList<String> outList = new ArrayList<>();

        sp.extractPermutations(str1, outList);
        System.out.println("Resultant permutations:");
        System.out.println(outList.toString());
        System.out.println();

        if (outList.contains(str2))
            System.out.println("Pass!");
        else
            System.out.println("Fail!");
    }
}
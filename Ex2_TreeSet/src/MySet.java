import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MySet {
    public static void main(String[] args) {
        Set<Character> set1 = new TreeSet<>();
        Set<Character> set2 = new TreeSet<>();

        while (set1.size()<10){
            set1.add(generateRandomChar());
        }

        while (set2.size()<10){
            set2.add(generateRandomChar());
        }

        System.out.println("set 1 :");
        System.out.println(set1);
        System.out.println("set 2 :");
        System.out.println(set2);
        System.out.println();

        printUnionOfSets(set1 , set2);
        printIntersectionOfSets(set1 , set2);


    }
    // -------------------------------------------------------
    public static Character generateRandomChar() {
        Random rnd = new Random();
        return (char) (rnd.nextInt(26) + 'a');
    }
    // -------------------------------------------------------
    public static void printUnionOfSets(Set<Character> s1, Set<Character> s2) {
        Set<Character> unionSet = new TreeSet<>(s1);
        unionSet.addAll(s2);
        System.out.println("Union of sets:");
        System.out.println(unionSet);
        System.out.println();
    }
    // -------------------------------------------------------
    public static void printIntersectionOfSets(Set<Character> s1, Set<Character> s2) {
        Set<Character> intersectionSet = new TreeSet<>();
        for (Character ch:
             s1) {
            if (s2.contains(ch))
                intersectionSet.add(ch);
        }
        System.out.println("Intersection of sets:");
        System.out.println(intersectionSet);
    }
    // -------------------------------------------------------
}
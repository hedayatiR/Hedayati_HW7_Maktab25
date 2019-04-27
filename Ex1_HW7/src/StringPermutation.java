import java.util.ArrayList;
import java.util.HashMap;

public class StringPermutation {

    public void extractPermutations(String s, ArrayList<String> outList) {
        permutationHelper(prepareHashMap(s), "", s.length(), outList);
    }

    private HashMap<Character, Integer> prepareHashMap(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }

    private void permutationHelper(HashMap<Character, Integer> map, String permutation, int remainingChars, ArrayList<String> outList) {

        if (remainingChars == 0) {
            outList.add(permutation);
        } else {
            for (char c : map.keySet()) {

                if (map.get(c) > 0) {
                    //choose
                    String nextPermutation = permutation +
                            c;

                    map.put(c, map.get(c) - 1);

                    //explore
                    permutationHelper(map, nextPermutation, remainingChars - 1, outList);

                    //un chose
                    map.put(c, map.get(c) + 1);
                }
            }
        } // End of else of if (remainingChars == 0) {
    } // END of permutationHelper


}
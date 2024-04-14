import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

    public static List<String> getPermutation(String str, String asf) {
        List<String> permutations = new ArrayList<>();
        // asf - answer so far
        if (str.length() == 0) {
            permutations.add(asf);
            return permutations;
        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String res = str.substring(0, i) + str.substring(i + 1);
            permutations.addAll(getPermutation(res, asf + ch));
        }
        return permutations;
    }

    public static void main(String[] args) {
        System.out.println(getPermutation("abc", ""));
    }
}

import java.util.ArrayList;
import java.util.List;

/**
 * KeyPadCombination
 */
public class KeyPadCombination {

    static String[] keyPad = { ".?", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wx", "yz" };

    public static List<String> getKeyPadCombination(String str) {
        if (str.length() == 0) {
            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        char firstChar = str.charAt(0);
        str = str.substring(1);
        List<String> keyPadCombination = getKeyPadCombination(str);

        List<String> ans = new ArrayList<>();

        for (char ch : keyPad[firstChar - '0'].toCharArray()) {
            for (String item : keyPadCombination) {
                ans.add(ch + item);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getKeyPadCombination("12"));
        // System.out.println('2' - '0');
    }
}
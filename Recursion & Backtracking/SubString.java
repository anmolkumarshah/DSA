import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubString {

    public static List<String> subString(String str) {
        if (str.length() == 0) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }

        char firstChar = str.charAt(0);
        str = str.substring(1);
        List<String> res = subString(str);

        List<String> ans = new ArrayList<>();
        for (String item : res) {
            ans.add(item);
        }
        for (String item : res) {
            ans.add(firstChar + item);
        }

        // Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subString("qwersdf"));
    }
}

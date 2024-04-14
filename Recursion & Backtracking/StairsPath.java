import java.util.ArrayList;
import java.util.List;

// we can only move 1, 2 or 3 steps at a time
public class StairsPath {

    public static List<String> getStairsPath(int n) {
        List<String> temp = new ArrayList<>();
        if (n == 0) {
            temp.add("");
            return temp;
        } else if (n < 0) {
            return temp;
        }

        List<String> stairsPath1More = getStairsPath(n - 1);
        List<String> stairsPath2More = getStairsPath(n - 2);
        List<String> stairsPath3More = getStairsPath(n - 3);

        List<String> ans = new ArrayList<>();
        for (String item : stairsPath1More) {
            ans.add(1 + item);
        }
        for (String item : stairsPath2More) {
            ans.add(2 + item);
        }
        for (String item : stairsPath3More) {
            ans.add(3 + item);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getStairsPath(5));
    }
}

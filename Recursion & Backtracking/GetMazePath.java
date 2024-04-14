import java.util.ArrayList;
import java.util.List;

// ans should be in vhvh form vertical horizontal - one step at a time
public class GetMazePath {

    public static List<String> getMazePath(int sr, int sc, int dr, int dc) {

        List<String> temp = new ArrayList<>();
        if (sr == dr && sc == dc) {
            temp.add("");
            return temp;
        }

        if (sr > dr || sc > dc) {
            return temp;
        }

        List<String> mazePathHorizontal = getMazePath(sr + 1, sc, dr, dc);
        List<String> mazePathVertical = getMazePath(sr, sc + 1, dr, dc);

        List<String> ans = new ArrayList<>();
        for (String vpath : mazePathVertical) {
            ans.add("V" + vpath);
        }
        for (String hpath : mazePathHorizontal) {
            ans.add("H" + hpath);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getMazePath(0, 0, 2, 2));
    }
}

import java.util.ArrayList;
import java.util.List;

// similar to make path but allowed septs are 1,2 and 3 in terms of V H ans D diagonal 
public class GetMazePathWithJumps {

    public static List<String> getmazePathWithJumps(int sr, int sc, int dr, int dc) {

        List<String> temp = new ArrayList<>();
        if (sr == dr && sc == dc) {
            temp.add("");
            return temp;
        }

        if (sr > dr || sc > dc) {
            return temp;
        }

        List<String> mazePathHorizontal1 = getmazePathWithJumps(sr + 1, sc, dr, dc);
        List<String> mazePathHorizontal2 = getmazePathWithJumps(sr + 2, sc, dr, dc);
        List<String> mazePathHorizontal3 = getmazePathWithJumps(sr + 3, sc, dr, dc);

        List<String> mazePathVertical1 = getmazePathWithJumps(sr, sc + 1, dr, dc);
        List<String> mazePathVertical2 = getmazePathWithJumps(sr, sc + 2, dr, dc);
        List<String> mazePathVertical3 = getmazePathWithJumps(sr, sc + 3, dr, dc);

        List<String> mazePathDiagonal1 = getmazePathWithJumps(sr + 1, sc + 1, dr, dc);
        List<String> mazePathDiagonal2 = getmazePathWithJumps(sr + 2, sc + 2, dr, dc);
        List<String> mazePathDiagonal3 = getmazePathWithJumps(sr + 3, sc + 3, dr, dc);

        List<String> ans = new ArrayList<>();
        for (String vpath : mazePathVertical1) {
            ans.add("V1" + vpath);
        }
        for (String vpath : mazePathVertical2) {
            ans.add("V2" + vpath);
        }
        for (String vpath : mazePathVertical3) {
            ans.add("V3" + vpath);
        }

        for (String hpath : mazePathHorizontal1) {
            ans.add("H1" + hpath);
        }
        for (String hpath : mazePathHorizontal2) {
            ans.add("H2" + hpath);
        }
        for (String hpath : mazePathHorizontal3) {
            ans.add("H3" + hpath);
        }

        for (String dpath : mazePathDiagonal1) {
            ans.add("D1" + dpath);
        }
        for (String dpath : mazePathDiagonal2) {
            ans.add("D2" + dpath);
        }
        for (String dpath : mazePathDiagonal3) {
            ans.add("D3" + dpath);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(getmazePathWithJumps(0, 0, 2, 2));
    }
}

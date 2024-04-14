
/**
 * temp
 */
public class SubSet {

    public static void subSet(int[] arr, int ssf, int target, int idx, String ans) {

        if (idx == arr.length) {
            if (ssf == target) {
                System.out.println(ans);
                return;
            }
            return;
        }

        int element = arr[idx];
        subSet(arr, ssf + element, target, idx + 1, ans + " " + element);
        subSet(arr, ssf, target, idx + 1, ans);

        return;
    }

    public static void main(String[] args) {
        subSet(new int[] { 10, 20, 30, 40, 50 }, 0, 70, 0, "");
    }

}
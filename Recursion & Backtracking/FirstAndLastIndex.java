
public class FirstAndLastIndex {
    public static int firstIndexOf(int[] arr, int idx, int val) {
        if (idx == arr.length)
            return -1;
        int resp = firstIndexOf(arr, idx + 1, val);
        if (arr[idx] == val) {
            return idx;
        } else {
            return resp;
        }
    }

    public static int lastIndexOf(int[] arr, int idx, int val) {
        if (idx == arr.length)
            return -1;
        int resp = lastIndexOf(arr, idx + 1, val);
        if (arr[idx] == val && resp == -1) {
            return idx;
        } else {
            return resp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 2, 0, 8, 3, 7, 1, 9, 4, 2 };
        System.out.println(firstIndexOf(arr, 0, 80));
        System.out.println(lastIndexOf(arr, 0, 80));
    }
}

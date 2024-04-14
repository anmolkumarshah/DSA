import java.util.Arrays;

public class AllIndices {

    public static int[] allIndexes(int[] arr, int idx, int count, int val) {
        if (idx == arr.length) {
            return new int[count];
        }
        if (arr[idx] == val)
            count++;
        int[] respArr = allIndexes(arr, idx + 1, count, val);
        if (arr[idx] == val) {
            respArr[--count] = idx;
        }
        return respArr;

    }

    public static void main(String[] args) {
        int[] arr = { 8, 2, 0, 8, 3, 7, 1, 9, 4, 2, 8, 8 };
        System.out.println(Arrays.toString(allIndexes(arr, 0, 0, 8)));
    }
}

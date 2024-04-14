public class MaxOfArray {

    public static int maximum(int[] arr, int idx) {
        if (idx == arr.length - 1)
            return arr[idx];
        return arr[idx] > maximum(arr, idx + 1) ? arr[idx] : maximum(arr, idx + 1);
    }

    public static void main(String[] args) {
        System.out.println(maximum(new int[] { 1, 4, 3, 7, 5, 9, 2, 5 }, 0));
    }
}

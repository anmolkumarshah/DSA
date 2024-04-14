public class ArrayPrintingDecreasing {
    public static void print(int[] arr, int idx) {
        if (idx == arr.length)
            return;
        print(arr, idx + 1);
        System.out.println(arr[idx]);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        print(arr, 0);
    }
}

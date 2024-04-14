public class PrintingNumberIncreading {
    public static void printingNumberIncreading(int n) {
        if (n == 0)
            return;
        printingNumberIncreading(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printingNumberIncreading(5);
    }
}

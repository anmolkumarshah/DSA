public class PrintingNumbersReverse {

    public static void printNumberReverse(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printNumberReverse(n - 1);
    }

    public static void main(String[] args) {
        printNumberReverse(5);
    }
}

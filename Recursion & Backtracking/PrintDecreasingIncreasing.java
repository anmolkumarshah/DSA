public class PrintDecreasingIncreasing {

    public static void printDecreasingIncreasing(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        printDecreasingIncreasing(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        printDecreasingIncreasing(5);
    }
}

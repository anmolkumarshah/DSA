/**
 * Power
 */
public class Power {

    public static int power(int n, int m) {
        if (m == 0)
            return 1;
        return n * power(n, m - 1);
    }

    public static void main(String[] args) {
        System.out.println(power(5, 3));
    }
}
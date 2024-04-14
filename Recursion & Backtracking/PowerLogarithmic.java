public class PowerLogarithmic {

    public static int powerLog(int n, int m) {
        if (m == 0)
            return 1;
        int ans = powerLog(n, m / 2);
        int res = ans * ans;
        if (m % 2 == 1) {
            res = res * n;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(powerLog(2, 4));
    }
}

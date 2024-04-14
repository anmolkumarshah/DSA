public class TowerOfHonoi {

    public static void toh(int n, String from, String to, String support) {
        if (n == 0)
            return;
        toh(n - 1, from, support, to);
        System.out.println(n + from + to);
        toh(n - 1, support, to, from);
    }

    public static void main(String[] args) {
        toh(3, "A", "B", "C");
    }
}

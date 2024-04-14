package lambda;

import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class LambdaComparator {

    public static void main(String[] args) {
        Comparator<Integer> descComp = (Integer i1, Integer i2) -> i2.compareTo(i1);
        TreeSet<Integer> hash = new TreeSet<>(descComp);
        for (int i = 0; i < 20; i++) {
            Random rn = new Random();
            hash.add(rn.nextInt(100));
        }

        System.out.println(hash);
    }

}

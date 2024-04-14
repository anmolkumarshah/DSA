package Streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Comparator<Integer> desc = (Integer i1, Integer i2) -> i2.compareTo(i1);

        ArrayList<Integer> li = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            li.add(new Random().nextInt(100));
        }

        li.stream().sorted(desc).forEach(System.out::println);

    }
}

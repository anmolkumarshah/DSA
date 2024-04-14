import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * temp
 */
public class temp {

    static public int maxVowels(String s, int k) {
        char[] crr = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        int vowelCount = 0;
        int maxCount = 0;

        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < k; i++) {
            if (vowels.contains(crr[i]))
                vowelCount++;
        }
        maxCount = vowelCount;

        for (int i = 1, j = i + k - 1; j < s.length(); i++, j++) {
            if (vowels.contains(crr[i - 1]))
                vowelCount--;
            if (vowels.contains(crr[j]))
                vowelCount++;

            maxCount = Math.max(maxCount, vowelCount);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));
    }
}
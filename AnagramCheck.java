import java.util.Arrays;

public class AnagramCheck {
     static public  void main(String[] args) {
        String s1 = "cat";
        String s2 = "att";

        if (isAnagram(s1, s2))
            System.out.println("Anagrams");
        else
            System.out.println("Not Anagrams");
    }

    static boolean isAnagram(String s1, String s2) {
        // Convert to lowercase
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        // If lengths differ, not anagrams
        if (s1.length() != s2.length())
            return false;

        // Convert strings to char arrays
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();

        // Sort the arrays
        Arrays.sort(a);
        Arrays.sort(b);

        // Compare sorted arrays
        return Arrays.equals(a, b);
    }
}

package HashTable;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // --- itemInCommon ---
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 5};
        System.out.println("itemInCommon: " + HashTableProblems.itemInCommon(a1, a2)); // true

        int[] a3 = {1, 3, 5};
        int[] a4 = {2, 4, 6};
        System.out.println("itemInCommon: " + HashTableProblems.itemInCommon(a3, a4)); // false

        // --- findDuplicates ---
        int[] arr = {1, 2, 3, 2, 4, 3, 5};
        ArrayList<Integer> dups = HashTableProblems.findDuplicates(arr);
        System.out.println("findDuplicates: " + dups); // [2, 3]

        // --- groupAnagrams ---
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("groupAnagrams: " + HashTableProblems.groupAnagrams(words));
        // [[eat, tea, ate], [tan, nat], [bat]]

        // --- firstNonRepeatingChar ---
        System.out.println("firstNonRepeatingChar: " + HashTableProblems.firstNonRepeatingChar("leetcode")); // l
        System.out.println("firstNonRepeatingChar: " + HashTableProblems.firstNonRepeatingChar("aabb"));    // null
    }
}

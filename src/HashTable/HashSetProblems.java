package HashTable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetProblems {

    /**
     * removeDuplicates - Remove duplicate integers from a list.
     *
     * Approach: Dump the list into a HashSet (which discards duplicates by design),
     * then wrap it back into an ArrayList.
     *
     * Time Complexity:  O(n) - single pass to build the set
     * Space Complexity: O(n) - set stores at most n distinct elements
     */
    public static List<Integer> removeDuplicates(List<Integer> myList) {
        Set<Integer> set = new HashSet<>(myList);
        return new ArrayList<>(set);
    }

    /**
     * hasUniqueChars - Check whether every character in the string is unique.
     *
     * Approach: Iterate over each character and try to add it to a HashSet.
     * If the character is already present, a duplicate was found.
     *
     * Time Complexity:  O(n) - single pass over the string
     * Space Complexity: O(k) - set holds at most k distinct characters (k ≤ charset size)
     */
    public static boolean hasUniqueChars(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) return false;
            charSet.add(c);
        }
        return true;
    }

    /**
     * findPairs - Find all pairs (a, b) where a is from arr1, b is from arr2, and a + b == target.
     *
     * Approach: Store all elements of arr1 in a HashSet for O(1) lookups, then for
     * each element b in arr2 check if (target - b) exists in the set.
     *
     * Time Complexity:  O(n + m) - one pass per array
     * Space Complexity: O(n)     - set stores all elements of arr1
     */
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        Set<Integer> arr1Set = new HashSet<>();
        List<int[]> res = new ArrayList<>();

        for (int num : arr1) {
            arr1Set.add(num);
        }

        for (int num : arr2) {
            if (arr1Set.contains(target - num)) {
                res.add(new int[]{target - num, num});
            }
        }

        return res;
    }

    /**
     * longestConsecutiveSequence - Find the length of the longest run of consecutive integers.
     *
     * Approach: Load all numbers into a HashSet, then for each number that has no
     * left-neighbour (i.e. it starts a sequence), walk the sequence forward with
     * O(1) set lookups. Only sequence-starters are expanded, so the total work
     * across all sequences is O(n).
     *
     * Time Complexity:  O(n) - each number is visited at most twice
     * Space Complexity: O(n) - set stores all n elements
     */
    public static int longestConsecutiveSequence(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int largestStreak = 0;

        for (int item : set) {
            // Only start counting from the beginning of a sequence
            if (set.contains(item - 1)) continue;

            int currentStreak = 1;
            int currentNum = item;

            while (set.contains(currentNum + 1)) {
                currentNum++;
                currentStreak++;
            }

            if (currentStreak > largestStreak) {
                largestStreak = currentStreak;
            }
        }

        return largestStreak;
    }
}

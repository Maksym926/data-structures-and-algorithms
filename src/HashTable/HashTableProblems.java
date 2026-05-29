package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableProblems {

    /**
     * itemInCommon - Check if two arrays share at least one common element.
     *
     * Approach: Use a HashMap to store all elements of array1, then iterate
     * array2 and check if any element already exists in the map.
     *
     * Time Complexity:  O(n + m) - one pass through each array
     * Space Complexity: O(n)     - map stores all elements of array1
     */
    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> hm = new HashMap<>();

        // Store every element of array1 in the map
        for (int item : array1) {
            hm.put(item, true);
        }

        // Check if any element of array2 exists in the map
        for (int item : array2) {
            if (hm.get(item) != null) return true;
        }

        return false;
    }

    /**
     * findDuplicates - Return all elements that appear more than once in the array.
     *
     * Approach: Use a HashMap to count occurrences of each number, then collect
     * keys whose count is greater than 1.
     *
     * Time Complexity:  O(n) - two passes through the map, both linear
     * Space Complexity: O(n) - map stores at most n distinct elements
     */
    public static ArrayList<Integer> findDuplicates(int[] array) {
        ArrayList<Integer> duplicates = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count occurrences: merge adds 1 to existing value or inserts 1 if absent
        for (int num : array) {
            map.merge(num, 1, (oldVal, newVal) -> oldVal + newVal);
        }

        // Collect all keys that appeared more than once
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey());
            }
        }

        return duplicates;
    }

    /**
     * groupAnagrams - Group an array of strings so that anagrams are together.
     *
     * Approach: For each string, sort its characters to produce a canonical key.
     * All anagrams share the same sorted key, so they map to the same list.
     *
     * Time Complexity:  O(n * k log k) - n strings, each sorted in O(k log k)
     * Space Complexity: O(n * k)       - map stores all strings
     */
    public static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String str : strings) {
            // Sort the characters to get a canonical anagram key
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);

            // Create a new group if this key hasn't been seen yet
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }

            // Add the original string to its anagram group
            map.get(sorted).add(str);
        }

        // Collect all groups into the result list
        for (String key : map.keySet()) {
            res.add(map.get(key));
        }

        return res;
    }

    /**
     * firstNonRepeatingChar - Find the first character that appears only once.
     *
     * Approach: Count occurrences of every character with a HashMap, then do a
     * second pass over the original order to return the first with count == 1.
     *
     * Time Complexity:  O(n) - two linear passes over the string
     * Space Complexity: O(1) - at most 26 distinct lowercase letters in the map
     */
    public static Character firstNonRepeatingChar(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] letters = word.toCharArray();

        // Count how many times each character appears
        for (char letter : letters) {
            map.merge(letter, 1, (oldValue, newValue) -> oldValue + newValue);
        }

        // Return the first character whose count is exactly 1
        for (char letter : letters) {
            if (map.get(letter) == 1) return letter;
        }

        // All characters repeat — no unique character found
        return null;
    }

    /**
     * subarraySum - Find the indices [start, end] of a contiguous subarray that sums to target.
     *
     * Approach: Track a running total as we iterate. At each index, check if
     * (runningTotal - target) was seen before — if so, the subarray between
     * that earlier index + 1 and the current index sums to exactly target.
     * Seeding the map with {0: -1} handles the case where the subarray starts at index 0.
     *
     * Time Complexity:  O(n) - single pass
     * Space Complexity: O(n) - map stores at most n running totals
     */
    public static int[] subarraySum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // Seed: a running total of 0 exists before index 0
        map.put(0, -1);
        int runningTotal = 0;

        for (int i = 0; i < nums.length; i++) {
            runningTotal += nums[i];

            // If (runningTotal - target) was seen at index j,
            // then nums[j+1..i] sums to target
            if (map.containsKey(runningTotal - target)) {
                return new int[]{map.get(runningTotal - target) + 1, i};
            } else {
                // Store this running total and its index for future lookups
                map.put(runningTotal, i);
            }
        }

        return new int[0]; // No subarray found
    }

    /**
     * twoSum - Find indices of two numbers in the array that add up to target.
     *
     * Approach: For each number, compute the complement (target - num) and check
     * if it already exists in the map. The map stores each number mapped to its
     * most recent index, so we always return the latest valid pair.
     *
     * Time Complexity:  O(n) - single pass
     * Space Complexity: O(n) - map stores at most n elements
     */
    public static int[] twoSum(int[] array, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            // Update index if number was seen before, otherwise insert it
            if (map.containsKey(num)) {
                map.replace(num, i);
            } else {
                map.put(num, i);
            }

            // Check if the complement needed to reach target is already in the map
            int expected = target - num;
            if (map.containsKey(expected)) {
                return new int[]{i, map.get(expected)};
            }
        }

        return new int[0]; // No valid pair found
    }
}

package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
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
}

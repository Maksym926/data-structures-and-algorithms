package heap;

import java.util.ArrayList;
import java.util.List;

public class HeapProblems {

    // Uses a max-heap of size k.
    // When the heap exceeds k elements the largest is removed,
    // so after all insertions the root is the kth smallest.
    public static int findKthSmallest(int[] nums, int k) {
        Heap heap = new Heap();
        for (int num : nums) {
            heap.insert(num);
            if (heap.getHeap().size() > k) {
                heap.remove();
            }
        }
        return heap.remove();
    }

    // Returns a list where each entry is the maximum seen so far in the stream.
    // The max-heap root is always the largest element inserted so far.
    public static List<Integer> maxInStream(int[] nums) {
        Heap heap = new Heap();
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            heap.insert(num);
            result.add(heap.getHeap().getFirst());
        }
        return result;
    }
}

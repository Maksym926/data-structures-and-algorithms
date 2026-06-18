package heap;

import java.util.ArrayList;
import java.util.List;

public class Heap {
    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }
    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }
    private int leftChild(int index){
        return 2*index + 1;
    }
    private int rightChild(int index){
        return 2 * index + 2;
    }
    private int parent(int index){
        return (index - 1) / 2;
    }
    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    public void insert(int value){
        heap.add(value);
        int current = heap.size() - 1;

        while(current > 0 && heap.get(parent(current)) < heap.get(current)){
                swap(current, parent(current));
                    current = parent(current);
        }
    }
    public Integer remove(){
        if(heap.isEmpty()) return null;
        if(heap.size() == 1) return heap.removeFirst();
        int maxValue = heap.getFirst();
        heap.set(0, heap.removeLast());
        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int i) {
        while (true){
            int maxIndex = i;
            int lChild = leftChild(i);
            int rChild = rightChild(i);
            if(lChild < heap.size() && heap.get(lChild) > heap.get(maxIndex)){
                maxIndex = lChild;
            }
            if(rChild < heap.size() && heap.get(rChild) > heap.get(maxIndex)){
                maxIndex = rChild;
            }
            if(maxIndex != i){
                swap(i, maxIndex);
                i = maxIndex;   
            }else{
                return;
            }
        }
    }
}

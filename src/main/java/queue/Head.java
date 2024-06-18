package queue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 最小堆的实现
 * 父节点 为i-1/2
 * 左孩子 2i + 1
 * 右孩子 2i + 2
 *
 * 堆是一种完全二叉树，分为最大堆和最小堆两种类型。在最小堆中，父节点的值小于或等于其子节点的值；而在最大堆中，父节点的值大于或等于其子节点的值。堆的实现基于数组，通过数组的索引关系来表示树的结构。这种结构使得堆具有以下特性：
 *
 * 1. 父节点和子节点的索引关系：对于任意节点i，其父节点索引为(i-1)/2，左子节点索引为2i+1，右子节点索引为2i+2。
 * 2. 插入操作：将新元素插入堆的末尾，然后通过“上浮”操作将其调整到合适的位置，以满足堆的性质。
 * 3. 删除操作：通常删除堆顶元素，将堆尾元素移到堆顶，然后通过“下沉”操作将其调整到合适的位置，以满足堆的性质。
 * 4. 时间复杂度：堆的插入和删除操作的时间复杂度为O(log n)，其中n为堆中元素的个数。
 *
 * 通过这种索引关系和调整操作，堆能够高效地实现优先队列等数据结构。
 */
public class Head {

    private List<Integer> heap;

    public Head() {
        heap = new ArrayList<>();
    }

    private void heapifyUp() {
        int index = heap.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index) < heap.get(parentIndex)) {
                Collections.swap(heap, index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (index < heap.size()) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
                smallest = leftChild;
            }
            if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
                smallest = rightChild;
            }

            if (smallest != index) {
                Collections.swap(heap, index, smallest);
                index = smallest;
            } else {
                break;
            }
        }
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp();
    }

    public int extractMin() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        int min = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown();

        return min;
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap.get(0);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

}

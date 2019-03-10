package leetcode.support;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉最小堆
 */
public class BinaryHeap {
    private List<Integer> heap;

    public BinaryHeap(List<Integer> nums) {
        heap = new ArrayList<>(nums.size());
        heap.addAll(nums);

        /**
         * 最后一个非叶子节点的索引
         * 非叶子节点的索引满足 2n + 1 <= length - 1
         */
        int lastUnLeafIndex = heap.size() / 2 - 1;
        if(lastUnLeafIndex < 0) return;

        for(int i = lastUnLeafIndex; i >= 0; i--) {
            bubbleDown(heap, i);
        }
    }

    /**
     * 对二叉堆元素按升序进行堆排序
     *
     * @return
     */
    public List<Integer> sort() {
        List<Integer> heapCopy = new ArrayList<>(heap.size());
        heapCopy.addAll(heap);
        List<Integer> sorted = new ArrayList<>(heap.size());

        while(heapCopy.size() > 1) {
            /* 移除首元素(最小元素), 末尾元素移动到首元素后重新调整二叉堆 */
            sorted.add(heapCopy.get(0));
            heapCopy.set(0, heapCopy.get(heapCopy.size() - 1));
            heapCopy.remove(heapCopy.size() - 1);
            bubbleDown(heapCopy, 0);
        }
        sorted.add(heapCopy.get(0));
        return sorted;
    }

    /**
     * 添加新元素, 添加后调整二叉堆
     *
     * @param i
     */
    public void add(Integer i) {
        heap.add(i);
        bubbleUp();
    }

    /**
     * 下沉调整指定元素, 用于二叉堆的构建与移除元素后的调整
     *
     * @param nums
     * @param pos
     */
    private void bubbleDown(List<Integer> nums, int pos) {
        if(pos < 0 || pos >= nums.size()) {
            throw new IllegalArgumentException("The pos is illegal");
        }
        int parent = pos;
        /* 先选择左子节点作为较小值 */
        int smallerChildren = 2 * pos + 1;
        /* 先存储待调整的节点的值, 后续调整结束后直接赋值到最终调整的位置 */
        int tmp = nums.get(parent);
        int length = nums.size();

        while(smallerChildren < length) {
            /* 若右子节点为较小值, 则更新smallerChildren */
            if(smallerChildren + 1 < length &&
                    nums.get(smallerChildren + 1) < nums.get(smallerChildren)) {
                smallerChildren++;
            }

            /* 若待调整值小于两个子节点值, 调整结束 */
            if(tmp <= nums.get(smallerChildren)) break;

            /* 交换父节点与较小子节点的值, 同时更新父节点的指向继续调整 */
            nums.set(parent, nums.get(smallerChildren));
            parent = smallerChildren;
            smallerChildren = 2 * smallerChildren + 1;
        }

        nums.set(parent, tmp);
    }

    /**
     * 上浮调整元素, 用于二叉堆添加新元素之后的调整
     */
    private void bubbleUp() {
        /* 获取最后一个节点的索引 */
        int children = heap.size() - 1;
        /* 获取待调整节点的父节点索引 */
        int parent = (children - 1) / 2;
        /* 存储待调整节点的值, 待调整结束后直接赋值到最终调整的位置 */
        int tmp = heap.get(children);

        while(parent >= 0 && tmp < heap.get(parent)) {
            heap.set(children, heap.get(parent));
            children = parent;
            parent = (children - 1) / 2;
        }

        heap.set(children, tmp);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}

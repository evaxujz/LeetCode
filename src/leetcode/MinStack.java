package leetcode;

class MinStack {

    private int[] stack;
    private int[] minStack;
    private int pos;
    private int length;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new int[100];
        minStack = new int[100];
        pos = 0;
        length = 100;
    }

    public void push(int x) {
        if(pos == length) {
            int[] tempStack = new int[length * 2];
            int[] tempMinStack = new int[length * 2];
            System.arraycopy(stack, 0, tempStack, 0, length);
            System.arraycopy(minStack, 0, tempMinStack, 0, length);
            stack = tempStack;
            minStack = tempMinStack;
            length *= 2;
        }

        stack[pos] = x;
        minStack[pos] =  (0 == pos) ? x : (x < minStack[pos - 1]) ? x : minStack[pos - 1];
        pos++;
    }

    public void pop() {
        if(0 == pos) return;
        pos--;
    }

    public int top() {
        return stack[pos - 1];
    }

    public int getMin() {
        return minStack[pos - 1];
    }
}

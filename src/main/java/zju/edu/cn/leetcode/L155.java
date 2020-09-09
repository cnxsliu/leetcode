package zju.edu.cn.leetcode;

import java.util.Stack;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/24 17:32
 * @strategy
 */
public class L155 {
    class MinStack {
        Stack<Integer> stack;
        Stack<Integer> min;
        public MinStack() {
            this.stack = new Stack<>();
            this.min = new Stack<>();
        }

        public void push(int x) {
            stack.push(x);
            if (min.empty()) {
                min.push(x);
                return;
            }
            if (x < min.peek()) {
                min.push(x);
            } else {
                min.push(min.peek());
            }
        }

        public void pop() {
            stack.pop();
            min.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

}

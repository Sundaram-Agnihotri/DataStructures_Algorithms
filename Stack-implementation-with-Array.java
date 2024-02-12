// import java.util.*;

public class Implement_with_array {
    public static class Stacks {
        private int data[];
        private int topIndex;

        public Stacks() {
            data = new int[10];
            topIndex = -1;

        }

        public int size() {
            return topIndex + 1;
        }

        public boolean isEmpty() {
            if (topIndex == -1)
                return true;
            else
                return false;
        }

        public void push(int element) {

            if (topIndex == data.length - 1) {
                System.out.println("The stack is Full");
            }
            data[++topIndex] = element;
        }

        public int top() {
            if (topIndex == -1)
                System.out.println("The stack is Empty");
            return data[topIndex];
        }

        public int pop() {
            if (topIndex == -1) {
                System.out.println("The stack is Empty");
            }

            int curr = data[topIndex];
            topIndex--;
            return curr;
        }

    }

    public static void main(String[] args) {
        Stacks s = new Stacks();
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        s.pop();
        System.out.println(s.top());
    }
}

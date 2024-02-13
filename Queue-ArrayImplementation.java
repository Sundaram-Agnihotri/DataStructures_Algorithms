public class ArrayImplementation {

    public class QueueArray {
        private int data[];
        private int rear;
        private int size;
        private int front;

        public QueueArray() {
            data = new int[5];
            front = -1;
            rear = -1;
        }

        public QueueArray(int capacity) {
            data = new int[capacity];
            front = -1;
            rear = -1;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void enqueue(int element) {
            if (size == 0) {
                front = 0;
            }

            rear++;
            data[rear] = element;
            size++;
        }

        public int front() {
            if (size == 0)
                return -1;
            else
                return data[front];
        }

        public int dequeue() {
            if (size == 0)
                return -1;

            int temp = data[front];
            front++;
            size--;

            if (size == 0) {
                front = -1;
                rear = -1;
            }

            return temp;
        }
    }

    public static void main(String[] args) {

    }
}

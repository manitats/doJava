import java.util.Scanner;
import java.util.stream.IntStream;

public class PriorityQueue {
    private static final int BIG_NUM = 3_000_000;
    private static int[] heap = new int[BIG_NUM];
    private static int head = 0;

    public static void main(String[] args) {
        int key;
        String cmd;
        Scanner sc = new Scanner(System.in);
        loop: while(true) {
            cmd = sc.next();
            switch (cmd) {
                case "end":
                    break loop;
                case "insert":
                    key = sc.nextInt();
                    insert(key);
                    break;
                case "extract":
                    System.out.println(extract());
                    break;
                default:
                    break;
            }
        }
    }

    public static int extract() {
        int max;
        if(head < 1) return -1;
        max = heap[1];
        heap[1] = heap[head--];
        maxheapify(1);
        return max;
    }

    public static void insert(int key) {
        head++;
        heap[head] = Integer.MIN_VALUE;
        increaseKey(head, key);
    }

    public static void increaseKey(int head, int key) {
        if(key < heap[head]) return;
        heap[head] = key;
        while(head > 1 && heap[head / 2] < heap[head]) {
            int tmp = heap[head];
            heap[head] = heap[head / 2];
            heap[head / 2] = tmp;
            head /= 2;
        }
    }
    
    public static void maxheapify(int key) {
        int left, right, largest;
        left = 2 * key;
        right = 2 * key + 1;

        if (left < heap.length && heap[left] > heap[key]) {
            largest = left;
        } else {
            largest = key;
        }

        if (right < heap.length && heap[right] > heap[largest]) largest = right;

        if (largest != key) {
            int tmp = heap[key];
            heap[key] = heap[largest];
            heap[largest] = tmp;
            maxheapify(largest);
        }
    }
}

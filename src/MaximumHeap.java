import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MaximumHeap {

    private static int[] heap;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        heap = new int[N + 1];
        IntStream.rangeClosed(1, N).forEach(i -> heap[i] = sc.nextInt());
        buildMaxHeap();
        Arrays.stream(heap).forEach(i -> {
            if(i == 0) return;
            System.out.print(" " + i);
        });
        System.out.println();
    }

    public static void maxHeapify(int i) {
        int left, right, largest;
        left = 2 * i;
        right = 2 * i + 1;

        if (left < heap.length && heap[left] > heap[i]) {
            largest = left;
        } else {
            largest = i;
        }

        if (right < heap.length && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            int tmp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = tmp;
            maxHeapify(largest);
        }
    }

    public static void buildMaxHeap() {
        for(int i = heap.length / 2; i > 0; i--) {
            maxHeapify(i);
        }
    }
}

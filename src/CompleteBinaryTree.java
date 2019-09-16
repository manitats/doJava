import java.util.Scanner;
import java.util.stream.IntStream;

public class CompleteBinaryTree {
    private static int[] heap;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        heap = new int[N + 1];
        IntStream.rangeClosed(1, N).forEach(i -> heap[i] = sc.nextInt());

        IntStream.range(1, heap.length).forEach(i -> {
            StringBuilder sb = new StringBuilder();
            sb.append("node ").append(i)
                    .append(": key = ").append(heap[i]).append(", ");
            if (parent(i) >= 1) sb.append("parent key = ").append(heap[parent(i)]).append(", ");
            if (left(i) <= N) sb.append("left key = ").append(heap[left(i)]).append(", ");
            if (right(i) <= N) sb.append("right key = ").append(heap[right(i)]).append(", ");

            System.out.println(sb.toString());
        });
    }

    private static int parent(int i) {
        return i / 2;
    }

    private static int left(int i) {
        return i * 2;
    }

    private static int right(int i) {
        return i * 2 + 1;
    }
}

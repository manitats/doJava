import java.util.Arrays;
import java.util.stream.IntStream;

public class CountSort {
    static int[] data = {0, 2, 18, 5, 5, 10, 18, 0, 2, 5};
    static int MAX = 18;
    public static void main(String[] args) {
        exec(data);
        System.out.println(Arrays.toString(data));
    }

    public static void exec(int[] data) {
        int[] tmp = new int[data.length];
        int[] counter = new int[MAX + 1];
        Arrays.stream(data).forEach(s -> counter[s]++);
        System.out.println("counter: " + Arrays.toString(counter));
        IntStream.range(1, counter.length).forEach(i -> {
            counter[i] += counter[i - 1];
        });
        Arrays.stream(data).forEach(s -> {
            tmp[counter[s] - 1] = s;
            counter[s]--;
        });
        IntStream.range(0, data.length).forEach(i -> data[i] = tmp[i]);
    }
}

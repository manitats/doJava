import java.util.Arrays;

public class QuickSort {
    static int[] data = {7, -1, 10, 3, 21, 5, 6, 9, 1, 15, 2, 13, 8, -5 , 11};

    public static void main(String[] args) {
        exec(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    public static void exec(int[] data, int left, int right) {
        if (left < right) {
            int q = partition(data, left, right);
            exec(data, left, q - 1);
            exec(data, q + 1, right);
        }
    }

    public static int partition(int[] data, int left, int right) {
        int border = data[right];
        int i = left - 1;
        while (true) {
            if (left == right) {
                data[right] = data[i + 1];
                data[i + 1] = border;
                return i + 1;
            }

            if (data[left] > border) {
                left++;
            } else {
                i++;
                int tmp = data[left];
                data[left] = data[i];
                data[i] = tmp;
                left++;
            }
        }
    }
}

import java.util.Arrays;

public class Partition {

    static int[] data = {7, 8, 10, 3, 21, 5, 6, 9, 1, 8, 2, 13, 8};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data) + "\nborder is " + data[exec(data)] + "\n"
            + Arrays.toString(data));
    }

    public static int exec(int[] data) {
        int border = data[data.length - 1];
        int i = -1;
        int j = i + 1;

        while (true) {
            if (j == data.length - 1) {
                data[j] = data[i+1];
                data[i+1] = border;
                return i + 1;
            }

            if (data[j] > border) {
                j++;
            } else {
                i++;
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
                j++;
            }
        }
    }
}

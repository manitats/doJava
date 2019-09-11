import java.util.Random;

public class BubbleSort {
    private static void sort(int[] array) {
        for (var i = 0; i < array.length; i++) {
            for (var j = array.length -1; j > i; j--) {
                if (array[j] < array[j-1]) {
                    var tmp = array[j-1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
    }

    //O(n^2)
    private static void minimalsort(int[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int minj = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minj]) {
                    minj = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minj];
            array[minj] = tmp;
        }
    }

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i != 0) {
                System.out.print(" ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(30);
        }

        print(array);
        minimalsort(array);
//        sort(array);
        print(array);
    }
}
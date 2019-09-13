import java.util.Arrays;

public class MergeSort {

    private static final int[] data = ArgoUtil.generateRandom(20, 100, 0);
    private static int[] L = new int[data.length];
    private static int[] R = new int[data.length];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(data));
        mergeSort(data, 0, data.length);
        System.out.println(Arrays.toString(data));
    }

    public static void mergeSort(int[] data, int left, int right) {
        if (left + 1 < right) {
            int mid = (left + right) >>> 1;
            mergeSort(data, left, mid);
            mergeSort(data, mid, right);
            merge(data, left, mid, right);
        }
    }

    public static void merge(int[] data, int left, int mid, int right) {
        int n1 = mid - left;
        int n2 = right - mid;
        for (int i = 0; i < n1; i++) {
            L[i] = data[left + i];
        }
        for (int i = 0; i < n2; i++) {
            R[i] = data[mid + i];
        }
        L[n1] = R[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for (int k = left; k < right; k++) {
            if (L[i] <= R[j]) {
                data[k] = L[i++];
            } else {
                data[k] = R[j++];
            }
        }
    }
}

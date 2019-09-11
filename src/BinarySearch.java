/*
整数Sを昇順に並べられた配列Tの何番目の要素に格納すれば、昇順を保つことができるか
 */

public class BinarySearch {
    public static void main(String[] args) {
        //int[] data = { 10, 30, 40, 60, 80, 90, 110, 140, 170, 190, 210, 260 };
        int[] data = {2, 4, 6, 8, 10};
        System.out.println(search(data, 7));
    }

    private static int search(int[] data, int target) {
        int left = 0;
        int right = data.length -1;

        if (right < 0) {
            return -1;
        } else if (right == 0) {
            return data[0] > target? 0 : 1;
        }

        while (left < right) {
            if (left + 1 == right) {
                return data[left] > target ? left : right;
            }

            int center = (left + right) / 2;

            if (data[center] == target) {
                return center + 1;
            } else if (data[center] > target) {
                right = center;
            } else {
                left = center ;
            }
        }

        return -1;
    }
}

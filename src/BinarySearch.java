public class BinarySearch {
    public static void main(String[] args) {
        //int[] data = { 10, 30, 40, 60, 80, 90, 110, 140, 170, 190, 210, 260 };
        int[] data = {10 , 5 , 14};
        System.out.println(search(data, 13));
    }

    private static int search(int[] data, int target) {
        int left = 0;
        int right = data.length -1;

        if (right < 0) {
            return -1;
        } else if (right == 0) {
            return data[0] > target? 0 : 1;
        }

        while (right > left) {
            int center = (left + right) / 2;

            if (right == left + 1) {
                return data[center] > target ? left : right;
            }

            if (data[center] == target) {
                return center + 1;
            } else if (data[center] < target) {
                left = left + (right - left) / 2;
            } else {
                right = right - (right - left) / 2;
            }
        }

        return -1;
    }
}

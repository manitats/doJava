import java.util.Arrays;
import java.util.Random;

public class FindMaximum {
    public static void main(String[] args) {
        int NUM = 20;
        int[] nums = new int[NUM];
        Random random = new Random();
        nums = Arrays.stream(nums).map(s -> random.nextInt(50) + 5).toArray();
        int start = random.nextInt(NUM - 2);
        int end = random.nextInt(NUM - 1);
        while(start >= end) {
            end = random.nextInt(NUM);
        }

        System.out.println(Arrays.toString(nums));
        System.out.println("Range: " + start + " ~ " + end);
        System.out.println("MAX is " + find(nums, start, end));
    }

    public static int find(int[] nums, int s, int e) {
        int med = (e + s) / 2;
        if (s == e - 1) {
            return nums[s];
        }

        int first = find(nums, s, med);
        int second = find(nums, med, e);
        return Math.max(first, second);
    }


}

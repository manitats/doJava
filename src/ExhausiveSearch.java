public class ExhausiveSearch {
    static int[] nums = {3, 5, 6, 9, 13};

    public static void main(String[] args) {

        int target = 4;

        System.out.println(solve(0, target));
    }

    public static boolean solve(int i, int target) {
        if (target == 0) {
            return true;
        }

        if (i >= nums.length) {
            return false;
        }

        return solve(i + 1, target) || solve(i + 1, target - nums[i]);
    }
}

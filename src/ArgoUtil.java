import java.util.Arrays;
import java.util.Random;

public class ArgoUtil {
    private ArgoUtil(){}

    public static int[] generateRandom(int num, int range, int radix){
        int[] nums = new int[num];
        Random random = new Random();
        return Arrays.stream(nums).map(s -> random.nextInt(range) + radix).toArray();
    }
}

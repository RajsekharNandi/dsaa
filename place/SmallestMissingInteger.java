import java.util.HashSet;
import java.util.Set;

public class SmallestMissingInteger {
      int n = nums.length;
        long total = nums[0];
        int i = 0;
        while (i + 1 < n && nums[i + 1] == nums[i] + 1) {
            total += nums[i + 1];
            i++;
        }
        
        Set<Integer> seen = new HashSet<>();
        for (int x : nums) seen.add(x);
        
        while (seen.contains((int) total)) {
            total++;
        }
        return (int) total;
}

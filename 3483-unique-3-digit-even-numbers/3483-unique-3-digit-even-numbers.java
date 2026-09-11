import java.util.*;

class Solution {
    public int totalNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) cnt[d]++;

        List<Integer> distinct = new ArrayList<>();
        for (int d = 0; d <= 9; d++) {
            if (cnt[d] > 0) distinct.add(d);
        }

        int count = 0;

        for (int h : distinct) {
            if (h == 0) continue; 
            for (int t : distinct) {
                for (int u : distinct) {
                    if (u % 2 != 0) continue; 

                    int[] need = new int[10];
                    need[h]++;
                    need[t]++;
                    need[u]++;

                    boolean ok = true;
                    for (int d = 0; d <= 9; d++) {
                        if (need[d] > cnt[d]) {
                            ok = false;
                            break;
                        }
                    }
                    if (ok) count++;
                }
            }
        }

        return count;
    }
}
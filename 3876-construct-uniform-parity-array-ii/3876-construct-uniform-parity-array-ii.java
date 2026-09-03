class Solution {
    public boolean uniformArray(int[] nums1) {
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;

        // Find the smallest even and smallest odd number
        for (int x : nums1) {
            if (x % 2 == 0) {
                minEven = Math.min(minEven, x);
            } else {
                minOdd = Math.min(minOdd, x);
            }
        }

        // Try to make all numbers even
        boolean allEven = true;

        for (int x : nums1) {
            if (x % 2 != 0) {
                // Odd - Odd = Even
                if (minOdd >= x) {
                    allEven = false;
                    break;
                }
            }
        }

        if (allEven) {
            return true;
        }

        // Try to make all numbers odd
        boolean allOdd = true;

        for (int x : nums1) {
            if (x % 2 == 0) {
                // Even - Odd = Odd
                if (minOdd >= x) {
                    allOdd = false;
                    break;
                }
            }
        }

        return allOdd;
    }
}
import java.util.*;

class longSub {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        char[] arr = s.toCharArray();

        // run start -> run end (inclusive), for maximal same-character runs
        TreeMap<Integer, Integer> startToEnd = new TreeMap<>();
        // run length -> how many runs currently have that length
        TreeMap<Integer, Integer> lenCount = new TreeMap<>();

        // Build initial runs
        int i = 0;
        while (i < n) {
            int j = i;
            while (j + 1 < n && arr[j + 1] == arr[i]) j++;
            addRun(startToEnd, lenCount, i, j);
            i = j + 1;
        }

        int q = queryCharacters.length();
        int[] result = new int[q];

        for (int k = 0; k < q; k++) {
            int idx = queryIndices[k];
            char c = queryCharacters.charAt(k);

            if (arr[idx] != c) {
                // Find and remove the run containing idx
                int start = startToEnd.floorKey(idx);
                int end = startToEnd.get(start);
                removeRun(startToEnd, lenCount, start);

                // Split off the left and right remnants (same old character)
                if (start <= idx - 1) {
                    addRun(startToEnd, lenCount, start, idx - 1);
                }
                if (idx + 1 <= end) {
                    addRun(startToEnd, lenCount, idx + 1, end);
                }

                arr[idx] = c;

                int newStart = idx;
                int newEnd = idx;

                // Merge with left neighbor run if it has the same character
                if (idx - 1 >= 0 && arr[idx - 1] == c) {
                    int leftStart = startToEnd.floorKey(idx - 1);
                    // leftStart's run ends exactly at idx - 1
                    removeRun(startToEnd, lenCount, leftStart);
                    newStart = leftStart;
                }

                // Merge with right neighbor run if it has the same character
                if (idx + 1 < n && arr[idx + 1] == c) {
                    // idx + 1 is guaranteed to be an existing run start
                    int rightEnd = startToEnd.get(idx + 1);
                    removeRun(startToEnd, lenCount, idx + 1);
                    newEnd = rightEnd;
                }

                addRun(startToEnd, lenCount, newStart, newEnd);
            }

            result[k] = lenCount.lastKey();
        }

        return result;
    }

    private void addRun(TreeMap<Integer, Integer> startToEnd,
                         TreeMap<Integer, Integer> lenCount,
                         int start, int end) {
        startToEnd.put(start, end);
        int len = end - start + 1;
        lenCount.merge(len, 1, Integer::sum);
    }

    private void removeRun(TreeMap<Integer, Integer> startToEnd,
                            TreeMap<Integer, Integer> lenCount,
                            int start) {
        int end = startToEnd.remove(start);
        int len = end - start + 1;
        int newCount = lenCount.merge(len, -1, Integer::sum);
        if (newCount == 0) {
            lenCount.remove(len);
        }
    }
}
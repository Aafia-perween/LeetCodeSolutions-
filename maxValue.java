import java.util.*;

class MaxValue {
    public int maxValue(int[][] events, int k) {
        // Sort events based on end day
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int n = events.length;
        int[] endDays = new int[n];
        for (int i = 0; i < n; i++) {
            endDays[i] = events[i][1];
        }

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            int[] currEvent = events[i - 1];
            int prev = binarySearch(endDays, currEvent[0]);

            for (int j = 1; j <= k; j++) {
                // Max of not taking this event or taking this event
                dp[i][j] = Math.max(dp[i - 1][j], dp[prev + 1][j - 1] + currEvent[2]);
            }
        }

        return dp[n][k];
    }

    
    private int binarySearch(int[] endDays, int currStart) {
        int low = 0, high = endDays.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (endDays[mid] < currStart) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}


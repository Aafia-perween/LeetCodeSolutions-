   class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime, int k) {
        int n = startTime.length;
        int[] duration = new int[n];

        // Step 1: calculate durations
        for (int i = 0; i < n; i++) {
            duration[i] = endTime[i] - startTime[i];
        }

        int maxFreeTime = 0;

        // Step 2: Try rescheduling first 0 to k meetings
        for (int move = 0; move <= k; move++) {
            int[] newStart = new int[n];
            int[] newEnd = new int[n];
            int currentTime = 0;

            for (int i = 0; i < n; i++) {
                if (i < move) {
                    // Reschedule early
                    newStart[i] = currentTime;
                    newEnd[i] = newStart[i] + duration[i];
                    currentTime = newEnd[i];
                } else {
                    // Keep original meeting time, but make sure no overlap
                    newStart[i] = Math.max(currentTime, startTime[i]);
                    newEnd[i] = newStart[i] + duration[i];
                    currentTime = newEnd[i];
                }
            }

            // Step 3: Calculate max free time in this arrangement
            int maxGap = 0;

            // Before first meeting
            maxGap = Math.max(maxGap, newStart[0]);

            // Between meetings
            for (int i = 1; i < n; i++) {
                maxGap = Math.max(maxGap, newStart[i] - newEnd[i - 1]);
            }

            // After last meeting
            maxGap = Math.max(maxGap, eventTime - newEnd[n - 1]);

            // Update final max free time
            maxFreeTime = Math.max(maxFreeTime, maxGap);
        }

        return maxFreeTime;
    }
}
  












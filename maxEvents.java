import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        // Step 1: Sort the events by their start day
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        // Min-heap to store end days of ongoing events
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int day = 0, i = 0, count = 0, n = events.length;

        // Loop until all events are processed and no ongoing events
        while (i < n || !minHeap.isEmpty()) {
            // If no ongoing events, jump to the next event's start day
            if (minHeap.isEmpty()) {
                day = events[i][0];
            }

            // Add all events that start on the current day
            while (i < n && events[i][0] <= day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove events that have already ended before today
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event that ends the earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll();  // Attend it
                count++;         // Increment number of events attended
                day++;           // Move to the next day
            }
        }

        return count;
    }
}

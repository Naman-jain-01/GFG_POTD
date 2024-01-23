package JANUARY;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution23 {

    public static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        int[] result = new int[n];
        int[] inDegree = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph and calculate in-degrees
        for (ArrayList<Integer> edgedetails : prerequisites) {
            int course = edgedetails.get(0);
            int prerequisiteCourse = edgedetails.get(1);
            graph.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }
        for (int i=0;i<graph.size();i++) {
            System.out.println(" i " + graph.get(i));

        }
        // Use a queue to perform topological sorting
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        int index = 0;

        // Perform topological sorting
        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result[index++] = currentCourse;

            for (int nextCourse : graph.get(currentCourse)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        // Check if all courses can be taken
        if (index == n) {
            return result;
        } else {
            return new int[0]; // Return an empty array if there is a cycle
        }
    }
}


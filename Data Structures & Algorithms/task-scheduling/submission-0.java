class Solution {
    class Pair {
        int val;
        int time;
        Pair(int val, int time) {
            this.val = val;
            this.time = time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (int i=0;i<tasks.length;i++) {
            freq[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for (int num: freq) {
            if (num != 0) pq.add(num);
        }
        
        Queue<Pair> queue = new LinkedList<>();
        int time = 0;
        while (!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            int num = 0;
            if (!pq.isEmpty()) num = pq.poll() - 1;
            if (num > 0) queue.add(new Pair(num, time+n));
            if (!queue.isEmpty() && queue.peek().time == time) pq.add(queue.poll().val);
        }
        return time;
    }
}

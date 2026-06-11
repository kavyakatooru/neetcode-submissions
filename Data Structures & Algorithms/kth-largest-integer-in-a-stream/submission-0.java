class KthLargest {

    PriorityQueue<Integer> pQueue;
    int k;

    public KthLargest(int k, int[] nums) {
        pQueue = new PriorityQueue<>((a,b) -> a-b);
        this.k = k;
        for (int i = 0;i<nums.length;i++) {
            pQueue.add(nums[i]);
        }
        while (pQueue.size() > k) pQueue.poll();
    }
    
    public int add(int val) {
        if (pQueue.size() < k) {
            pQueue.add(val);
        }
        else if (val > pQueue.peek()) {
            pQueue.poll();
            pQueue.add(val);
        } 
        return pQueue.peek();
    }
}

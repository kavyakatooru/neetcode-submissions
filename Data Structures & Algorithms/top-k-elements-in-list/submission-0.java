class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>((a,b) -> b.get(1)-a.get(1));
        for (int num : nums) {
            int size = map.getOrDefault(num, 0)+1;
            map.put(num,size);
        }

        for (int num: map.keySet()) {
            maxHeap.offer(new ArrayList<>(Arrays.asList(num, map.get(num))));
        }

        while (k != 0) {
            k--;
            arr[k]= maxHeap.poll().get(0);
        }
        return arr;
    }
}

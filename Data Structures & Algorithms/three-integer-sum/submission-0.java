class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> threeSumList = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i=0;i<nums.length-2;i++) {
            List<List<Integer>> twoSum = twoSum(nums, 0-nums[i], i+1);
            
            if (twoSum != null && !twoSum.isEmpty()) {
                for (List<Integer> list:twoSum) {
                    list.add(nums[i]);
                    Collections.sort(list);
                    if (!set.contains(list)) {
                        threeSumList.add(list);
                        set.add(list);
                    }
                }
                
            }
        }
        return threeSumList;
    }


    public List<List<Integer>> twoSum(int nums[], int target, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=k;i<nums.length;i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff) && map.get(diff) != i) {
                ans.add(new ArrayList<>(Arrays.asList(nums[i], diff)));
             } else{
                map.put(nums[i], i);
             }
        }
        return ans;
    }
}

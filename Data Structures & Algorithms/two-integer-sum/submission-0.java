class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashmap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (hashmap.containsKey(diff) && hashmap.get(diff) != i) {
                return new int[] {i, hashmap.get(diff)};
            }
        }

        return new int [0];
    }
}

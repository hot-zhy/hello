class Solution {
    public int findMaxLength(int[] nums) {
        // 前缀和+哈希表
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            int x = nums[i] == 0 ? -1 : 1;
            sum[i + 1] = sum[i] + x;
        }

        // nums[i] -> i
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int s = sum[i];
            if (map.containsKey(s)) {
                ans = Math.max(ans, i - map.get(s));
            } else {
                map.put(s, i);
            }
        }


        return ans;

    }
}
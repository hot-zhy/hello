class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> path = new ArrayList<Integer>();
        dfs(1, nums.length, path, nums);
        return res;
    }


    public void dfs(int num, int n, List<Integer> path,int[] nums){
        if(num == n){
            res.add(path);
        }
        dfs(num++, n, path, nums);
        path.add(nums[num]);
        dfs(num--, n, path, nums);
        path.remove(path.size() - 1);
    }
}
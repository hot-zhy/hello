class Solution{
    public void sortColors(int[] nums){
        int n = nums.length;

        int pointer = 0;
        // 把0移动到前面
        for(int i=0;i<n;i++){
            if(nums[i] == 0){
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer++;
            }
        }
        // 把1移动到中间
        for(int i=pointer;i<n;i++){
            if(nums[i] == 1){
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer++;
            }
        }


    }
}
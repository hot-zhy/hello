// 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

// 你可以对一个单词进行如下三种操作：

// 插入一个字符
// 删除一个字符
// 替换一个字符
class Solution {
    private char[] s, t;
    private int[][] memo;

    public int minDistance(String word1, String word2){
        s = word1.toCharArray();
        t = word2.toCharArray();

        int m = s.length;
        int n = t.length;

        memo = new int[m][n];
        for(int[] row: memo){
            Arrays.fill(row, -1);
        }

        return dfs(m-1, n-1);
    }

    public int dfs(int i, int j){
        if(i < 0){
            return j+1;
        }

        if(j<0){
            return i+1;
        }

        if(memo[i][j] != -1){
            // 计算过
            return memo[i][j];
        }

        //没有计算过，递归计算
        if(s[i] == t[j]){
            return memo[i][j] = dfs(i-1,j-1);
        }

        return memo[i][j] = Math.min(Math.min(dfs(i-1,j),dfs(i,j-1)), dfs(i-1,j-1)) + 1;

    }
}
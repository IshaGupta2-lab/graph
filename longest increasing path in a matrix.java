class Solution {
    int[][] dp;
    int n,m;
    public int longestIncreasingPath(int[][] matrix) {
        n=matrix.length;
        m=matrix[0].length;

        dp=new int[n][m];
        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,helper(matrix,i,j));
            }
        }
        return ans;
    }
    public int helper(int [][] matrix,int row,int col){
        if(dp[row][col]!=0){
            return dp[row][col];

        }
        int maxLen=1;
        if(row+1<n && matrix[row+1][col]>matrix[row][col]){
            maxLen=Math.max(maxLen,1+helper(matrix,row+1,col));
        }
        if(row-1>=0 && matrix[row-1][col]>matrix[row][col]){
            maxLen=Math.max(maxLen,1+helper(matrix,row-1,col));
        }
        if(col+1<m && matrix[row][col+1]>matrix[row][col]){
            maxLen=Math.max(maxLen,1+helper(matrix,row,col+1));
        }
        if(col-1>=0 && matrix[row][col-1]>matrix[row][col]){
            maxLen=Math.max(maxLen,1+helper(matrix,row,col-1));
        }
        dp[row][col]=maxLen;
        return maxLen;
    }
}
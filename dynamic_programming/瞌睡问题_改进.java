public class 瞌睡问题_改进{
	public static void fillDP(int[] dp,int[] arr,int[] isAwake,int k){
		for(int i  = 0;i<dp.length;i++){
			int currScore = 0;
			boolean flag_active = false;

			for(int j = 0;j<arr.length;j++){
				if(isAwake[j]==1){
					currScore += arr[j];
				}else{
					// sleep
					if(i==j && !flag_active){
						//唤醒
						flag_active = true;
						currScore += arr[j];
					}
					if(flag_active && j-i<k ){
						//已经唤醒过
						currScore += arr[j];
					}
				}
			}

			dp[i] = currScore;

		}
    }



    public static int getMaxScore(int[] dp){
        int max  = 0;
        for(int i= 0;i<dp.length;i++){
            max = max>dp[i]?max:dp[i];
        }
        return max;
    }


    public static void displayDP(int[] dp){
            for (int a : dp) {
                System.out.print(a+"\t");
            }
    }

    public static void main(String[] args) {
        int n = 7;//这堂课持续多少分钟
        int k = 3;//唤醒一次持续多久清醒的时间(分钟)
        int arr[] =     {1,3,5,2,5,4,56};//每分钟的课的价值
        int isAwake[] = {1,1,0,1,0,0,0};//每分钟是否清醒

        int[] dp  = new int[n];//dp[i] 第i次时唤醒(如果第i次是睡着的话),到第n分钟的总价值

        fillDP(dp,arr,isAwake,k);
        displayDP(dp);
        int res = getMaxScore(dp);
        System.out.println("max :"+res); // 6  6 16 6 71 66 62
    }

}

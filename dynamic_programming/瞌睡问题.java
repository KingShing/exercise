public class 瞌睡问题{

    public static void fillDP(int[][] dp,int[] arr,int[] isAwake,int k){

        for (int i  = 1; i<dp.length ;i++ ) {  //行数  从i开始唤醒(如果i是睡着的话)
            int flag_active = 0;
            for (int j  = 1; j<dp[0].length ;j++ ) {//列数 j:
                //
                int currScore ;

                //瞌睡时刻
                if(isAwake[j-1]==0){

                    if(flag_active==1){//开启唤醒
                    	/*是否过期*/
                        if(j-i<k){//未过期
                        		currScore = arr[j-1];
                        	}else{//过期
                        		currScore = 0;
                        	}
                    }else{//未开启唤醒
                        if(j==i){
                        	//第一次唤醒
                            flag_active = 1;
                            currScore = arr[j-1];
                        }else{
                        	//i!=j 不能唤醒
                        	currScore = 0;
                        }
                    }
                    //清醒时刻
                }else{
                    currScore = arr[j-1];
                }
                //
                dp[i][j] = dp[i][j-1]+currScore;
            }
        }
    }



    public static int getMaxScore(int[][] dp){
        int cow = dp[0].length-1;
        int max = 0;
        for(int i= 0;i<dp.length;i++){
            max = max>dp[i][cow]?max:dp[i][cow];
        }
        return max;
    }

    public static void initDP(int[][] dp){
        for(int i = 0;i<dp.length;i++){
            dp[i][0] = 0;
        }
    }


    public static void displayDP(int[][] dp){
        for (int[] d :dp ) {
            for (int a : d) {
                System.out.print(a+"\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 7;//这堂课持续多少分钟
        int k = 3;//唤醒一次持续多久清醒的时间(分钟)
        int arr[] =     {1,3,5,2,5,4,56};//每分钟的课的价值
        int isAwake[] = {1,1,0,1,0,0,0};//每分钟是否清醒

        int[][] dp  = new int[n+1][n+1];//dp[i][j] 第i次时唤醒(如果第i次是睡着的话),到第j分钟的总价值

        initDP(dp);
        fillDP(dp,arr,isAwake,k);
        displayDP(dp);
        int res = getMaxScore(dp);
        System.out.println("max :"+res);
    }
}

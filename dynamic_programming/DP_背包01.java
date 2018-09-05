public class DP_背包01{
	public static void solve(){
		int N = 3, V = 5;    //N是物品数量，V是背包容量
		int[] weight = {1,2,3,4,2,1};
		int[] value = {60,100,120,300,1,1};
		int[][] DP = new int[weight.length+1][V+1];
		initDP(DP);
		//填表
		fill(DP,weight,value,N,V);
		display(DP);
	}
	public static void main(String[] args) {
		solve();
	}


	public static void fill(int[][] DP,int[] weight,int[] value,int n ,int v){
		for (int i = 1;i<=weight.length ;i++ ) {
			for (int j = 1;j<=v ;j++ ) {

				if(weight[i-1]>j){//如果第i件物品的的重量>当前容量
					DP[i][j] = DP[i-1][j];
				}else{
					DP[i][j] = max(DP[i-1][j],DP[i-1][ j- weight[i-1] ]+value[i-1]);
				}
				display(DP);
				System.out.println("-总价值"+DP[i][j]+",当前容量为"+j+",物品"+(i)+"{重量:"+weight[i-1]+":价值"+value[i-1]+"}-");
			}

		}
	}


	public static void initDP(int[][] DP){
		for (int i = 0;i<DP.length ;i++ ) {
			DP[i][0] = 0;
		}

		for (int i = 0;i<DP[0].length ;i++ ) {
			DP[0][i] = 0;
		}
	}

	public static void display(int[][] a){
		for (int[] arr : a ) {
			for (int value : arr) {
				System.out.print(value+"\t");
			}
			System.out.println();
		}
	}

	public static int max(int a,int b){
		return a>b?a:b;
	}
}

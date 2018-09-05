


public class DP_最长公共子序列问题{

	public static void main(String args[]){
		int[] x = new int[]{1,2,7};//
		int[] y = new int[]{1,2,3,7};
		solve(x,y);


	}

	public static int max(int a,int b){
		return a>b?a:b;
	}

	public static void print(int[][] opt, int[] X, int[] Y, int i, int j) {

		if (i == 0 || j == 0) {
			return;
		}

		if (X[i - 1] == Y[j - 1]) {
				print(opt, X, Y, i - 1, j - 1);
				System.out.print(X[i - 1]);
        } else if (opt[i - 1][j] >= opt[i][j]) {
               print(opt, X, Y, i - 1, j);
        } else {
               print(opt, X, Y, i, j - 1);}
 	}

	//最长公共子序列问题
	public static void solve(int[] x,int[] y){
		int xlen = x.length;
		int ylen = y.length;

		//用c[i][j]记录X[i]与Y[j] 的LCS 的长度
		int [][]c = new int[xlen+1][ylen+1];

		// 初始化边界条件
        for (int i = 0; i <= xlen; i++) {
                c[i][0] = 0;//每行第一列置零
        }
        for (int j = 0; j <= ylen; j++) {
                c[0][j] = 0;//每列第一行置零
		}
        // 填充矩阵
        for (int i = 1; i <= xlen; i++) {
                for (int j = 1; j <= ylen; j++) {
                        if (x[i-1] == y[j - 1]) {
                            c[i][j] = c[i - 1][j - 1] + 1;
                        } else {
                    		c[i][j] = max(c[i-1][j],c[i][j-1]);
                        }
                }
        }


		//打印矩阵结果
		for (int i = 0;i< c.length ;i++ ) {
			for (int j = 0;j<c[0].length ;j++ ) {
					System.out.print("c["+i+"]["+j+"]:"+c[i][j]+"\t");
			}
			System.out.println();
			System.out.println();

		}

		print(c, x, y, x.length, y.length);

	}


}

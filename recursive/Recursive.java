/*手撸尾递归*/
public class Recursive{

    /* 1) 阶乘 */
    //  n 记录当前进度(乘到哪个数)
    //  res: 记录当前结果
    //  base case: 当n==1 时,直接返回res,结束
    //  common case : factorial(n,res) 依赖 factorial(n-1,res * n) 依赖 factorial(n-2,res * (n-1)) ...依赖 factorial(1,res * n *(n-1)*... * 2 * 1)
    public static int factorial(int n, int res){
        if(n == 1){
            return res;
        }
        return factorial(n-1,res * n);
    }




    /* 2)斐波那契数列  f(n) = f(n-1) + f(n-2);  1  1  2  3  5  8 13 21 ...*/
    public static int FibonacciSequence(int n){
        if(n <= 2){
            return 1 ;
        }
        return process(3,1,1,n);
    }
    // 第i项   a,b,分别是i前面两项  n为目标项
    public static int process(int i,int a,int b,int n){
        if( i == n){
            return  a+b;
        }
        return process(i+1,b,a+b,n);
    }





    /* 3) 汉罗塔问题*/
    public static void  hanROMtower(int n){
        move(n,n,"left","mid","right");
    }

    //  把剩余共rest个卡片,全部从 left移动到right的位置,down记录当前left底部的卡片
    public static void move(int rest,int down,String left,String mid,String right){
        if(rest == 1){
            println("move "+down+" from "+left+" to "+right);
            return ;
        }
        // 1) 把n-1个卡片从left移动到mid
            move(rest-1,down-1,left,right,mid);
        // 2) 把最底部卡片从left移动到right
            move(1,down,left,mid,right);
        // 3) 把n-1个卡片从mid移动到right
            move(rest-1,down-1,mid,left,right);
    }





    /* 4)  01背包问题 递归版本 */
    public static int maxValue(int[] weights, int[] values, int bag) {
		return package01(weights, values, 0, 0, bag);
	}

	public static int package01(int[] weights, int[] values, int i, int alreadyweight, int bag) {
		if (alreadyweight > bag || i == weights.length) {
			return 0;
		}
        int v1 = package01(weights, values, i + 1, alreadyweight, bag);//不放
        int v2 = values[i] + package01(weights, values, i + 1, alreadyweight + weights[i], bag);//放入
		return Math.max(v1,v2);
	}

    


    public static void main(String[] args) {
        //int res = factorial(4,1);
        //print(res);

        //int r = FibonacciSequence(6);
        //print(r);
        hanROMtower(3);
        int[] c = { 3, 2, 4, 7 };
		int[] p = { 5, 7, 3, 15 };
		int bag = 11;
		println("maxValue "+maxValue(c, p, bag));
    }

    public static void print(Object o){
        System.out.print(o);
    }
    public static void println(Object o){
        System.out.println(o);
    }
}

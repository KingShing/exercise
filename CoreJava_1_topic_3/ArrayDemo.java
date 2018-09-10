import java.util.Arrays;
public class ArrayDemo{
    public static void main(String[] args) {
        //数组动态初始化 ,静态初始化 (略)
        // TODO

        //java中允许下面的操作 但意义何在 who care
        int[] arr  = new int[0];

        //打印数组最简单的方式
        int[] a = {1,2,3,4};
        System.out.println(Arrays.toString(a));//[1, 2, 3, 4]

        //数组的拷贝 第一个参数 是要拷贝的数组  第二个参数是 新数组的长度 ,如果小于,只拷贝一部分,大于部分用默认值填充
        int[] a_ = Arrays.copyOf(a,a.length<<1);
        System.out.println(Arrays.toString(a_));// [1, 2, 3, 4, 0, 0, 0, 0]


        //排序 算法: 优化后的快速排序 nlogn
        Arrays.sort(arr);


        //二维数组的初始化
        //动态初始化
        int[][] dp1 = new int[3][4];  // 3行(row) 4列(col)
        //静态初始化
        int[][] dp = {{1,2,4,5},{2,3,3,4},{1,1,2,2}};
        // 1) print method1
        for (int[] aa : dp) {
            System.out.println(Arrays.toString(aa));
        }
        /**  out
            [1, 2, 4, 5]
            [2, 3, 3, 4]
            [1, 1, 2, 2]
        */

        // 2) print method2
        System.out.println(Arrays.deepToString(dp));
        //[[1, 2, 4, 5], [2, 3, 3, 4], [1, 1, 2, 2]]

        //java 中 实际上没有多维数组 ,只有一维数组,这也正是java的优势所在
        //  多维数组被解释为 数组的数组
        // 上述 dp[][] 中的 dp[i] 引用第i个子数组 ; dp[i][j] 引用这个数组的第j项

        // 弄清楚上面的意思 就能做到 让数组的第i行和第j行 做交换 dp[][]

            // int[] temp  = dp[i];
            // dp[i] = dp[j];
            // dp[j] = temp;

        // 所以 java中可以有不规则数组(每一行长度不等) 比如 将dp[0] = {1};
        // 或者直接静态初始化
        int [][] no_regular = {{1},{2,3},{4,5,6}};//这是合法的
        System.out.println(Arrays.deepToString(no_regular));




    }
}

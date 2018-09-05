import java.util.Arrays;
public class FindNeighborMaxValue{
    //给定一个数组排序后,  找出数组最大差值,这个两个数索引必须相邻 要求时间复杂度 O(N)

    public static int solve(int[] arr){
        int len = arr.length;
        int min = arr[0];
        int max = arr[0];
        for (int a: arr ) {
            max = max >a? max:a;
            min = min <a? min:a;
        }
        int[] perbucketMax = new int[len+1];
        int[] perbucketMin = new int[len+1];
        boolean[] perbucketIsHave = new boolean[len+1];

        for (int value : arr) {
            //判断 一个数该丢进那个桶
            int bucketIndex = (value - min) * len / (max - min);
            bucketInsert(perbucketMax,perbucketMin,perbucketIsHave,value,bucketIndex);
        }
        int res = 0;
		//int lastMax = perbucketMax[0];
        int last = 0;
		for (int i = 1; i < perbucketIsHave.length; i++) {
			if (perbucketIsHave[i]) {
				res = Math.max(res, perbucketMin[i] - perbucketMax[last]);
				//lastMax = perbucketMax[i];
                last++;
			}
		}
        return res;
    }
    public static void bucketInsert(int[] perbucketMax,int[] perbucketMin,boolean[] perbucketIsHave,int value,int bucketIndex){
            int i = bucketIndex;
            if(!perbucketIsHave[i]){
                //桶空的
                perbucketMax[i]= value;
                perbucketMin[i]= value;
                perbucketIsHave[i] = true;
            }else{
                //桶非空
                perbucketMax[i] = perbucketMax[i]>value? perbucketMax[i]:value;
                perbucketMin[i] = perbucketMin[i]<value? perbucketMin[i]:value;

            }

    }
    public static void printArray(int[] arr){
        for (int a :arr ) {
            System.out.print(a+" ");
        }
        System.out.println();
    }

    public static void printArray(boolean[] arr){
        for (boolean a :arr ) {
            System.out.print(a?"T ":"F ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {1,11,23,43,56,68,75,87,2,29,101};
        int res = solve(arr);
        System.out.println("myMethod's res :"+res);

        Arrays.sort(arr);
        int rightRes = rightMethod(arr);
        System.out.println("rightRes  "+rightRes);

    }


    public static int rightMethod(int[] arr){
        int res = 0;
        for (int i = 0;i<arr.length-1 ;i++ ) {
            int value = arr[i+1]-arr[i];
            res = value > res? value:res;
        }
        return res;
    }
}

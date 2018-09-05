public class CountSort {
    //计数排序 O(N)目前算法O()最小的排序  only value 0 - 200  value不能有负数 最大值越大 性能越低 适用于分数排序 
    //@SortAnnotation
    public static void CountSort(int[] arr){
        CountSort(arr,0,arr.length-1);
    }

    public static void CountSort(int[] arr,int l,int r){
        int max = arr[l];
        for(int i = l;i <= r;i++){
            max = arr[i]>max? arr[i]:max;
        }
        int[] bucket = new int[max+1];
        for(int i = l;i <= r;i++){
            bucket[ arr[i] ]++;
        }
        // copy
        int index = l-1;
        for (int value = 0;value < bucket.length;value++) {
            while(bucket[value]-- > 0){
                arr[++index] = value;
            }
        }

    }

    public static void  swap(int[] arr,int a,int b){
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }
    public static void printArray(int[] arr){
        for (int a :arr ) {
            System.out.print(a+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[]{10,9,8,2,4,3,1,0};
        printArray(arr);
        CountSort(arr);
        printArray(arr);
    }
}

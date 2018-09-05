public class InsertSortDemo {

	// O(n^2) 额外空间复杂度O(1)
	@SortAnnotation
	public static void insertSort(int[] arr){
		//前面left = 1 都是排好序的,后面的插入有序序列相应位置中
		for (int left = 1;left <= arr.length-1 ;left++ ) {
			for(int cur = left; cur>0 && arr[cur]<arr[cur-1] ;cur--){
				swap(arr,cur,cur-1);
			}
		}


	}
	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	public static void display(int[] arr){
		for (int a :arr ) {
			System.out.print(a+"\t");
		}
	}
	public static void main(String[] args) {
		int [] arr ={4,2,3,5,1};
		insertSort(arr);
		display(arr);
	}
}

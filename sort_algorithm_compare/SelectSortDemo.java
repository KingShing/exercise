public class SelectSortDemo{


	// O(n^2)  额外空间复杂度O(1)
	@SortAnnotation
	public static void selectSort(int[] arr){
		if(arr == null || arr.length < 2)
			return;
		for(int left = 0;left < arr.length;left++){
			int minIndex = left;
			for(int i = left+1;i < arr.length;i++){
				minIndex = arr[minIndex]>arr[i]? i:minIndex;
			}
			swap(arr,minIndex,left);
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
		int [] arr ={-8, -39, 57, -33};
		selectSort(arr);
		display(arr);
	}
}

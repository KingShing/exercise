import java.lang.reflect.*;
public class BubbleSort{
	// O(n^2) 额外空间复杂度O(1)
	@SortAnnotation
	public static void bubbleSort(int [] arr){
		if(arr == null || arr.length < 2)
			return;

		for(int end = arr.length-1;end >= 0;end--){
			for(int i = 0;i<end;i++){
				if(arr[i]>arr[i+1]) swap(arr,i,i+1);
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
		bubbleSort(arr);
		display(arr);
	}
}

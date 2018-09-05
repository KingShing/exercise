public class MergeSortDemo{
	//归并排序 O(N*logN) 额外空间复杂度O(N)
	@SortAnnotation
	public static void mergeSort(int [] arr){
		if(arr == null || arr.length < 2)
			return;
		mergeSort(arr,0,arr.length-1);
	}
	// 递归折半排序 外排合并
	public static void mergeSort(int [] arr,int l,int r){
		if(l==r) {
			return ;
		}
		int mid = l+(r-l)/2;
		mergeSort(arr,l,mid);
		mergeSort(arr,mid+1,r);
		merge(arr,l,mid,r);
	}

	public static void merge(int[] arr,int l,int mid,int r){
		int p1 = l ;
		int p2 = mid + 1 ;
		int cur = 0 ;
		int[] help  = new int[r-l+1];

		while(p1 <= mid && p2 <= r){
			help[cur++] = arr[p1] <= arr[p2]? arr[p1++]:arr[p2++];
		}

		while(p1 <= mid){
			help[cur++] = arr[p1++];
		}

		while(p2 <= r){
			help[cur++] = arr[p2++];
		}

		//copy array
		for (int i =0;i<help.length ;i++ ) {
			arr[l+i]  = help[i];
;		}

	}




	public static void display(int[] arr){
		for (int a :arr ) {
			System.out.print(a+"\t");
		}
	}
	public static void main(String[] args) {
		int [] arr ={2,-1,4,2,0,3,5,1,7,2};
		mergeSort(arr);
		display(arr); //-1	0	1	2	2	2	3	4	5	7
	}
}

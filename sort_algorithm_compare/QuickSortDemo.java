public class QuickSortDemo{
	//随机快速排序 O(N*logN) 额外空间复杂 O(logN) [这个空间用来记录断点left和right]
	@SortAnnotation
	public static void quickSort(int [] arr){
		quickSort(arr,0,arr.length-1);
	}

	/*   递归分区 [ (小于区) (等于区) (大于区) ]  直到该区只剩一个元素 */
	public static void quickSort(int [] arr,int l,int r){
		if(l>r) return;
			int value = arr[l+(int)((r-l+1)*Math.random())];
			int[] part = partition(arr,l,r,value);
			quickSort(arr,l,part[0]-1);
			quickSort(arr,part[1]+1,r);

	}

	// return 等于区的起始坐标和结束坐标
	public static int[] partition(int[] arr,int l,int r,int value){

		int left = l-1;
		int right = r+1;
		int cur = l;
		while(cur < right){
			if(arr[cur] > value)
				swap(arr,--right,cur);
			else if(arr[cur] < value)
				swap(arr,++left,cur++);
			else
				cur++;
		}
		return new int[]{left+1,right-1};
	}

	public static void  swap(int[] arr,int i,int j){
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
		int [] arr ={4,2,3,3,3,5,1};

		quickSort(arr);
		display(arr);//1	2	3	3	3	4	5
	}
}

public class HeapsortDemo{
	// O(N*logN) 额外空间复杂度O(1)
	@SortAnnotation
	public static void heapSort(int[] arr){
		heapInit(arr);
		int len = arr.length;
		while(len>0){
			swap(arr,0,--len);
			heapify(arr,len,0);
		}
	}


	public static int[] heapSort(int[] arr,int heapSize){

		int[] help = heapInit(arr,heapSize);
		while(heapSize>0){
			swap(help,0,--heapSize);
			heapify(help,heapSize,0);
		}
		return help;
	}

	public static int[] heapInit(int[] arr,int heapSize){
		int[] help = new int[heapSize];
		for (int i = 0;i<heapSize ;i++ ) {
			heapInsert(help,i,arr[i]);
		}
		return help;
	}


	public static void heapInit(int[] arr){
		int[] help = new int[arr.length];
		for (int i = 0;i<help.length ;i++ ) {
			heapInsert(help,i,arr[i]);
		}
		int i  = 0;
		for (int a : help) {
			arr[i++] = a;
		}
	}

	public static void heapInsert(int[] arr,int index,int value){
		arr[index] = value;
		while(index>=0){
			int parent =  (index-1)/2;
			if(arr[parent] < arr[index]) {
				swap(arr,parent,index);
				index = parent;
			}else{
				break;
			}

		}
	}

	public static void heapify(int[] arr,int heapSize,int index){
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < heapSize) {
			if (arr[left] > arr[index]) {
				largest = left;
			}
			if (right < heapSize && arr[right] > arr[largest]) {
				largest = right;
			}
			if (largest != index) {
				swap(arr, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}


	}

	public static void display(int[] arr){
		for (int a :arr ) {
			System.out.print(a+"\t");
		}
		System.out.println();
	}

	public static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		int [] arr =new int[]{-3,-9,0,2,2,6,8,4,3,9,9};
		int [] res = heapSort(arr,arr.length);
		heapSort(arr);
		display(arr); //-9	-3	0	2	2	3	4	6	8	9	9
		display(res); //-9	-3	0	2	2	3	4	6	8	9	9

	}
}

import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.annotation.Annotation;

public class  SortUtil{

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public  static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public  static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }


    public  static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public  static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }




    public static  void testSort(Object object,Method m) throws  Exception{
        int testTime = 500000;
        int maxSize = 45;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);

            m.invoke(object,arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "牛逼,"+m.getName()+" 算法对了!" :
                                    "fuck! "+m.getName()+" 算法错了!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        System.out.println(m.getName()+"排序前:");
        printArray(arr);
        m.invoke(object,arr);//测试的算法
        System.out.println(m.getName()+"排序后:");
        printArray(arr);
        System.out.println();
    }


    public static void  test(String className){

        try {
            Class clazz = Class.forName(className);
            Object object = clazz.newInstance();
            Method[] methods = clazz.getMethods();
            boolean haveAnnotation = false;
            for (Method m : methods) {
                if(m.isAnnotationPresent(SortAnnotation.class)){
                    SortUtil.testSort(object,m);
                    haveAnnotation = true;
                    break;
                }
            }
            if(!haveAnnotation)
                 throw new Exception("未找到带有SortAnnotation注解的排序方法!");
        } catch(Exception e) {
             e.printStackTrace();
        }

    }

}

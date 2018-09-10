public class ShiftDemo{
    //java 移位运算符
    public static void main(String[] args) {

        /* 1) 快速上手*/
        int a = 8;
        //右移三位
        System.out.println(a>>3); // 2  等价于:8/(2^3)
        //左移三位
        System.out.println(a<<3); // 32 等价于:8*(2^3)

        /* 2) 本质分析 */
        String binaryA = java.lang.Integer.toBinaryString(a);
        System.out.println(binaryA); // 1000
        // 8转二进制--> 1000 ---左移两位--> 100000 转十进制-> 32
        // 右移同理

        //注意 java 中 int类型占4字节 共4*8=32位 如果我左移33位,会怎样?
        // 答案是超过部分再从头移动  相当于真正移动的是  33%32 = 1位 (模32)
        System.out.println(a<<1);   // 16
        System.out.println(a<<33);  // 16

        //对于long类型  占8字节  8*8 = 64  位 ,即模64
        //对于浮点类型不支持移位操作,编译报错


        // 3) 补充 常见用法
        //old
            int num = 4;
            int res1 = num/2; //求一个数的一半
            int res2 = 2*num;  // 2倍
            System.out.println(res1); //2
            System.out.println(res2); // 8

        // now
            res1  = num >> 1;
            res2 = num << 1;
            System.out.println(res1); //2
            System.out.println(res2); // 8
        // 好处  : 移位运算的性能远大于算数运算 在jdk源码中很多移位运算
        // 其他相关 :
        //     ^ 按位异或运算符
        //     ~ 非运算符
        //     & 与运算符
        //     | 或运算符

        // ^ eg swap(int[] arr,int a,int b);
        int[] arr = {1,2,3};
        swap(arr,0,2); // arr: 3 2 1
    }
    public static void swap(int[] arr,int a,int b){ //性能较高
         arr[a] = arr[a] ^ arr[b];
         arr[b] = arr[a] ^ arr[b];
         arr[a] = arr[a] ^ arr[b];
    }
}

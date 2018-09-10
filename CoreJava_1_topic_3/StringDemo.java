public class StringDemo{
    public static void main(String[] args) {
        // 创建String 的内存分配问题
        /* java 设计者认为共享的效率远远胜过提取和拼接(修改)字符串,
        方式一:
            所以 String a = "xxx" 一旦创立,"xxx"这块内存的值不能更改,
            对于操作 a = "xxx2"; 来说 只不过是重新开辟一块空间,存放xxx2 并将a指向它
        方式二:
            String str1 = new String("xxx");
            String str2 = new String("xxx");
            str1==str2 //false

        重点:   对于字符串常量采取字符串常量存储池
       */
        //这里的a和b指向同一块内存地址,都是从常量池找,如果有指向它 ,没有开创一块
        String a = "hello";
        String b = "hello";
        System.out.println(a==b);  //true

        //特殊
        String c  = "helloworld";
        b+="world";
        System.out.println(c==b); //false

        String d = new String("hello");
        String e = new String ("hello");
        System.out.println(d==e); //false
        System.out.println(d==a); //false


    }
}

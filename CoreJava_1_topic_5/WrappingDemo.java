import java.text.NumberFormat;
public class WrappingDemo{
    public static void main(String[] args)throws Exception {

        /*
            Integer == 的不确定性 ,包装类,使用 equals(),不要使用==
        */
        Integer n1 = 100;
        Integer n2  = 100;
        System.out.println(n1 == n2); //true


        Integer n3 = 200;
        Integer n4  = 200;
        System.out.println(n3 == n4); //false

        //上述现象的原因

        // 自动打包规范要求 boolean,byte,char<=127,介于-128~127之间的short和int被包装到
        // <strong>固定的</strong>对象中,所以当n =100时,n1和n2指向的是同一个对象,
        //当n>127时,就不是了,所以当n=200,时,就是两个Integer对象,对于引用类型,==判断的是内存地址
        // 故返回false

        /* Number 类 */
        // 默认根据本地数字格式,NumberFormat.getInstance(xx); xx是本地数字格式(阿拉伯数字),
        //像罗马数字, 就不能使用默认值

        Number num = NumberFormat.getInstance().parse("123.23");
        System.out.println(num);


    }
}

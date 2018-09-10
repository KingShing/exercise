import java.math.*;
public class MathDemo{
//实际项目开发中,对于金钱 都用 BigDecimal 作为数据类型 而不是double或者float
    /* BigDecimal(小数任意长度的运算) BigInteger(支持整数任意长度的运算) 这两个能够处理任意长度的数字序列的数值 */
    //缺点就是没有运算符重载(java不支持,c++支持),运算都要通过函数来解决
    public static void main(String[] args) {

        BigDecimal res;
        //使用方式
        BigDecimal n = BigDecimal.valueOf(100.23);

        //+ - * /
        //乘
        res  = n.multiply(n); // n *n

        //除
        n.divide(n); // n/n

        //加
        n.add(n);// n + n

        //减
        res = n.subtract(n); // n - n

        // 模
        res = n.mod(xxx);

        // a.compareTo(b) return:(负数) 0 (正数) 分别对应 a<b a=b a>b



    }
}

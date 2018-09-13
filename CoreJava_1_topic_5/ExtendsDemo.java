public class ExtendsDemo extends Base{
/**
    @Override
    覆盖注意点:
        1)方法签名一致 ,签名指 methodName parameterCount parameterType都一样
        2)对于返回值: 1.5 之前  要求返回值一致 ;1.5之后 子类的返回值类型可以是父类返回值类型的子类
        3)对于权限:子类 >= 父类的权限,否则报错 : "试图降低访问权限 "
        4)如果想调用父类被覆盖的方法,加关键字super
    */
    @Override
    public ExtendsDemo method(){
        return null;
    }

    //对于方法的重载 只看参数类型和个数
    // 返回值啊  修饰符啊  都不作为重载的依据 ,出现了直接报错: method xxx() is already defined
    // 换句话说  如果 签名相同,返回值不同 ,编译器根本不能区分二者 ,直接报错,不可能动态调用




    /*阻止继承*/

    //如果一个类 被修饰为final
    // 那么该类 根本不能被继承  如java中的String类 Arrays 等
    // jdk的设计者 认为该类功能已经全部实现 ,很全面,不需要扩充,也禁止更改
    // 注意:类 被final修饰  那么所有的 method自动被final修饰  ,field除外

    //final 修饰 method
    // 该 method 不能被子类重写
    // 如 Calendar类中的 getTime() setTime()都是final修饰的
    // 这表面calendar类的设计者负责实现Date类和日历状态的转换,不允许子类处理这些问题


    // 题外话 : 函数重载(动态绑定) 会降低性能
    // 所以有的语言出现了内联函数 inlining
    // java中方法 加了final关键字,就避免了动态绑定带来额外的系统开销,编译器就会对这种情况进行优化
    // 也就叫做内联


    public static void main(String[] args) {
        System.out.println("hello");
    }
}

class Base{
    protected  Base method(){
        return null;
    }
}

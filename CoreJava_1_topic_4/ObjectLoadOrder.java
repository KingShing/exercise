public class ObjectLoadOrder{
    // 执行的先后顺序
    // static block > block > constractor
    // 注意的是:如果不创建对象 block 是不会被执行的 

    private int age;


    public ObjectLoadOrder(int age){
        this.age = age;
        System.out.println("constractor is loading ..");
    }
    //block 加载的时机
    {
        System.out.println("block is loading ..");
    }

    //   static block
    static{
        System.out.println("static block is loading ..");
    }
    public static void main(String[] args) {
        ObjectLoadOrder a = new ObjectLoadOrder(2);
    }
}

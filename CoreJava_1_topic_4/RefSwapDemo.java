class Student{
    private String name;
    private int age;
    // constractor
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return "name: "+name+" age:"+age;
    }

    public  void innerswap(Student s2){
        Student temp = this;
        this = s2; // 实际this 是被final修饰过的,这句执行时会报错
        s2 = temp;
    }

}


public class RefSwapDemo{
    //这是一个无效的方法
    public static void swap(Student x,Student y){
        Student temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        Student s1 = new Student("king",18);
        Student s2 = new Student("ww",17);
        swap(s1,s2);  // 无效
        System.out.println(s1); //name: king age:18
        System.out.println(s2); //name: ww age:17

        // s1.innerswap(s2); // 报错 this final修饰 不能改
        // 上述swap无效的原因
        // java的方法中的参数不是引用调用(如果在c++中,上述swap是成功的)
        // swap方法参数的x,y被初始化为s1和s2两个对象引用的拷贝
        // 所以方法体内,只是把这份拷贝的 数据做了交换,原引用并没有改
        

    }
}

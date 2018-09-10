public class LoopDemo{
    public static void main(String[] args) {
        // break ;
        //带标签的break;  语法 label:for(;;){ break label;}


        xxx:for (int i = 0;i<10;i++ ) {
                    for (int j = 0;j<10 ;j++ ) {
                            if(i==2) break xxx;
                    }
                }

        // 上述代码 执行到i =2时,会跳出外层循环,(当然内层循环也跳出了)
        // 如果直接 break;默认跳出内层循环

        //实际上  可以将标签用到任何语句中
        // 如if 或者块语句中


        //continue 跳过当前轮,进入下一轮循环


        
    }
}

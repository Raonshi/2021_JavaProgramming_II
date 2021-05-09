/*
작성자 : 홍순원
작성일 : 2021-05-09
 */

//스레드를 생성하는 클래스를 생성
//과제 내용에 알맞은 작업 수행만을 하기 위함
class MyRun implements Runnable{

    String name;
    boolean isAsc;

    public MyRun(String name, boolean isAsc){
        this.name = name;
        this.isAsc = isAsc;
    }
    public void run()
    {
        if(isAsc == true)
        {
            for(int i = 0; i <= 10; i++)
            {
                System.out.print(name + i + " ");
            }
        }
        else
        {
            for(int i = 10; i >= 0; i--)
            {
                System.out.print(name + i + " ");
            }
        }
    }
}

public class Main {
    public static void main(String[] arg)
    {
        Thread t1 = new Thread(new MyRun("A", false));
        Thread t2 = new Thread(new MyRun("B", true));

        t1.start();
        t2.start();
    }
}

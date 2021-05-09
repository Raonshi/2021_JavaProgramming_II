public class Main {
    public static void main(String[] arg)
    {
        Runnable task1 = () -> {
            for(int i = 10; i >= 0; i--)
            {
                System.out.print("A" + i + " ");
            }
        };

        Runnable task2 = () -> {
            for(int i = 10; i >= 0; i--)
            {
                System.out.print("B" + i + " ");
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}

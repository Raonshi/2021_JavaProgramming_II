import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class FileInfoServer {

    public static void main(String[] args) throws IOException {
        //포트번호 10110으로 소켓 생성
        ServerSocket socket = new ServerSocket(10110);

        try{
            while(true){
                //소켓 객체 생성
                Socket s = socket.accept();

                try{
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                    File path = new File(System.getProperty("user.home"));

                    File[] list = path.listFiles();
                    for(int i = 0 ; i < list.length; i++){
                        out.println(list[i]);
                    }
                }
                finally {
                    s.close();
                }
            }
        }
        finally {
            socket.close();
        }
    }
}

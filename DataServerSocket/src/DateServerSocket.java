import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DateServerSocket {
    public static void main(String[] arg) throws IOException {
        ServerSocket ss = new ServerSocket(9100);

        try{
            while(true){
                Socket socket = ss.accept();

                try{
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(new Date().toString());
                }finally {
                    socket.close();
                }
            }
        }finally {
            ss.close();
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class FileInfoClient {

    public static void main(String[] arg) throws IOException {
        Socket socket = new Socket("localhost", 10110);

        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String res = null;
        /*
        String res = reader.readLine();
        System.out.println(res);
        res = reader.readLine();
        System.out.println(res);
        */
        while((res = reader.readLine()) != null){
            System.out.println(res);
        }
        System.exit(0);
    }
}

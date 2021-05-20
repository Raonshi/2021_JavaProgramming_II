import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


public class Server {

    public static void main(String[] arg) throws IOException {
        System.out.println("서버를 실행합니다.");
        int clientId = 0;

        ServerSocket serverSocket = new ServerSocket(10110);

        try{
            while(true){
                clientId++;
                Translator trans = new Translator(serverSocket.accept(), clientId);
                trans.start();
            }
        }finally {
            serverSocket.close();
        }
    }

    static class Translator extends Thread{
        Socket socket;
        int clientId;

        public Translator(Socket socket, int clientId){
            this.socket = socket;
            this.clientId = clientId;
        }

        public void run(){
            try{
                WordSet word = new WordSet();
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("안녕하세요. 클라이언트" + clientId + "번 님.");
                out.println("단어를 입력해주세요.");

                while(true){
                    String input = reader.readLine();

                    if(input == null){
                        break;
                    }


                }
            }
            catch(IOException ioException){
                ioException.printStackTrace();
            }

        }
    }
}

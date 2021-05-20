import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TranslationClient extends JFrame implements ActionListener {
    //IO 객체
    private BufferedReader in;
    private PrintWriter out;

    //GUI위젯 객체
    private JTextField field;
    private JTextArea area;

    //GUI 설정
    public TranslationClient() throws Exception, IOException{
        //프레임 설정
        setTitle("클라이언트");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //텍스트필드 설정
        field = new JTextField(50);
        field.addActionListener(this);

        //텍스트영역 설정
        area = new JTextArea(10, 50);
        area.setEditable(false);

        //GUI화면에 추가
        add(field, BorderLayout.NORTH);
        add(area, BorderLayout.CENTER);

        //소켓통신을 위해 서버와 동일한 포트번호로 소켓 생성
        Socket socket = new Socket("localhost", 9101);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        //텍스트영역에 서버로부터 읽어온 스트림을 출력 후 줄 바꿈
        area.append(in.readLine() + "\n");
        area.append(in.readLine() + "\n");
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        out.println(field.getText());
        String response = null;

        try{
            response = in.readLine();
        }catch(IOException exception){
            exception.printStackTrace();
        }
        area.append(response + "\n");
    }

    public static void main(String[] arg) throws Exception{
        TranslationClient client = new TranslationClient();
    }
}
